package com.example.firstdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleController {
	
	@GetMapping("/user/userinfo")
	public String userInfo() {
		
		return "/user/userinfo";
	}
	
	@GetMapping("/user/userdata")
	public String userData(Model model) {
		
		model.addAttribute("username", "홍길동");
		model.addAttribute("username2", "김길동");
		
		return "/user/userinfo";
	}
	
	@GetMapping("/user/userid")
	public String userId(@RequestParam(value = "userid", required = false) String userid, Model model ) { 
		
		model.addAttribute("userid", userid);
		model.addAttribute("username", "홍길동");
		
		return "/user/userinfo";	// userinfo.html 
	}
	

}
