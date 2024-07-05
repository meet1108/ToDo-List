package com.ToDo.Dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class RegisterDaoImpl implements RegisterDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public RegisterDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
