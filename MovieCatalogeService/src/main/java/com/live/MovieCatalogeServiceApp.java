package com.live;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class MovieCatalogeServiceApp {

    @GetMapping("/movie-cataloge")
    public String movieCtalogePage() {
        return "MOVIE CATALOGE PAGE";
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieCatalogeServiceApp.class, args);
        System.out.println("Hello, World!");
    }


}