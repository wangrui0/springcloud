package com.itmuch.cloud.microserviceconsumermovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient//职责比较单一：明确的用eureka的
//@EnableDiscoveryClient //可以用其他的服务发现的工具：比如说：zk,cancale
@EnableFeignClients
public class ConsumerMovieFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieFeignApplication.class, args);
    }
}
