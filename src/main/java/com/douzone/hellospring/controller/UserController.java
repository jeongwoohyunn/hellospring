package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.hellospring.vo.UserVo;

//request mapping : type + method
@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value = "/join", method = RequestMethod.GET) //1. 이렇게 가능 	
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	//ModelAttribute - 
	//post 방식으로는 못들어온다.(접근 불가)
	@ResponseBody
	@RequestMapping(value = "/join",method=RequestMethod.POST)
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println(userVo);
		return "UserController : join()";
	}
	
	@ResponseBody
	@RequestMapping("/loginform")
	public String loginform() {
		return "UserController : loginform()";
	}
	
}
