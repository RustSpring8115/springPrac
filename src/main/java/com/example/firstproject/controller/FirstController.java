package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String niceToMeetYou(Model model) { //메서드 작성

        model.addAttribute("username","hongpark");
        return "greeting";
    }
    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickName","홍길동");
        return "goodbye";
    }
}
