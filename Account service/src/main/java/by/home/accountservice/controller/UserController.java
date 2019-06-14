package by.home.accountservice.controller;

import by.home.accountservice.domain.Usr;
import by.home.accountservice.service.ServiceUsr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    private final ServiceUsr serviceUsr;

    @Autowired
    public UserController(ServiceUsr serviceUsr){
        this.serviceUsr = serviceUsr;
    }

    @GetMapping
    public List<Usr> getUsers(){
        return serviceUsr.getAllUsers();
    }

    @GetMapping("{id}")
    public Usr getOneUser(@PathVariable("id") Long id){
        return serviceUsr.getOneUser(id);
    }

    @PostMapping
    public Usr create(@RequestBody Usr user){
        return serviceUsr.createOrUpdateUser(user);
    }

    @PutMapping
    public Usr update(Usr userFromDb, @RequestBody Usr user){
        BeanUtils.copyProperties(user, userFromDb, "id");
        return serviceUsr.createOrUpdateUser(userFromDb);
    }

    @DeleteMapping
    public void delete(Usr user){
        serviceUsr.deleteUser(user);
    }
}
