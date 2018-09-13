package com.itmuch.cloud.microserviceconsumermovie.controller;

import com.itmuch.cloud.microserviceconsumermovie.entity.User;
import com.itmuch.cloud.microserviceconsumermovie.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/movie/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return userFeignClient.findById(id);
    }

    @GetMapping("/test")
    public User testPost(User user/*, BindingResult bindingResult*/) {
        return userFeignClient.postUser(user);
    }

    @GetMapping("/test-get")
    public User testGet(User user) {
        return userFeignClient.getUser(user);
    }

}
