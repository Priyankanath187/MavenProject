package com.hibebernate.MavenHibeProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
		Student student1=new Student();
		student1.setId(101);
		student1.setName("Ankit");
        student1.setCity("Kerla");			
       
        Certificate certificate=new Certificate();
        certificate.setCourse("Android");
        certificate.setDuration("2 month");
        student1.setCerti(certificate);
        
		Student student2 = new Student();
		student2.setId(123);
		student2.setName("Madhu");
		student2.setCity("Pondichery");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Android");
		certificate1.setDuration("2 month");
		student2.setCerti(certificate);
       
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		
		//Object save
		s.save(student1);
		s.save(student2);
		
		tx.commit();
		s.close();
		factory.close();
	}

}
