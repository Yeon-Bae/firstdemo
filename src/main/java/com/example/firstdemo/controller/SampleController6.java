package com.example.firstdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.firstdemo.dto.BoardDTO;

/*
 * DTO 객체와 타임리프를 이용한 뷰페이지 반복 출력 
 * 여러 개의 객체를 생성하여 뷰페이지로 넘긴 후 타임리프 반복문을 사용하여 반복 출력 
 * 
 */

@Controller
public class SampleController6 {
	
	@GetMapping("/SampleController6")
	public String mainPage( Model model) {
		
		// 단일 객체 생성
		BoardDTO boardDTO = new  BoardDTO(1, "boardDTO 객체입니다.", "홍길동"); 
		
		// 여러 개의 객체 생성
		
		BoardDTO b1 = new BoardDTO(1, "하늘이 무척 맑은 날씨네요...", "이순신");
		BoardDTO b2 = new BoardDTO(2, "요즘 너무 더워요....", "강감찬");
		BoardDTO b3 = new BoardDTO(3, "다들 휴가는 갔다 오셨나요? ", "김유신");
		BoardDTO b4 = new BoardDTO(4, "에어컨 없이는 하루도 못 살겠어요.", "을지문덕");
		BoardDTO b5 = new BoardDTO(5, "오늘은 한글날이다.", "세종대왕");
		BoardDTO b6 = new BoardDTO(6, "동물원에 놀러가자...... ", "김재경");
		BoardDTO b7 = new BoardDTO(7, "인천공항에 가고싶어요. ", "김연배");
		BoardDTO b8 = new BoardDTO(8, "비행기 타고 놀러가고 싶다~~~~ 해외로", "세빈아빠");

		List<BoardDTO> bList = new ArrayList<>();
		
		bList.add(b1);
		bList.add(b2);
		bList.add(b3);
		bList.add(b4);
		bList.add(b5);
		bList.add(b6);
		bList.add(b7);
		bList.add(b8);

		
		
		// model
		model.addAttribute("boardDTO", boardDTO);
		model.addAttribute("bList", bList);
		
		return "/post/SampleController6";
	}

}
