package com.example.userservice.controller;
import com.example.userservice.VO.ResponceVo;
import com.example.userservice.entity.User;
import com.example.userservice.exception.ResourseNotFoundException;
import com.example.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.pool.TypePool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public ResponceVo getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }

}

