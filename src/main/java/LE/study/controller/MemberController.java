package LE.study.controller;

import LE.study.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

//    private final MemberService memberService = new MemberService();
//    //이 방식보다 스프링 컨테이너에 '한 개만' 등록해서 공유하고 쓰면 된다
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
