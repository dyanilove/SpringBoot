package com.example.ch2;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

//1. 원격 프로그램으로 등록
@Controller
public class HomeController {  // 원격 프로그램
    // 2. URL과 메서드를 연결
    @RequestMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/test")
    public String test(Model model, HttpServletRequest request) {
        request.setAttribute("year", 2023); // request객체에 저장

        HttpSession session = request.getSession(); // 요청으로 부터 session객체를 얻어온다.
        session.setAttribute("id", "asdf"); // session객체에 id를 저장

        ServletContext application = session.getServletContext();
        application.setAttribute("email", "service@fastcampus.com");

        model.addAttribute("lastName","daeun");
        model.addAttribute("firstName","Hwang");
        model.addAttribute("list", Arrays.asList("aaa","bbb","ccc","ddd","eee"));
        model.addAttribute("bno", 123);
        model.addAttribute("user",new User("aaa",25));
        return "test";
    }
}
