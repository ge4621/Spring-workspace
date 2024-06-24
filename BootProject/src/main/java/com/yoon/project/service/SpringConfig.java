package com.yoon.project.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yoon.project.repository.JdbcMemberRepository;
import com.yoon.project.repository.JdbcTemplateMemberRepository;
import com.yoon.project.repository.MemberRepository;
import com.yoon.project.repository.MemoryMemberRepository;

@Configuration
public class SpringConfig {
	
	private DataSource dataSource;
	
	@Autowired
	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		//return new MemoryMemberRepository();
		//return new JdbcMemberRepository(dataSource);
		return new JdbcTemplateMemberRepository(dataSource);
	}

}
