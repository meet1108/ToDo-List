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


//	@Override
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

	
	
	
	

}
