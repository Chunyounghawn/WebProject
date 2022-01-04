package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity { //Entity 클래스에서는 절대 setter 메소드를 만들지않음/ 대신 해당필드 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼수 있는 메소드를
    //추가해야함. 메소드를 'setStatus(boolean status) this.status=status' 이렇게말고 'cancelOrder() this.status=false'로 목적과 의도를 명확히

    @Id //해당 테이블의 PK 필드를 나타냄,d
    @GeneratedValue(strategy = GenerationType.IDENTITY) //.identity = <데이터베이스>에 자동생성 위임(AUTO_INCREMENT)
    private Long id;

    @Column(length = 500, nullable = false) //사용하지않더라도 해당클래스의 필드는 모두 컬럼이되지만 설정옵션이 필요하면 씀
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 컬럼의 기본값
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title= title;
        this.content=content;
        this.author=author;
    }

    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }

}
