package com.example.ch4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepo;

//    @Test
//    public void insertTest(){
//        Board board = new Board();
//        board.setBno(1L);
//        board.setTitle("Test Title");
//        board.setContent("This is Test");
//        board.setWriter("aaa");
//        board.setViewCnt(0L);
//        board.setInDate(new Date());
//        board.setUpDate(new Date());
//        boardRepo.save(board);
//    }

    @Test
    public void selectTest(){
//        Board board = boardRepo.findById(1L).get(); //get을 쓰면, 값이 업을 때 에러 ㅅ발생
        Board board = boardRepo.findById(1L).orElse(null);  // 값이 없을 때 null반환

    }

}