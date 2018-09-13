package com.itmuch.cloud.microserviceconsumermovie.feign;

import com.itmuch.cloud.config.Configuration1;
import com.itmuch.cloud.microserviceconsumermovie.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;


@FeignClient(name = "microservice-provider-user", configuration = Configuration1.class)
public interface UserFeignClient {
    @RequestLine("GET /simple/{id}")
     User findById(@Param("id") Long id);
}

