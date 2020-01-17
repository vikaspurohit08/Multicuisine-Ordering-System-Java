package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import com.app.dao.IUserDao;
import com.app.pojos.Users;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserDao iuserdao;
	
	@Autowired
	JavaMailSender mailsender;
	
	@PostMapping("/signup")
	public Integer register(@RequestBody Users user)
	{
		System.out.println(user);
			if(user !=null)
			{
				//hs.setAttribute("OTP", otp);
				String msg="<h1>+Dear+</h1><br>"+user.getFirstname()+"You have successfully registered to our website, we recommend you to not share your password with anyone.";
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(user.getEmail());
				mailMessage.setSubject("Registration Successful");
				mailMessage.setText(msg);
				try
				{
					System.out.println("inside try block");
					mailsender.send(mailMessage);
				}
				catch (MailException e) 
				{
					System.out.println("inside mail exception");
					e.printStackTrace();
				}
				
			}
		
		return iuserdao.registerUser(user);
		
	}
}
