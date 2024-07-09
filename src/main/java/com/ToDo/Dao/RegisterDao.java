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

	Appuser findUserByEmail(String email);

	userTask fetchTaskById(int taskId);
	

}
