package com.ToDo.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ToDo.Model.Appuser;
import com.ToDo.Model.userTask;





@Repository
public class RegisterDaoImpl implements RegisterDao {

	@Autowired
	SessionFactory sessionFactory;

	public RegisterDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	//Create User
	@Override
	public void insertUser(Appuser user) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	
	//Create Task
	@Override
	public void insertTask(userTask task) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(task);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	
	
	//Check the User Is Valid  Or not then It Is For the Login
	@Override
	public Appuser findByEmailAndPassword(String Email, String Password) {

			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query<Appuser> query = session.createQuery("from Appuser where Email =:Email and Password =:Password", Appuser.class);
			query.setParameter("Email", Email);
			query.setParameter("Password", Password);
			Appuser user = query.uniqueResult();
			transaction.commit();
			session.close();
			return user;
		
	}


	//When User Login That's Time User Show the all Task It's Self
	@Override
	public List<userTask> fetchTask(String email) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("Dao Called");
		List<userTask> tasks = new ArrayList<userTask>();
		
		try {
			Query<userTask> query = session.createQuery("from userTask u where u.email= :email", userTask.class);
			query.setParameter("email",email);
			List<userTask> resultList = query.getResultList();
			System.out.println(email);
			System.out.println(resultList);
			tasks.addAll(resultList);
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			
			transaction.commit();
			session.close();			
		}
		
		return tasks;
	}


	//fetch User Data By Email
	public Appuser findUserByEmail(String email) {
		
	
			System.out.println(email);
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query<Appuser> query = session.createQuery("from Appuser au where au.email =:email", Appuser.class);
			query.setParameter("email", email);
			
			Appuser user = query.uniqueResult();
			transaction.commit();
			session.close();
			
			return user;
			
		
		
	}


	//Fetch The TaskData By the Task ID
	@Override
	public userTask fetchTaskById(int taskId) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<userTask> query = session.createQuery("from userTask ut where ut.taskId =:taskId", userTask.class);
		query.setParameter("taskId", taskId);
		
		userTask task = query.uniqueResult();
		transaction.commit();
		session.close();
		
		return task;
	}


	//Update the Task Data
	@Override
	public void updateTask(int taskId,String taskTitle,String taskDescription,String taskStatus) {
		Session session = sessionFactory.openSession();
		
		try {
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(
				"update userTask ut set  ut.taskTitle=:taskTitle, ut.taskDescription=:taskDescription, ut.taskStatus=:taskStatus where ut.taskId=:taskId");
		query.setParameter("taskTitle", taskTitle);
		query.setParameter("taskDescription", taskDescription);
		query.setParameter("taskId", taskId);
		query.setParameter("taskStatus", taskStatus);
		query.executeUpdate();
		transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			session.close();
		}
	}


	//Update the TaskStatus 
	@Override
	public void updateStatus(int taskId,String taskStatus) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("update userTask ut set ut.taskStatus=:taskStatus where ut.taskId =:taskId");
			query.setParameter("taskStatus", taskStatus);
			query.setParameter("taskId", taskId);
			query.executeUpdate();
			transaction.commit();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}


	//Update the User Password
	@Override
	public void updatePassword(Appuser user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("update Appuser u set u.password=:password, u.conformPassword=:conformPassword where u.email =:email");
			query.setParameter("password", user.getPassword());
			query.setParameter("conformPassword", user.getConformPassword());
			query.setParameter("email", user.getEmail());
			query.executeUpdate();
			transaction.commit();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	
	
	
	
	

}
