package com.yoon.project.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.yoon.project.domain.Member;
import com.yoon.project.repository.MemberRepository;
import com.yoon.project.repository.MemoryMemberRepository;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memberRepository;
	
	
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
		
		//then
	}
	
}
