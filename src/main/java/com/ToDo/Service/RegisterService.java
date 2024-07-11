package com.ToDo.Service;

import java.util.List;

import com.ToDo.Model.Appuser;
import com.ToDo.Model.userTask;

public interface RegisterService {

	//Create User Register Time
	void createUser(Appuser user);
	
	//Create Task By the User,user wise 
	void createTask(userTask task);
	
	//User Can Do Login or Not
	Appuser processLogin(String Email,String Password);
	
	//User all Task Show
	List<userTask> getUserTask(String email);

	//fetch User Data By Email
	Appuser getUser(String email); 
	
	//Fetch User Task By It's user Id for the Update Task
	userTask getTaskById(int taskId);

	//Update Particular Task
	void updateTask(int taskId,String taskTitle,String taskDescription, String taskStatus);

	//Update Task Status
	void updateStatus(int taskId,String taskStatus);

	//Forget Password
	void fotgetPassword(Appuser user);
}
