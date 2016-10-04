package com.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.dao.impl.EmailDaoImpl;
import com.models.Email;
import com.models.Recipient;

public class MainTest {
	
	public static void main(String[] args){
		final Email email = new Email();
		
		email.setSender("acestan175@gmail.com");
		email.setPassword("********");
		email.setSubject("Test 123");
		email.setText("This is test 123");
		List<Recipient> recipients = new ArrayList<Recipient>();
		Recipient r = new Recipient();
		r.setEmail("ace_stanoevski@yahoo.com");
		recipients.add(r);
		email.setRecipients(recipients);
		email.setFile(new File("/Users/aleksandar.stanoevsk/Desktop/test.txt"));
		new EmailDaoImpl().sendEmail(email);
		
	}
}
