package com.example.ch4;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardRepositoryTest4 {
    @Autowired
    public EntityManager em;
    @Autowired
    private BoardRepository boardRepo;


    @BeforeEach
    public void testData(){
        for (int i = 0; i < 100; i++) {
            Board board = new Board();
            board.setBno((long)i);
            board.setTitle("title"+i);
            board.setContent("content"+i);
            board.setWriter("writer"+(i%5));    //writer 0~4
            board.setViewCnt((long)(Math.random() * 100));  //0~99
            board.setInDate(new Date());
            board.setUpDate(new Date());
            boardRepo.save(board);
        }
    }


    @Test
    @DisplayName("querydsl로 쿼리작성 테스트1 - 간단한 쿼리 작성")
    public void queryAnnoTest1() {

    }

}