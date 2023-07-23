package LE.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")            //localhost켜고 제일 처음 들어가는 페이지
    public String home() {
        return "home";             //templates/{home}.html 로 가라 {home = ViewName}
    }
}
