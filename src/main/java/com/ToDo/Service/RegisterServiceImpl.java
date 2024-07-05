package com.ToDo.Service;

import org.springframework.stereotype.Service;

import com.ToDo.Dao.RegisterDao;
import com.ToDo.Model.Appuser;

@Service
public class RegisterServiceImpl implements RegisterService{

	private final RegisterDao registerDao;

	public RegisterServiceImpl(RegisterDao registerDao) {
		
		this.registerDao = registerDao;
	}
	
	public void createUser(Appuser user) {
		
		registerDao.insertUser(user);
	}
	
	
	
}
