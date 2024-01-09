package com.example.ch4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Ch4Application implements CommandLineRunner {

	@Autowired
	EntityManagerFactory emf;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Ch4Application.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		EntityManager em = emf.createEntityManager();

		System.out.println("em = " + em);
		EntityTransaction tx = em.getTransaction();

		User user = new User();
		user.setId("aaa");
		user.setPassword("1234");
		user.setName("Hwang");
		user.setEmail("aaa@aaa.com");
		user.setInDate(new Date());
		user.setUpDate(new Date());

		tx.begin();	// 트랜잭션 시작
		em.persist(user); // user엔티티를 em에 영속화(저장), 같은 user엔티티를 여러번 저장해도 한번만 insert

		user.setPassword("4321");	// PersistenceContext가 변경감지. update

		tx.commit();	//트랜잭션 종료(DB에 반영)
	}

}
