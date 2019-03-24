package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board")
public class BoardController {

	@ResponseBody
	@RequestMapping("/write")
	public String write(@RequestParam(value = "name", required = false) String name) {
//	public String write(@RequestParam("name")String name) { 하나만 넣을땐 value생략가능, required는 param값을 아무것도 안넘겨줘도 오류가 안뜨게해줌
		// name이라는 이름으로 값이들어오면 값을 넣어준다.
		System.out.println(name);
		return "BoardController : write()";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "no", required = false) long no) {// 직접 타입을 받을수 있다.
//	public String delete(@RequestParam(value = "no",required=false) Long no) {long타입으로 받으면 default일때 어떤값을 넣어줘야될지 모르니 객체를 넣어서 null값을 받아준다.
		System.out.println(no);
		return "BoardController : delete()";
	}

	// http://localhost:8080/hellospring/board/write?name=woo
	// 이 방법을 추천
	@ResponseBody
	@RequestMapping("/write")
	public String write(@RequestParam("e") String email, @RequestParam(value = "name", required = false) String name,
			@RequestParam String password,
			// 명시적으로 해주는 습관 방식별
			// 밑에 파람을 추천
			@RequestParam(value = "content", required = true, defaultValue = "") String content) {
		System.out.println("e:" + email);
		System.out.println("name:" + name);
		System.out.println("password:" + password);
		System.out.println("content:" + content);
		return "BoardController : delete()";
	}

	@ResponseBody
	@RequestMapping("/view")
	public String view(@RequestParam(value = "no", required = true, defaultValue = "0") Long no) {
		System.out.println(no);
		return "BoardController:view()";
	}
	
	//물음표 안쓰고 값
	@ResponseBody
	@RequestMapping("/view2/{no}")
	public String view2(@PathVariable("no") Long no) {
		System.out.println(no);
		return "BoardController:view()";
	}
	
	//http://localhost:8080/hellospring/board/view3/a/10
	@ResponseBody
	@RequestMapping("/view3/{id}/{no}")
	public String view3(
		@PathVariable("no") Long no,
		@PathVariable("id") String id) {
		System.out.println(no);
		System.out.println(id);
		return "BoardController:view()";
	}
}
