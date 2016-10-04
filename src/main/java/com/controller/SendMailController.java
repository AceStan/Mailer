package com.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.models.Email;
import com.response.Response;
import com.services.EmailService;


@Controller
public class SendMailController {
	
	@Autowired
	private EmailService emailService;
	
	@CrossOrigin
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public Response sendMail(@RequestBody Email email){
		
		Response res =  new Response();
		res = emailService.sendEmail(email);
		return res;
		               
	
	}
	
		
		
	
}
