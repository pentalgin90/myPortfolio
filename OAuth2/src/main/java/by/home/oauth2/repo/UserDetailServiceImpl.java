package by.home.oauth2.repo;

import by.home.oauth2.domain.User;
import by.home.oauth2.service.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserDetailsRepo userDetailsRepo;

    public UserDetailServiceImpl(UserDetailsRepo userDetailsRepo){
        this.userDetailsRepo = userDetailsRepo;
    }
    @Override
    public List<User> getAll() {
        return userDetailsRepo.;
    }

    @Override
    public User getOne(String id) {
        return null;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }
}
