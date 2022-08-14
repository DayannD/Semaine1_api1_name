package com.example.api_name;

import com.example.http.HttpNames;
import com.example.http.HttpOrigin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"project.names.controller", "project.names.service", "project.names.dao"})
//@EnableJpaRepositories("project.names.dao")
public class ApiNameApplication {

    public static void main(String[] args) {

        SpringApplication.run(ApiNameApplication.class, args);

        HttpOrigin httpOrigin = new HttpOrigin();
        String page = httpOrigin.getHtmlPageOrigin();
        httpOrigin.getOrigin(page);
    }

}
