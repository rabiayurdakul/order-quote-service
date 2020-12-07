package com.eleiatech.orderquoteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OrderQuoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderQuoteServiceApplication.class, args);
    }

}
