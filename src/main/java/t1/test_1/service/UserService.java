package t1.test_1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t1.test_1.entity.User;
import t1.test_1.repository.UserRepository;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository repository;


    public User saveUser(User user){
        return repository.save(user);
    }

    public List<User> saveUsers(List<User> users){
        return repository.saveAll(users);
    }

    public List<User> getUsers(){

        return repository.findAll();
    }

    public User getUserById(int id){

        return repository.findById(id).orElse(null);
    }



    public String deleteUser(int id){
        repository.deleteById(id);
        return "User Removed !! " +id;
    }

    public User put(User user){

        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getFirst_name());
        return repository.user(existingUser);
    }



}
