package com.example.snomate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //세터,게터
@NoArgsConstructor // 아무것도 없는 디폴트 생성자 생성해줌
@AllArgsConstructor // 생성자 메소드 생성해줌 
public class HelloWorldBean {
	private String message;
}
