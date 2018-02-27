package com.chessa.example.rest.mobilRest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import com.chessa.example.springoAuth2.springRestoAuth2.*;

@SpringBootApplication
@EnableJpaAuditing
public class MobilRestApplication {
    public static void main(String[] args){
        SpringApplication.run(MobilRestApplication.class, args);
    }
}
