package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> { //<Entity 클래스, PK 타입>
    //Entity클래스와 같은 위치에 있어야하며 상속하면 자동으로 기본 crud 메소드 생성

    @Query("select p from Posts p order by p.id desc")
    List<Posts> findAllDesc();
}
