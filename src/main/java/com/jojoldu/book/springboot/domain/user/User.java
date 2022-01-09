package com.jojoldu.book.springboot.domain.user;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity { //User클래스는 엔티티이기때문에 언제 다른엔티티와 관계가 형성될지모름. 그래서 직렬화 구현하지않았고 따로 직렬화 기능을 가진 세션 Dto 둠.
    // +세션에 저장하기 위해 User 클래스를 세션에 저장하려고하면 직렬화 구현하지않았다고 에러뜸.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING) //JPA로 데이터베이스로 저장할 때 Enum값을 어떤형태로 저장할지 결정 / 기본적으로는 int인데 확인할때 힘듬
    @Column
    private Role role; //권한

    @Builder
    public User(String name, String email, String picture, Role role){
        this.name=name;
        this.email=email;
        this.picture=picture;
        this.role=role;
    }
    public User update(String name, String picture){
        this.name=name;
        this.picture=picture;

        return this; //신기하네
    }

    public String getRoleKey(){
        return this.role.getKey();
    }





}
