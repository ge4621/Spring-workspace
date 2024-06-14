package com.yoon.project.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.yoon.project.domain.Member;

public class MemberServiceTest {

	MemberService memberService = new MemberService();
	
	
	@Test
	void 회원가입() {
		//given - 해당 기반 데이터로 검증을 하는구나
		Member member = new Member();
		member.setName("hello");
		
		//when - 해당되는 것을 검증하는구나
		Long saveId = memberService.join(member);
		
		//then - 여기가 검증 부분 이구나
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
		
	}
	
	@Test
	public void 중복_회원_예외() {
		//given
		
		//when
		
		//then
	}
	
	@Test
	void findMembers() {
		
	}
	
	@Test
	void findOne() {
		
	}
}

/*
 * Test 클래스의 메서드 이름은 한글로 바꿔도 문제 없다.
 * Test 코드는 빌드될때 코드에 포함되지 않음
 */ 
 
