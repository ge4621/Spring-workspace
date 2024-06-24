package com.yoon.project.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yoon.project.repository.JdbcMemberRepository;
import com.yoon.project.repository.JdbcTemplateMemberRepository;
import com.yoon.project.repository.JpaMemberRepository;
import com.yoon.project.repository.MemberRepository;
import com.yoon.project.repository.MemoryMemberRepository;

@Configuration
public class SpringConfig {
	
//	private DataSource dataSource;
//	
//	@Autowired
//	public SpringConfig(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	
	//@PersistenceContext ->원래 받아야 하지만 아래처럼 하면 스프링에서 자동으로 DI를 해줌
	private EntityManager em;
	@Autowired
	public SpringConfig(EntityManager em) {
		this.em = em;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		//return new MemoryMemberRepository();
		//return new JdbcMemberRepository(dataSource);
		//return new JdbcTemplateMemberRepository(dataSource);
		return new JpaMemberRepository(em);
	}

}
