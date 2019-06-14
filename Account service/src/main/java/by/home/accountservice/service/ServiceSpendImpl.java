package by.home.accountservice.service;

import by.home.accountservice.domain.Spend;
import by.home.accountservice.repo.SpendDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceSpendImpl implements ServiceSpend{

    private final SpendDetailsRepo spendDetailsRepo;

    @Autowired
    public ServiceSpendImpl(SpendDetailsRepo spendDetailsRepo){
        this.spendDetailsRepo = spendDetailsRepo;
    }

    @Override
    public List<Spend> getAllSpend() {
        return spendDetailsRepo.findAll();
    }

    @Override
    public Spend getOneSpend(Long id) {
        return spendDetailsRepo.getOne(id);
    }

    @Override
    public Spend createOrUpdateSpend(Spend spend) {
        return spendDetailsRepo.save(spend);
    }

    @Override
    public void deleteSpend(Spend spend) {
        spendDetailsRepo.delete(spend);
    }
}
