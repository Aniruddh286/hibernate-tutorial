package com.rudraksh.hibernate.demo;

import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.rudraksh.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			//start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudent = session.createQuery("from Student").getResultList();
			
			// display students
			displayStudents(theStudent);
			
			// query students: lastName ="Fataniya"
			theStudent = session.createQuery("from Student s where s.lastName='Fataniya'").getResultList();
			
			// display the students
			System.out.println("\nStudents having last name as Fataniya:");
			displayStudents(theStudent);
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudent) {
		for (Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}
	}

}
