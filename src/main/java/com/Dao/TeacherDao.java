package com.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.Entity.Course;
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
	
	@Transactional
	public List<Teacher> getTeachers() throws Exception {
		
		Transaction transaction=null;
		
		try(Session session=Hibernate.getSessionFactory().openSession())
		{
			
			transaction=session.beginTransaction();
			
			Query<Teacher> query=session.createQuery("select c from Teacher c"); 
			List<Teacher> list=query.list();
			
			transaction.commit();
			
			return list;
		}
		
	}
	
	public Teacher getTeacherById(String id) throws Exception{
		
Transaction transaction=null;
		
		try(Session session=Hibernate.getSessionFactory().openSession())
		{
			
			transaction=session.beginTransaction();
			
			Teacher teacher=(Teacher)session.createQuery("select c from Teacher c where c.id=:id").setParameter("id", id).uniqueResult();
			
			
			transaction.commit();
			
			return teacher;
		}
		
	}
	
public ArrayList<Long> getStudentsByTeacherId(String teacherId) throws Exception{
		
		Transaction transaction=null;
		ArrayList<Long> studentCounts=new ArrayList<>();
		
		
		try(Session session=Hibernate.getSessionFactory().openSession()){
			
			transaction=session.beginTransaction();
			Query<Object[]> query=session.createQuery("SELECT COUNT(r.id), r.course.id FROM Registration r WHERE r.course.id IN (SELECT c.id FROM Course c WHERE c.teacher.id = :teacherId) GROUP BY r.course.id").setParameter("teacherId",teacherId);
			List<Object[]> registrations=query.list();
			for (Object[] objects : registrations) {
				
				
				studentCounts.add((Long) objects[0]);

			}
			return studentCounts;
		}
	}
	

}
