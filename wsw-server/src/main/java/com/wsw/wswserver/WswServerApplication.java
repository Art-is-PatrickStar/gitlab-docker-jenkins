package com.wsw.wswserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.wsw.wswserver.mapper")
public class WswServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WswServerApplication.class, args);
    }

}
