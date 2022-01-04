package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public Posts toEntity(){    //Posts에서 하는역할과 같지만 절대로 Posts에서 request/response를 해주면 안됨.
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
