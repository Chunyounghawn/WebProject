package com.jojoldu.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //생성될 수 있는 위치지정 > 메소드의 파라미터로 선언된 객체만 사용가능
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
