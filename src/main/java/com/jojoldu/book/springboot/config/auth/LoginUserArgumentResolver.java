package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final HttpSession httpSession;

    @Override//지원하는지
    public boolean supportsParameter(MethodParameter parameter){ //특정 파라미터 지원하는지 확인
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null; //@LoginUser 어노테이션 붙어있는지
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType()); //파라미터 클래스 타입이 SessionUser.class 인지 맞으면 true
        return isLoginUserAnnotation && isUserClass;
    }

    @Override//파라미터에 전달할객체 생성, 여기서는 세션에서 객체를 가져옴.
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception{
        return httpSession.getAttribute("user");
    }

}
