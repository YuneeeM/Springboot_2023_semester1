package com.board.boardback.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ComponentScan("com.board.boardback.controller")
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home"; // home.html 또는 home.jsp와 같은 뷰 페이지를 반환합니다.
    }
}