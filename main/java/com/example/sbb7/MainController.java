package com.example.sbb7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping("/sbb")
    @ResponseBody
    public String index(){
        return "안녕하세요 sbb에 오신것을 환여합니다.";
    }
    // 루트 URL 활용하기
    // 템플러를 사용하지 않고 리턴값을 넣으려면 ResponseBody 를 써줌.
    @RequestMapping("/")
    public String root(){
        return "redirect:/question/list";
    // 리다이렉트 : 클라이언트가 요청하면 새로운 URL 로 전송
    // / 만 입력해도 question/list 로 이동할수 있게 리다이렉트함.
    }



}
