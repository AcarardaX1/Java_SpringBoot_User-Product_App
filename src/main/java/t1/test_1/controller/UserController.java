package t1.test_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import t1.test_1.entity.User;
import t1.test_1.service.UserService;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService service;


    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {

        return service.saveUser(user);

    }

    @PostMapping("/addUser")
    public List<User> addUser(@RequestBody List<User> users) {

        return service.saveUsers(users);

    }
    @GetMapping("/users")
    public List<User> findAllUsers(){
        return service.getUsers();
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable int id){
        return service.getUserById(id);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {

        return service.put(user);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        return service.deleteUser(id);

    }

}
