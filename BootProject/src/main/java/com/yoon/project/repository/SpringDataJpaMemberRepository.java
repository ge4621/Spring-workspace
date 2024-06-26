package com.yoon.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoon.project.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{

	@Override
	Optional<Member> findByName(String name);
}
