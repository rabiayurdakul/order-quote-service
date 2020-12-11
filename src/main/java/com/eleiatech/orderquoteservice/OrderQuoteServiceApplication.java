package com.eleiatech.orderquoteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableEurekaClient
@EnableDiscoveryClient
@EnableJpaAuditing
@SpringBootApplication
public class OrderQuoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderQuoteServiceApplication.class, args);
    }

}
