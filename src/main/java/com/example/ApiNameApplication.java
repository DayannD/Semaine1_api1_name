package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"project.names.controller", "project.names.service", "project.names.dao"})
//@EnableJpaRepositories("project.names.dao")
public class ApiNameApplication {

    public static void main(String[] args) {

        SpringApplication.run(ApiNameApplication.class, args);
    }

}
