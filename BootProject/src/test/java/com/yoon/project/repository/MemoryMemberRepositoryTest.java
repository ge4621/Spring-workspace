package com.yoon.project.repository;

import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import org.assertj.core.api.Assertions;

import com.yoon.project.domain.Member;

public class MemoryMemberRepositoryTest {
	
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach
	public void afterEach() {
		repository.cleanStore();
	}
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		Member result = repository.findById(member.getId()).get();
		
		//System.out.println("result = " + (result == member));
		//Assertions.assertEquals(member, result);
		Assertions.assertThat(member).isEqualTo(result);
		
	}
	
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		Member result = repository.findByName("spring1").get();
		
		Assertions.assertThat(result).isEqualTo(member1);
		
	}
	
	@Test
	public void findAll() {
		
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		List<Member> result= repository.findAll();
		Assertions.assertThat(result.size()).isEqualTo(2);
	}
	
	//Test는 한개한개 독단적으로 진행 되어야 한다. Test를 일괄적으로 한번에 처리할 경우 findAll -> findbyName -> save가 실행이 되는데
	//findAll이 진행 되고 이미 spring1, spring2의 관한 정보가 저장이 되어 있기 때문에 findByName을 진행 하면 Test오류가 발생한다. 
	//그렇기 때문에 각 Test가 진행 되고 해당 내용을 초기호 시키는 과정이 필요하다. 
	//해당 과정이 @AfterEach 과정이다.

}
