package com.example.ch2;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {
//    @RequestMapping("/login")
    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @PostMapping("/login")
    public String login(HttpServletRequest req, String id, String pwd, RedirectAttributes model) throws Exception{
        // 1. id,pwd를 확인
        if(loginCheck(id,pwd)){
            model.addAttribute("id",id);
            model.addAttribute("pwd",pwd);
            // 2. 일치하면, userInfo.html
            return "userInfo";
        }else {
//            String msg = URLEncoder.encode("id또는 pwd가 일치하지 않습니다.","utf-8") ;
            String msg = "id또는 pwd가 일치하지 않습니다." ;
//            일치하지 않으면, login.html
//            return "redirect:/login/login?msg="+msg;
            model.addAttribute("msg", msg);
            model.addFlashAttribute("msg", "일회용 메시지");
            req.setAttribute("msg","request에 저장된 msg");
            return "redirect:/";
        }
    }

    private boolean loginCheck(String id, String pwd) {
        return id.equals("asdf") && pwd.equals("1234");
    }
}
