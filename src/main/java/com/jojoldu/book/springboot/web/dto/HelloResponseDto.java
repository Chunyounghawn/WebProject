package com.jojoldu.book.springboot.web.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //선언된 모든 필드의 get메소드 생성
@RequiredArgsConstructor //생성자 생성할때 final들어간거 포함해줌
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
