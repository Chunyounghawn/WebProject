package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //시큐리티 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().headers().frameOptions().disable() //위에줄이랑 이거랑 h2-console 화면을 사용하기위해 비활성화
                .and()
                    .authorizeRequests() //URL별 권한 관리를 설정하는 옵션의 시작점. 이게있어야 antMathcers 옵션 사용가능
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() //"/"등 지정된 URL들은 permitAll()옵션을 통해 전체 열람 권한 줌
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) ///api/v1/** 주소를 가진 API는 USER 권한을 가진 사람만 가능하도록 함.
                    .anyRequest().authenticated() //나머지 URL은 authenticated를 사용하여 인증된 사용자들에게만 허용. 즉 로그인한 사용자들만 가능
                .and()
                    .logout()
                        .logoutSuccessUrl("/") //로그아웃 기능에 대한 설정의 진입점, '로그아웃 성공시 / 주소로 이동'
                .and()
                    .oauth2Login() // OAuth2 로그인 기능에 대한 설정의 진입점
                        .userInfoEndpoint() //로그인 성공 이후 사용자 정보를 가져올때의 설정들을 담당
                            .userService(customOAuth2UserService); //소셜 로그인 성공시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록.
                                                                    // 사용자정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있음.

    }
}
