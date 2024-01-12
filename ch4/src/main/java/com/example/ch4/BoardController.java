package com.example.ch4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/board/list")
    public String getList(Model model) {
        List<Board> list = boardService.getList();
        model.addAttribute(list);

        return "/board/list";
     }
}
