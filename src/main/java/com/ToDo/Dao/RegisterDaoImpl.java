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
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(task);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			transaction.commit();
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
	public List<userTask> findTask(String Email) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<userTask> tasks = new ArrayList<userTask>();
		
		try {
			transaction = session.beginTransaction();
			Query<userTask> query = session.createQuery("from userTask where Email=:Email", userTask.class);
			query.setParameter("Email",Email);
			List<userTask> resultList = query.getResultList();
			tasks.addAll(resultList);
			transaction.commit();
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		}finally {
			
			session.close();			
		}
		
		return tasks;
	}

	
	
	
	

}
