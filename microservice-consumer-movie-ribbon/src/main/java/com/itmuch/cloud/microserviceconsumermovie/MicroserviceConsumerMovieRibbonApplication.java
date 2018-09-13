package com.itmuch.cloud.microserviceconsumermovie;

import config.TestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient//职责比较单一：明确的用eureka的
//@EnableDiscoveryClient //可以用其他的服务发现的工具：比如说：zk,cancale
@RibbonClient(name = "microservice-provider-user-ribbon", configuration = TestConfiguration.class)
public class MicroserviceConsumerMovieRibbonApplication {
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerMovieRibbonApplication.class, args);
	}
}
