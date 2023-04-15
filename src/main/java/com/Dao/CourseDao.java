package com.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.Entity.Course;
import com.Entity.Department;
import com.Entity.Teacher;
import com.Utils.Hibernate;

public class CourseDao {
	
	@Transactional
	public List<Course> getCourses() throws Exception {
		
		Transaction transaction=null;
		
		try(Session session=Hibernate.getSessionFactory().openSession())
		{
			
			transaction=session.beginTransaction();
			
			Query<Course> query=session.createQuery("select c from Course c"); 
			List<Course> list=query.list();
			
			transaction.commit();
			
			return list;
		}
		
	}
	
	public Teacher getCourseTeacher(String id) throws Exception
	{
		
		Transaction transaction=null;
		try(Session session=Hibernate.getSessionFactory().openSession())
		{
			
			
			transaction=session.beginTransaction();
			Teacher teacher=(Teacher)session.createQuery("select c.teacher from Course c where c.id = :id and c.teacher is not null").setParameter("id", id).uniqueResult();

			transaction.commit();
			return teacher; 
			
		}
	}
	public Course getCourseById(String id) throws Exception
	{
		
		Transaction transaction=null;
		try(Session session=Hibernate.getSessionFactory().openSession())
		{
			
			
			transaction=session.beginTransaction();
			Course course=(Course)session.createQuery("select c from Course c where c.id = :id").setParameter("id", id).uniqueResult();

			transaction.commit();
			return course; 
			
		}
	}
	
	
	public List<Course> getCourseByTeacher(String id) throws Exception{
		
		Transaction transaction=null;
		try(Session session=Hibernate.getSessionFactory().openSession())
		{
			
			
			transaction=session.beginTransaction();
			
			List<Course> courses=session.createQuery("select c from Course c where c.teacher.id = :id").setParameter("id", id).list();

			transaction.commit();
			
			return courses; 
			
		}
		
	}
public List<Course> getCourseNotMatchWithTeacher(String dept) throws Exception{
		
		dept=dept+"%";
		Transaction transaction=null;
		try(Session session=Hibernate.getSessionFactory().openSession())
		{
			
			
			transaction=session.beginTransaction();
			
//			List<Course> courses=session.createQuery("select c from Course c where c.id not in (select c2.id from Course c2 where c2.teacher.id=:id)").setParameter("id", id).list();
			List<Course>courses=session.createQuery("select c from Course c where c.teacher is null and c.id like :dept ").setParameter("dept", dept).list();
			for (Course course : courses) {
				System.out.println(course);
			}
			transaction.commit();
			

			return courses; 
			
		}
		
	}
public void UpdateCourseTeacher(String id,Teacher teacher) throws Exception{
	
	Transaction transaction=null;
	try(Session session=Hibernate.getSessionFactory().openSession())
	{
		
		
		transaction=session.beginTransaction();
		
		Course course=(Course)session.createQuery("select c from Course c where c.id=:id").setParameter("id", id).uniqueResult();

			Query query = session.createQuery("update Course c set c.teacher = :teacher where c.id = :id");
			query.setParameter("teacher", teacher);
			query.setParameter("id", id);
			int result = query.executeUpdate();
			
			transaction.commit();
		
	}
}
	public void saveCourse(String name,String courseId) {
		
		Transaction transaction=null;
		try(Session session=Hibernate.getSessionFactory().openSession()){
			
			
			transaction=session.beginTransaction();
			
			Course course=new Course(courseId,name,null);
			session.save(course);
			transaction.commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null) {
				
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Course> getUnenrolledCoursesByStudent(String id,String dept) throws Exception{
		
		Transaction transaction=null;
		
		try(Session session=Hibernate.getSessionFactory().openSession()){
			
			transaction=session.beginTransaction();
			
			dept=dept+"%";
			System.out.println(id+" : "+dept);
			List<Course>courses=session.createQuery("from Course c where c.id not in (select r.course.id from Registration r where r.student.id=:id) and c.id like : dept ").setParameter("id", id).setParameter("dept", dept).list();
			
			for (Course course : courses) {
				System.out.println(course);
			}
			return courses;
		}
		
	}
}
