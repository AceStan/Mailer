package com.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

// This is a test controller, it is not really used

@Controller
public class TestController {
	
	@RequestMapping(value = "/Test",method= RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String test(){
		return "This is test";
	}
	
}
