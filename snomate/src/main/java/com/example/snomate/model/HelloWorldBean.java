package com.example.snomate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data //세터,게터
@NoArgsConstructor // 아무것도 없는 디폴트 생성자 생성해줌
@AllArgsConstructor // 생성자 메소드 생성해줌
@Entity
@Table(name = "hello_world_bean")
public class HelloWorldBean {

	@Id
	private String message;
}
