package com.wsw.wswclient1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wsw.wswclient1.mapper")
public class WswClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(WswClient1Application.class, args);
    }

}
