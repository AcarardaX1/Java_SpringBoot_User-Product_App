package t1.test_1.controller;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import t1.test_1.entity.User;
import t1.test_1.service.BookService;
import t1.test_1.service.UserService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService service;
    @Autowired
    private BookService bookService;


    private Mapper mapper;

    public UserController(UserService userService, BookService bookService) {
        this.service = userService;
        this.bookService = bookService;
    }



    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        service.saveUser(user);

        return user;

    }

    @PostMapping("/addUserList")
    public List<User> addUserList(@RequestBody List<User> users) {

        return service.saveUsers(users);

    }
    @GetMapping
    public List<User> findAllUsers(){
        return service.getUsers();
    }

    @GetMapping("/{id}")
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

//    @GetMapping("/ids")
//    public long report(
//            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
//            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
//
//        return service.getUserByDate(startDate, endDate);
//    }


}
