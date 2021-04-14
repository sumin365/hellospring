package com.example.hellospring.controllers;
// 02/06/24


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.hellospring.vo.UserVo;

//	RequestMapping ( Type + Method 매핑 )
@RequestMapping("/user")	//	/user url 패턴에 응답
@Controller
public class UserController {
	@RequestMapping("/joinform")	//	/user/joinform 패턴에 응답
	public String joinform() {
		//	ViewName 리턴
		return "/WEB-INF/views/joinform.jsp";
	}
	
	//	파라미터를 다수를 받아야 할 경우 -> VO를 사용하는 것이 좋다
	//	자동 동적 바인딩을 위해서 ModelAttribute 사용
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserVo vo) {
		System.out.println("Model Attribute:" + vo);
		//redirect해야겠다. spring은 return타입이 뷰네임인데 뷰네임앞에 redirect써주면 
		//view reserve가 url은 redirect url이라고 알게된다. 그래서 redirect보내주게 된다. 
		return "redirect:/user/joinsuccess";
	}
//  전에는 이렇게 썻는데 불편하니까 위에 처럼 해보자
//	public String join(@RequestParam String name,
//			@RequestParam String email,
//			@RequestParam String password,
//			@RequestParam String gender,
//			@RequestParam int age) {
//		System.out.println("Param name:" + name);
//		System.out.println("Param email:" + email);
//		System.out.println("Param password:" + password);
//		System.out.println("Param gender:" + gender);
//		System.out.println("Param age:" + age);
//		서블릿에서는 302,303일때  redirect은 resp.sendredirect()라고 썼었는데 spring은 그냥 쓰면된다.
//		return "redirect:/user/joinsuccess";	//	REDIRECT
//	}
	
	@ResponseBody
	@RequestMapping("/joinsuccess")
	public String joinsuccess() {
		return "<h3>Join Success!</h3>";
	}
}