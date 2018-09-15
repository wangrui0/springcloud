package com.itmuch.cloud.microserviceconsumermovie.controller;

import com.itmuch.cloud.microserviceconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class MovieController
{
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/movie/{id}")
    public User findUserById(@PathVariable("id") Long id){
//        return restTemplate.getForObject("http://localhost:7900/simple/"+id,User.class);
        return restTemplate.getForObject("http://microservice-provider-user-ribbon/simple/"+id,User.class);//虚拟ip
    }
    @GetMapping("/list-all")
    public List<User> listAll() {
//         wrong
//            List<User> list = this.restTemplate.getForObject("http://microservice-provider-user/list-all", List.class);
//            for (User user : list) {
//              System.out.println(user.getId());
//            }

        // right
        User[] users = this.restTemplate.getForObject("http://microservice-provider-user/list-all", User[].class);
        List<User> list = Arrays.asList(users);
        for (User user : list) {
            System.out.println(user.getId());
        }

        return list;
    }
}
