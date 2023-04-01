package com.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entity.Student;
import com.Utils.Hibernate;

public class StudentDao {
	
	public void saveStudent(Student student)
	{
		Transaction transaction=null;
		try(Session session=Hibernate.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			session.save(student);
			transaction.commit();
			
		}
		catch(Exception e)
		{
			if(transaction!=null) {
				
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
