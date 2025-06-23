package com.live;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthenticationServiceApplication {
    @GetMapping("/authserver")
    public String fetchAuthUsers() {
        return "INSIDE AUTHENTICATION";
    }

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationServiceApplication.class, args);
        System.out.println("Hello, World!");
    }
}