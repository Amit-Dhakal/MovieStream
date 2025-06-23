package com.live;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
@RestController
public class MovieConfigServer {
    @GetMapping("/config-server")
    public String getHomePage() {
        return "HELLO FROM CONFIG SERVER";
    }
    public static void main(String[] args) {
        SpringApplication.run(MovieConfigServer.class, args);
        System.out.println("Hello,World!");
    }
}