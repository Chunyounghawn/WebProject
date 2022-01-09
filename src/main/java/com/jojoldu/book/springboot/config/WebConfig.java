package com.jojoldu.book.springboot.config;

import com.jojoldu.book.springboot.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {//WebMvcConfigurer 쓰고있었는데 설정추가하는것.오버라이딩통해.
    // HandlerMethodArgumentResolver는 항상 WebMvcConfigurer의 addArgumentResolvers를 통해 추가해야함.
    // 대부분 웹 어플리케이션에서 사용자들이 로그인 인증 후 서버에서 세션을 생성하고 발급을 해주게 됩니다.
    // 그때마다 컨트롤러에서 세션정보를 요구하는 특정 메소드를 수행하게 되면 아래 코드처럼 중복적인 코드를 작성해야 되는 불필요한 상황이 발생하게 됩니다. > 그래서 만드는과정.

    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
        argumentResolvers.add(loginUserArgumentResolver);
    }

}

