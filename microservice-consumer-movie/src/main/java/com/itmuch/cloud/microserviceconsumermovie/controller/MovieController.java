package com.itmuch.cloud.microserviceconsumermovie.controller;

import com.itmuch.cloud.microserviceconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController
{
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/movie/{id}")
    public User findUserById(@PathVariable("id") Long id){
        return restTemplate.getForObject("http://localhost:7900/simple/"+id,User.class);
    }
}
