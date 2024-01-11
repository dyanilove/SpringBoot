package com.example.ch4;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OneToOneTest {
    @Autowired
    public EntityManager em;
    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private MemberRepository memberRepo;

    @Test
    public void oneToOneTest(){
        Member member = new Member();
        member.setId(1L);
        member.setName("aaa");
        member.setEmail("aaa@aaa");
        member.setPassword("1234");

        memberRepo.save(member);

        Cart cart = new Cart();
        cart.setId(1L);
        cart.setMember(member);
        cartRepo.save(cart);

        cart = cartRepo.findById(cart.getId()).orElse(null);
        assertTrue(cart != null);
        System.out.println("cart = " + cart);
    }

}