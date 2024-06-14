package com.yoon.project.service;

import java.util.List;
import java.util.Optional;

import com.yoon.project.domain.Member;
import com.yoon.project.repository.MemberRepository;
import com.yoon.project.repository.MemoryMemberRepository;

public class MemberService {

	//private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	private final MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	/*
	 * 회원 가입
	 */
//	public Long join(Member member) {
//		//같은 이름이 있는 중복 회원x
////		Optional<Member> result = memberRepository.findByName(member.getName());
////		result.ifPresent(m -> {
////			throw new IllegalStateException("이미 존재하는 회원입니다.");
////		});
//		
//		memberRepository.findByName(member.getName())
//			.ifPresent(m -> {
//				throw new IllegalStateException("이미 존재하는 회원입니다.");
//			});
//			
//		memberRepository.save(member);
//		return member.getId();
//	}
	
	
	public Long join(Member member) {
		
		validateDuplicateMember(member);//중복 회원 검증
		memberRepository.save(member);
		return member.getId();
	}
		
	/*
	 * 중복 회원 검증 메서드 만들기
	 */
	private void validateDuplicateMember(Member member){
			memberRepository.findByName(member.getName())
				.ifPresent(m ->{
					throw new IllegalStateException("이미 존재하는 회원 입니다.");
				});
		}
	
	/*
	 * 전체 회원 조회
	 */
	public List<Member> findMember(){
		return memberRepository.findAll();
	}
	
	public Optional<Member> findOne(Long memberId){
		return memberRepository.findById(memberId);
	}
	
		
	}
	
	
