package com.jojoldu.book.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration //WebMvcTest는 일반적인 Configuration를 스캔하지않음.
@EnableJpaAuditing
public class JpaConfig {
}
