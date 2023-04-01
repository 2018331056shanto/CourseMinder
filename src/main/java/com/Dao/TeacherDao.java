package com.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entity.Teacher;
import com.Utils.Hibernate;

public class TeacherDao {
	
	public void saveTeacher(Teacher teacher) {
		
		Transaction transaction=null;
		try(Session session=Hibernate.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			session.save(teacher);
			transaction.commit();
		}
		catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
