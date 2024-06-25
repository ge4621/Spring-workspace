package com.yoon.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Member {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
    //@SequenceGenerator(name = "member_seq", sequenceName = "MEMBER_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

//@GeneratedValue(strategy = GenerationType.IDENTITY)
// =>db가 자동적으로 생성하는것 oracle같은 경우 pk를 시퀀스로 했을떄
//위 name이 만약 db에서 컬럼명이 username일 경우 @Column(name="username")을 넣기

//강의는 h2데이터 베이스 사용, 나는 oracle 사용
//문제 사항 -> 자바에서 Long타입으로 설정한 id가 db에서는 number타입으로 설정을 하였고, 시퀀스와 트리거를 사용했기 때문에 이로 인해 오류가 계속 발생