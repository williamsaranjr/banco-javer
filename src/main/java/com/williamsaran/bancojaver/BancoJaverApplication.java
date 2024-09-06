package com.williamsaran.bancojaver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BancoJaverApplication {
    public static void main(String[] args) {
        SpringApplication.run(BancoJaverApplication.class, args);
    }
}
