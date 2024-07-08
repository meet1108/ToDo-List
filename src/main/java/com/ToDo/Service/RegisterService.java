package com.ToDo.Service;

import java.util.List;

import com.ToDo.Model.Appuser;
import com.ToDo.Model.userTask;

public interface RegisterService {

	void createUser(Appuser user);
	
	void createTask(userTask task);
	
	Appuser processLogin(String Email,String Password);
	
	List<userTask> userTask(String Email); 
}
