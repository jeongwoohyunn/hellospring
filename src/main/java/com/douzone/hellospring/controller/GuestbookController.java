package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//request mapping : type에만 단독
@Controller
@RequestMapping("/guestbook/*")//게스트이름으로 들어왔을때 핸들러 이름으로 보내는 매핑이다.(add,list,delete)
public class GuestbookController {
	
	@ResponseBody
	@RequestMapping//Mapping이 없거나 private는 안된다.
	public String list() {
		return "GuestbookController : list()";
	}
	
	@ResponseBody
	@RequestMapping
	public String add() {
		return "GuestbookController : add()";
	}
	
	@ResponseBody
	@RequestMapping
	public String delete() {
		return "GuestbookController : delete()";
	}
	
	

}
