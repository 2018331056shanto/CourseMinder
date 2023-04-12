package com.Dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entity.User;
import com.Utils.Hibernate;
import com.mysql.cj.Query;

public class UserDao {
	
	@Transactional
	public void saveUser(User user) throws Exception {
		Transaction transaction=null;
		
		try(Session session = Hibernate.getSessionFactory().openSession()) {
			transaction=session.beginTransaction();
			
			session.save(user);
			transaction.commit();

			
		}
		
		
		
	}
	
	
	@Transactional
	public User getUser(String email) throws Exception{
		
		Transaction transaction=null;
		
		try(Session session=Hibernate.getSessionFactory().openSession()) {
			
			transaction=session.beginTransaction();
			
			User user = (User) session.createQuery("from User where username=:email")
                    .setParameter("email", email)
                    .uniqueResult();
			transaction.commit();
			return user;
			
		}
	}

}
