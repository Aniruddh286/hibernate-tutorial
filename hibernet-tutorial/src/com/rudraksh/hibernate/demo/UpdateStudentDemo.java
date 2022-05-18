package com.rudraksh.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.rudraksh.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;	
			
			
			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			//System.out.println("\nGetting student with id:" + studentId);
			//Student myStudent = session.get(Student.class, studentId);
			
			//delete a student
			//session.delete(myStudent);
			
			//commit the transaction
			//session.getTransaction().commit();	
			
			//deleting student having lastName= "Fataniya"
			session.createQuery("delete from Student where lastName='Fataniya'").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
				
			
			
			System.out.println("Done!");
			
			
		}
		finally {
			factory.close();
		}

	}

}
