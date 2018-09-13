package com.itmuch.cloud.microserviceconsumermovie.controller;

import com.itmuch.cloud.microserviceconsumermovie.entity.User;
import com.itmuch.cloud.microserviceconsumermovie.feign.FeignClient2;
import com.itmuch.cloud.microserviceconsumermovie.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private FeignClient2 feignClient2;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }

    @GetMapping("/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable String serviceName) {
        System.out.println("dd");
        return this.feignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
    }

}
