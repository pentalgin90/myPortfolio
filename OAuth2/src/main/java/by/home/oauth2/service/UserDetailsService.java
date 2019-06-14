package by.home.oauth2.service;

import by.home.oauth2.domain.User;

import java.util.List;

public interface UserDetailsService {

    List<User> getAll();
    User getOne(String id);
    User saveUser(User user);
    User update(User user);
    void delete(User user);

}
