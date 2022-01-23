package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
//tptp
    private final PostsService postsService;
    //(반복개선)private final HttpSession httpSession;

    /*//(반복개선)
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //세션로그인 성공시 값을 가져옴
        if(user != null){ //세션에 저장된 값이 있을때만 model에 userName으로 등록함. 저장된값이 없으면 model에 아무런 값이 없는상태이니 로그인 버튼이 보임
            model.addAttribute("userNames", user.getName());
            System.out.println(model.toString());
        }

        return "index"; //머스테치 스타터때문에 컨트롤러에서 문자열 반환할때 앞의 경로와 뒤의 파일확장자는 자동지정 / src/main/resources/templates/index.mustache
    }
    */

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {  //httpSession.getAttribute("user")(부분 개선),
        // 이제 어느 컨트롤러든지 @LoginUser만 사용하면 세션정보 가져올수 있음.
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null){
            model.addAttribute("userNames", user.getName());
        }

        return "index";
    }


    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save"; //posts-save.mustache를 호출
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }


}
