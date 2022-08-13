package com.example.api_name;

import com.example.http.HttpNames;
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

        HttpNames httpOrigin = new HttpNames();
        String page = httpOrigin.getHtmlNamesPage("berber");
        httpOrigin.getNames(page);
    }

}
