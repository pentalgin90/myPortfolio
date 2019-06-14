package by.home.accountservice.service;

import by.home.accountservice.domain.Usr;

import java.util.List;

public interface ServiceUsr {
    List<Usr> getAllUsers();
    Usr getOneUser(Long id);
    Usr createOrUpdateUser(Usr user);
    void deleteUser(Usr user);
}
