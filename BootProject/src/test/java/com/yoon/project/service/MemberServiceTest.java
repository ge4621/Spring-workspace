package com.yoon.project.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yoon.project.domain.Member;
import com.yoon.project.repository.MemberRepository;
import com.yoon.project.repository.MemoryMemberRepository;

public class MemberServiceTest {

	//MemberService memberService = new MemberService();
	//MemoryMemberRepository memberRepository = new MemoryMemberRepository();
	
	MemberService memberService;
	MemoryMemberRepository memberRepository;
	
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	
	@AfterEach
	public void afterEach() {
		memberRepository.cleanStore();
	}
	
	
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
		Member member1 = new Member();
		member1.setName("spring");
		

		Member member2 = new Member();
		member2.setName("spring");
		//when
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class, ()->memberService.join(member2));
		
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		
//		try {
//			memberService.join(member2);
//			fail();
//		}catch(IllegalStateException e){
//			assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//		}
		
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
 
