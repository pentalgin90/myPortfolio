package by.home.accountservice.controller;

import by.home.accountservice.domain.Spend;
import by.home.accountservice.service.ServiceSpend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("spend")
@Slf4j
public class SpendController {

    private final ServiceSpend serviceSpend;

    @Autowired
    public SpendController(ServiceSpend serviceSpend){
        this.serviceSpend = serviceSpend;
    }

    @GetMapping
    public List<Spend> getSpends() {
        return serviceSpend.getAllSpend();
    }

    @GetMapping("{id}")
    public Spend getOneSpend(@PathVariable("id") Long id) {
        return serviceSpend.getOneSpend(id);
    }

    @PostMapping
    public Spend create (@RequestBody Spend spend){
        spend.setDateEvent(new Date());
        return serviceSpend.createOrUpdateSpend(spend);
    }

    @PutMapping
    public Spend update(Spend spendFromDb,
                        @RequestBody Spend spend){
        BeanUtils.copyProperties(spend, spendFromDb, "id");
        return serviceSpend.createOrUpdateSpend(spendFromDb);
    }

    @DeleteMapping
    public void delete(Spend spend){
        serviceSpend.deleteSpend(spend);
    }
}