package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableJpaAuditing //jpa auditing 활성화     //SpringBootApplication얘랑 분리하기위해 제거.
// 테스트할떄 EnableJpaAuditing는 최소하나의 @Entity클래스가 필요한데 @WebMvcTest이다보니 없어서 제거.
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
