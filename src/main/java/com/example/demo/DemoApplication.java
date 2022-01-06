package com.example.demo;

import com.example.demo.config.DatabaseConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@EnableConfigurationProperties
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        // create locally running mongo container
        DatabaseConfig.createContainer();
        SpringApplication.run(DemoApplication.class, args);
    }
}
