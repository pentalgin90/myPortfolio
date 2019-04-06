function getIndex(list, id) {
    for(var i = 0; i < list.length; i++){
        if(list[i].id === id){
            return i;
        }
    }

    return -1;
}
var spendApi = Vue.resource('spend');
var ratesApi = Vue.resource('rates');
Vue.component('spend-form', {
    props: ['spends', 'spendAttr'],
    data: function () {
            return{
                name: '',
                costs: '',
                id: ''
            }
    },
    watch:{
        spendAttr: function(newVal, oldVal){
          this.id = newVal.id;
          this.name = newVal.name;
          this.costs = newVal.costs;
      }
    },
   template:
            '<div>'+
                '<input type="text" placeholder="Write some text" v-model="name"/>' +
                '<input type="number" placeholder="Write some text" v-model="costs"/>' +
                '<input type="button" value="Save" @click="save"/>' +
            '</div>',
    methods:{
        save: function () {
            var spend = {name: this.name, costs: this.costs};
            if(this.id) {
                spendApi.update({id: this.id}, spend).then(result =>
                    result.json().then(data => {
                        var index = getIndex(this.spends, data.id)
                        this.spends.splice(index, 1, data);
                        this.name = '';
                        this.costs = 0;
                        this.id = '';
                    })
                )
            } else {
                spendApi.save({}, spend).then(result =>
                    result.json().then(data => {
                        this.spends.push(data);
                        this.name = '';
                        this.costs = 0;
                    })
                )

            }
        }
    }
});
Vue.component('spends-row', {
    props: ['spend', 'editMethod', 'spends', 'selected'],
    template: '<div>' +
        '<i>({{ spend.id }})</i>{{ spend.name }} {{ spend.costs * selected }}' +
        '<span style="position: absolute; right: 0">' +
        '<input type="button" value="Edit" @click="edit"/>' +
        '<input type="button" value="X" @click="del"/>' +
        '</span>' +
        '</div>',
    methods: {
        edit:function () {
            this.editMethod(this.spend);
        },
        del: function () {
            spendApi.remove({id: this.spend.id}).then(result => {
                if (result.ok) {
                    this.spends.splice(this.spends.indexOf(this.spend), 1)
                }
            })
        },
    }
});

Vue.component('spends-list',{
    props: ['spends', 'selected'],
    data: function(){
      return{
          spend: null
      }
    },
    template: '<div>' +
        '<spend-form :spends = "spends" :spendAttr="spend"/>' +
        '<spends-row style="position: relative; width: 300px" v-for="spend in spends" :key = "spend.id" :spend = "spend" ' +
        ':editMethod="editMethod" :spends="spends" :selected="selected"/>' +
        '</div>',
    created: function () {
        spendApi.get().then(result =>
            result.json().then(data =>
                data.forEach(spend => this.spends.push(spend))
            )
        )
    },
    methods:{
        editMethod: function (spend) {
            this.spend = spend;
        }
    }
});

Vue.component('rates-list',{
    props: ['rates', 'selected', 'editSelected'],
    data:function(){
        return{
            cost: this.selected
        }
    },
   template:
       '<div>' +
       '<select v-model="cost" @change="edit">' +
       '<option v-for="rate in rates" :key="rate.shortName" v-bind:value="rate.cost">{{ rate.shortName }}</option>' +
       '</select>' +
       '<span>{{ Math.round(parseFloat(cost) * 100) / 100 }}</span>' +
       '</div>',
    created: function () {
        ratesApi.get().then(result =>
            result.json().then(data =>
                data.forEach(rate => this.rates.push(rate))
            )
        )
    },
    methods:{
        edit:function () {
            this.editSelected(this.cost);
        }
    }
});

var app = new Vue({
    el:'#app',
    template: '<div>' +
        '<spends-list :spends="spends" :selected="selected"/>' +
        '<rates-list :rates="rates" :selected="selected" :editSelected="editSelected"/>' +
        '</div>',
    data: {
        spends: [],
        rates: [],
        selected: '65.27375'
    },
    methods:{
        editSelected:function (cost) {
            this.selected = cost;
        }
    }
});