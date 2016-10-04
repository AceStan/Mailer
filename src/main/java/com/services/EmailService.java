package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmailDao;
import com.models.Email;
import com.response.Response;

@Service
public class EmailService {

	@Autowired
	private EmailDao emailDao;
	
	public Response sendEmail(Email email){
		return emailDao.sendEmail(email);
	}
}
