package com.live;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class APIGatewayApplication {
    @GetMapping("/gateway")
    public String getHomePage(){
        return "HELLO FROM API GATEWAY";
    }
    public static void main(String[] args) {
        SpringApplication.run(APIGatewayApplication.class,args);
    }
}