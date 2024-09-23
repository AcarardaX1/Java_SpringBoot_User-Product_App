package t1.test_1.service;


import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t1.test_1.entity.Book;
import t1.test_1.entity.User;
import t1.test_1.repository.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

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
        if (existingUser != null){
            repository.save(user);
            return user;           //Update
        }
        return null;
    }


//    public long toConvertepoch(Date startDate, Date endDate){
//
//        LocalDate startLocalDate = Instant.ofEpochMilli(startDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
//        LocalDate endLocalDate = Instant.ofEpochMilli(endDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
//
//
//        long startEpoch = startLocalDate.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
//        long endEpoch = endLocalDate.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
//
//        long daysBetween = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
//
//        return daysBetween;
//    }





}
