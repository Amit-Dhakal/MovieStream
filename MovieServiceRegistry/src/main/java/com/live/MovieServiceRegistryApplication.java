package com.live;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
@RestController
public class MovieServiceRegistryApplication {
    @GetMapping("/service-registry")
    public String getHomePage() {
        return "HELLO FROM SERVICE REGISTRY";
    }
    public static void main(String[] args) {
        SpringApplication.run(MovieServiceRegistryApplication.class, args);
        System.out.println("Hello,World!");
    }
}