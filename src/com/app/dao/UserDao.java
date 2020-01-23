package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Users;

@Repository
@Transactional
public class UserDao implements IUserDao 
{
	@Autowired
	SessionFactory sf;
	
	@Override
	public Integer registerUser(Users user) {
		System.out.println("inside registerUser");
		return (Integer)sf.getCurrentSession().save(user);
	}
	
}
