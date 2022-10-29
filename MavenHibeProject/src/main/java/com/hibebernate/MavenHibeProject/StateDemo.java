package com.hibebernate.MavenHibeProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

	public static void main(String[] args) {
		// practical of hibernate object state
		//Transient
		//Persistent
		//Detached
		//Removed
		System.out.println("Example");
		SessionFactory f=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//Creating Student Object
		Student student=new Student();
		student.setId(101);
		student.setName("Deepak");
		student.setCity("Bhubneswar");
		student.setCerti(new Certificate("Hibernate course","2 month"));
		
		//Creating Student1 Object
				Student student1=new Student();
				student1.setId(102);
				student1.setName("MUKESH");
				student1.setCity("GOA");
				student1.setCerti(new Certificate("Core Java course","4 month"));
				
				//Creating Student2 Object
				Student student2=new Student();
				student2.setId(103);
				student2.setName("Neha");
				student2.setCity("Jhadkhand");
				student2.setCerti(new Certificate("Python course","3 month"));
				
				//Creating Student3 Object
				Student student3=new Student();
				student3.setId(104);
				student3.setName("Priyank");
				student3.setCity("Bhubneswar");
				student3.setCerti(new Certificate("Spring Boot","2 month"));
				
				//Creating Student4 Object
				Student student4=new Student();
				student4.setId(105);
				student4.setName("Ahana");
				student4.setCity("Bangalore");
				student4.setCerti(new Certificate("Datascience","5 month"));
		//student:Transient
		
		Session s=f.openSession();
		Transaction tx=s.beginTransaction();
		s.save(student);
		s.save(student1);
		s.save(student2);
		s.save(student3);
		s.save(student4);
		//student : Persistent -session,database
		//student.setName("JOHN");
		tx.commit();
		s.close();
		//student : Detached
		//student.setName("Mohit");
		f.close();

	}

}
