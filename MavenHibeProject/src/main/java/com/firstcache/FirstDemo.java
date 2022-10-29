package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibebernate.MavenHibeProject.Student;

public class FirstDemo {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session s=factory.openSession();
		//by default enable
		Student student=s.get(Student.class,103);
		System.out.println(student);
		
		System.out.println("working something....");
		
		Student student1=s.get(Student.class,103);
		System.out.println(student1);
		System.out.println(s.contains(student1));
        		
		

		s.close();
		factory.close();
	}

}
