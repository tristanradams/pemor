package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

@Configuration
public class DatabaseConfig {
    static String MONGO_REUSE_ID = "com.example.demo:mongo";
    static DockerImageName MONGO_IMAGE = DockerImageName.parse("mongo");
    static MongoDBContainer MONGO_CONTAINER;

    public static MongoDBContainer createContainer() {
        if (MONGO_CONTAINER == null) {
            MONGO_CONTAINER = new MongoDBContainer(MONGO_IMAGE)
                    .withReuse(true)
                    .withLabel("reuse.id", MONGO_REUSE_ID);

            MONGO_CONTAINER.start();
        }

        return MONGO_CONTAINER;
    }

    @Bean
    public static MongoDBContainer mongoContainer() {
        return createContainer();
    }
}
