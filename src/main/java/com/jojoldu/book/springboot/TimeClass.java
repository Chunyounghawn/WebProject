package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

public class TimeClass {

    public static void main(String[] args) {
        SpringApplication.run(TimeClass.class, args);
    }

    @PostConstruct
    public void started(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));

    }
}