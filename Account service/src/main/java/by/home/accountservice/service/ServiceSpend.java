package by.home.accountservice.service;

import by.home.accountservice.domain.Spend;

import java.util.List;

public interface ServiceSpend {

    List<Spend> getAllSpend();
    Spend getOneSpend(Long id);
    Spend createOrUpdateSpend(Spend spend);
    void deleteSpend(Spend spend);
}
