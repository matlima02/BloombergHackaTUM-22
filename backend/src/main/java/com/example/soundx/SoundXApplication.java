package com.example.soundx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
        //(exclude={DataSourceAutoConfiguration.class})
//@EntityScan("src.main.java.com.example.soundx")
//@EnableJpaRepositories("src.main.java.com.example.soundx")
public class SoundXApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoundXApplication.class, args);
    }

}
