package com.lty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lty.mapper")
public class Litianyu2Application {

    public static void main(String[] args) {
        SpringApplication.run(Litianyu2Application.class, args);
    }

}
