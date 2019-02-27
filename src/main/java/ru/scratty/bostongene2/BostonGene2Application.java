package ru.scratty.bostongene2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BostonGene2Application {

    public static void main(String[] args) {
        SpringApplication.run(BostonGene2Application.class, args);
    }

}
