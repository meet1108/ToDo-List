package com.ToDo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ToDo.Dao.RegisterDao;
import com.ToDo.Model.Appuser;
import com.ToDo.Model.userTask;

@Service
public class RegisterServiceImpl implements RegisterService{

	private final RegisterDao registerDao;

	public RegisterServiceImpl(RegisterDao registerDao) {
		
		this.registerDao = registerDao;
	}
	
	//Create User 
	public void createUser(Appuser user) {
		registerDao.insertUser(user);
	}
	

	//Create Task
	@Override
	public void createTask(userTask task) {
		registerDao.insertTask(task);
	}

	//Login And check the User is Valid or not
	@Override
	public Appuser processLogin(String Email, String Password) {

		return registerDao.findByEmailAndPassword(Email, Password);
	}

	//Fetch the User's all Task when It is Login
	@Override
	public List<userTask> getUserTask(String email) {
		
		return registerDao.fetchTask(email);
	}

	//fetch User Data By Email
	@Override
	public Appuser getUser(String email) {
		return registerDao.findUserByEmail(email);
	}

	//fetch Task Data By the TaskId
	@Override
	public userTask getTaskById(int taskId) {
		return registerDao.fetchTaskById(taskId);
	}

	//Update Task
	@Override
	public void updateTask(int taskId,String taskTitle,String taskDescription,String taskStatus) {
		registerDao.updateTask(taskId,taskTitle,taskDescription,taskStatus);
	}
	
	//Update Task Status 
	@Override
	public void updateStatus(int taskId,String taskStatus) {
		registerDao.updateStatus(taskId,taskStatus);
	}

	//Forgot the User Password
	@Override
	public void fotgetPassword(Appuser user) {
		registerDao.updatePassword(user);
	}
	
	
	
}
