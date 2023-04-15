package com.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.Entity.Student;
import com.Entity.Teacher;
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

	@Transactional
	public List<Student> getStudents() throws Exception {
		
		Transaction transaction=null;
		
		try(Session session=Hibernate.getSessionFactory().openSession())
		{
			
			transaction=session.beginTransaction();
			
			Query<Student> query=session.createQuery("select c from Student c"); 
			List<Student> list=query.list();
			
			transaction.commit();
			
			return list;
		}
		
	}
	public Student getStudentById(String id) throws Exception{
		
Transaction transaction=null;
		
		try(Session session=Hibernate.getSessionFactory().openSession())
		{
			
			transaction=session.beginTransaction();
			
			Student student=(Student)session.createQuery("select c from Student c where c.id=:id").setParameter("id", id).uniqueResult();
			
			
			transaction.commit();
			
			return student;
		}
		
	}
	
	

}
