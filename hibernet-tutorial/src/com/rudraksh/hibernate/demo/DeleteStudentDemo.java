package com.rudraksh.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.rudraksh.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			System.out.println("\nGetting student with id:" + studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("\nUpdating Student..");
			
			myStudent.setFirstName("Abhi");
			
			
			//commit the transaction
			session.getTransaction().commit();			

			// New code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students
			System.out.println("\nUpdate email for all students");
			
			session.createQuery("update Student set email='jayyogeshwar@gmail.com'").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}
		finally {
			factory.close();
		}

	}

}
