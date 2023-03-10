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
		
		/*
		 * required=true 옵션은 디폴트가 true이고, 써놓지 않으면 디폴트값으로 true가 적용. 
		 * 이 경우에는 반드시 userid 파라미터 값을 넣어서 HTTP 요청을 넣어야 한다. 안그러면 페이지 에러가 발생
		 * http://localhost:8024/user/userid?userid=KoreaMonster
		 * 
		 * 만약, false로 지정을 하면 파라미터 값을 넣지 않고 요청을 해도 페이지 에러가 발생하지 않는다. 
		 * 
		 */
		
		model.addAttribute("userid", userid);
		model.addAttribute("username", "홍길동");
		
		return "/user/userinfo";	// userinfo.html 
	}
	
	@GetMapping("/user/userparams")
	public String userParams( @RequestParam(value = "userid") String userid, 
							  @RequestParam(value = "username") String username,
							  Model model) {
		/*
		 * 
		 * http://localhost8024/user/userparams?userid=KoreaMonster&username=김세빈
		 */
		
		model.addAttribute("userid", userid); 
		model.addAttribute("username", username);
		
		return "/user/userinfo";
	}
	
	@GetMapping("/user/userparams2")
	public String userParams( 
			@RequestParam(value = "userid") String userid, 
			@RequestParam(value = "username") String username, 
			@RequestParam(value = "useremail") String useremail, 
			@RequestParam(value = "userhp", required=false) String userhp,
			Model model ) {
		
		/*
		 * http://localhost8024/user/userparams2?userid=KoreaMonster&username=김세빈&useremail=sebin@gmail.com&userhp=010-3977-0434
		 */
		
		model.addAttribute("userid", userid);
		model.addAttribute("username", username);
		model.addAttribute("useremail", useremail);
		model.addAttribute("userhp", userhp);
		
		return "/user/userinfo";
	}
	

}
