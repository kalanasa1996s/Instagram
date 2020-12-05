package lk.ijse.instagram.instagram.controller;


import lk.ijse.instagram.instagram.entity.User;
import lk.ijse.instagram.instagram.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/all")
    public List<User> getAllUsers() {

        return userServiceImpl.getAllUsers();
    }

    @GetMapping("find/{uid}")
    public User findBook(@PathVariable int uid) {

        return userServiceImpl.findUser(uid);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userServiceImpl.addUser(user);
    }


}
