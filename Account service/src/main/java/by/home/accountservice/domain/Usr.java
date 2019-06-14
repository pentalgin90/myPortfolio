package by.home.accountservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usr")
@ToString(of = {"id", "username", "salary"})
@EqualsAndHashCode(of = {"id"})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usr {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String lastname;
    private Integer salary;
    private String email;
    private String defaultCurrency;
    @OneToMany
    private List<Spend> spends;
    @OneToMany
    private List<Goal> goals;

    public Usr(){

    }

    public Usr(String username, String lastname, String email){
        this.username = username;
        this.lastname = lastname;
        this.email = email;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Spend> getSpends() {
        return spends;
    }

    public void setSpends(List<Spend> spends) {
        this.spends = spends;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }
}
