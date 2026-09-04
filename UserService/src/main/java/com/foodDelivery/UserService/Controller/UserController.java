package com.foodDelivery.UserService.Controller;

import org.springframework.web.bind.annotation.*;

import com.foodDelivery.UserService.Service.UserService;
import com.foodDelivery.UserService.entity.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
public User getUserById(@PathVariable Integer id) {

    return userService.getUserById(id);
}
}