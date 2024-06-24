package com.yoon.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {

	@Id
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