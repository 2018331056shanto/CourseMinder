package com.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.parse.ATNBuilder.subrule_return;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.Entity.Course;
import com.Entity.Registration;
import com.Entity.Student;
import com.Entity.Teacher;
import com.Utils.Hibernate;

public class RegistrationDao {
	
	public Map<Course,Long> getRegistration() throws Exception{
		
		Transaction transaction=null;
		Map<Course,Long> map=new HashMap<Course,Long>();
		
		try(Session session=Hibernate.getSessionFactory().openSession()){
			
			transaction=session.beginTransaction();
			Query<Object[]> query=session.createQuery("select count(c.student),c.course from Registration c group by c.course");
			List<Object[]> registrations=query.list();
			for (Object[] objects : registrations) {
				
				
				Course course=(Course)objects[1];
				
				map.put(course,(Long) objects[0]);
			}
			return map;
		}
	}
	
	public List<Student> getRegisterStudentsToACourse(String id)throws Exception
	{
		
		Transaction transaction=null;
		
		try(Session session=Hibernate.getSessionFactory().openSession()){
			
			transaction=session.beginTransaction();
			Query<Student> query=session.createQuery("select c.student from Registration c where c.course.id=:id").setParameter("id", id);
			List<Student> students=query.list();
			
			transaction.commit();
			
			return students;
			
		}
	}
	public Course getHighestTakenCourse() throws Exception{
		
		Transaction transaction=null;
		Course course = null;
		
		try(Session session=Hibernate.getSessionFactory().openSession()){
			
			transaction=session.beginTransaction();
			
			Query<Object[]> query=session.createQuery("select count(c.student),c.course from Registration  c group by c.course order by count(c.student) desc ");
			
			List<Object[]>list=query.list();
			
			transaction.commit();
			
			
			for (Object[] objects : list) {
				
				course=(Course)objects[1];
				break;
			}
			return course;
			
		}


	}

}
