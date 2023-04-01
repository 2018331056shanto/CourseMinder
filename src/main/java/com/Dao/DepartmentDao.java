package com.Dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entity.Department;
import com.Utils.Hibernate;

public class DepartmentDao {

	public void saveDepartment(Department department)
	{
		Transaction transaction=null;
		try(Session session=Hibernate.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			
			session.save(department);
			transaction.commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
