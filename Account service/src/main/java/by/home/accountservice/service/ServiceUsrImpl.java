package by.home.accountservice.service;

import by.home.accountservice.domain.Usr;
import by.home.accountservice.repo.UsrDetailsRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceUsrImpl implements ServiceUsr {

    private final UsrDetailsRepo usrDetailsRepo;

    public ServiceUsrImpl(UsrDetailsRepo usrDetailsRepo){
        this.usrDetailsRepo = usrDetailsRepo;
    }

    @Override
    public List<Usr> getAllUsers() {
        return usrDetailsRepo.findAll();
    }

    @Override
    public Usr getOneUser(Long id) {
        return usrDetailsRepo.getOne(id);
    }

    @Override
    public Usr createOrUpdateUser(Usr user) {
        return usrDetailsRepo.save(user);
    }

    @Override
    public void deleteUser(Usr user) {
        usrDetailsRepo.delete(user);
    }
}
