package com.klose.minimail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"com.klose"})
public class MiniMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniMailApplication.class, args);
    }

}
