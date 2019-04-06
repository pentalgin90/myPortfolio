package by.home.accountservice.controller;

import by.home.accountservice.domain.Spend;
import by.home.accountservice.repo.SpendDetailsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("spend")
@Slf4j
public class MainController {

    private final SpendDetailsRepo spendDetailsRepo;

    @Autowired
    public MainController(SpendDetailsRepo spendDetailsRepo){
        this.spendDetailsRepo = spendDetailsRepo;
    }

    @GetMapping
    public List<Spend> getSpends() {
        return spendDetailsRepo.findAll();
    }

    @GetMapping("{id}")
    public Spend getSpend(@PathVariable("id") Spend spend) {
        return spend;
    }

    @PostMapping
    public Spend create (@RequestBody Spend spend){
        spend.setDateEvent(new Date());
        return spendDetailsRepo.save(spend);
    }

    @PutMapping
    public Spend update(Spend spendFromDb,
                        @RequestBody Spend spend){
        BeanUtils.copyProperties(spend, spendFromDb, "id");
        return spendDetailsRepo.save(spendFromDb);
    }

    @DeleteMapping
    public void delete(Spend spend){
        spendDetailsRepo.delete(spend);
    }
}