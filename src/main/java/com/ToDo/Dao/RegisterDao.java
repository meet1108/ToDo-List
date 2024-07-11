package com.ToDo.Dao;

import java.util.List;

import com.ToDo.Model.Appuser;
import com.ToDo.Model.userTask;


public interface RegisterDao {

	//Create User
	void insertUser(Appuser user);
	
	//create Task
	void insertTask(userTask task);

	//find User login time
	Appuser findByEmailAndPassword(String Email,String Password);

	//Find Task By Email
	List<userTask> fetchTask(String email);

	//fetch User Data By Email
	Appuser findUserByEmail(String email);

	//fetch User Task By the TaskId
	userTask fetchTaskById(int taskId);

	//Update The Task Data
	void updateTask(int taskId,String taskTitle,String taskDescription,String taskStatus);

	//Update the Task Status
	void updateStatus(int taskId,String taskStatus);

	//Update Password By the User
	void updatePassword(Appuser user);
	

}
