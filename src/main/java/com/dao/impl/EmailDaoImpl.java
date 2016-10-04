package com.dao.impl;


import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;

import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import org.springframework.stereotype.Repository;

import com.dao.EmailDao;
import com.models.Email;
import com.response.Response;
import com.util.GetProviderUtil;
import com.util.HibernateUtil;

@Repository
public class EmailDaoImpl implements EmailDao {

	@Override
	public Response sendEmail(final Email email) {
		Response res = new Response();
		org.hibernate.Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
		String provider = new GetProviderUtil().getProvider(email.getSender());
		

		// At this point the Mail Service will work only with Google and Yahoo!
		// accounts
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		if (provider.equals("gmail")) {
			properties.put("mail.smtp.host", "smtp.gmail.com");
		}
		if (provider.equals("yahoo")) {
			properties.put("mail.smtp.host", "smtp.mail.yahoo.com");
		}
		properties.put("mail.smtp.port", "587");
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email.getSender(), email.getPassword());
			}
		});
		
		try {
			if (email.getFile() != null) {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(email.getSender()));
				for (int i = 0; i < email.getRecipients().size(); i++)
					message.setRecipients(Message.RecipientType.CC,
							InternetAddress.parse(email.getRecipients().get(i).getEmail()));
				message.setSubject(email.getSubject());
				BodyPart part1 = new MimeBodyPart();
				part1.setText(email.getText());
				DataSource attachment = new FileDataSource(email.getFile());
				BodyPart part2 = new MimeBodyPart();
				part2.setDataHandler(new DataHandler(attachment));
				part2.setFileName(email.getFile().getName());
				Multipart multiPart = new MimeMultipart();
				multiPart.addBodyPart(part1);
				multiPart.addBodyPart(part2);
				message.setContent(multiPart);
				Transport.send(message);
				System.out.println("Message sent successfully....");
				res.setComment("Successfully sent email + attachment ");
			} else {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(email.getSender()));
				for(int i=0;i<email.getRecipients().size();i++)
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getRecipients().get(i).getEmail()));
				message.setSubject(email.getSubject());
				message.setText(email.getText());
				Transport.send(message);
				System.out.println("Message sent successfully....");
			res.setComment("Successfully sent email");
			}
			res.setStatus("Success");
		
			hibernateSession.save(email);
			//hibernateSession.getTransaction().commit();
			hibernateSession.close();
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus("Failed");
			res.setComment("Failed to send email");
		}
		return res;
	}

}
