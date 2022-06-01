package com.example.todobackend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TodoBackendApplication {



    public static void main(String[] args) {
        SpringApplication.run(TodoBackendApplication.class, args);
    }

}
