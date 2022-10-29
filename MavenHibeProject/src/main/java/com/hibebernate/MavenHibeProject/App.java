package com.hibebernate.MavenHibeProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import javax.imageio.stream.FileImageInputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
          
//creating student
		Student st = new Student();
		st.setId(101);
		st.setName("NIKHIL");
		st.setCity("GOA");
		System.out.println(st);
        
//creating student
		Student st1 = new Student();
		st1.setId(102);
		st1.setName("MAHESH");
		st1.setCity("PUNE");
		System.out.println(st1);
        
//creating student
		Student st2 = new Student();
		st2.setId(103);
		st2.setName("MEHEK");
		st2.setCity("DELHI");
		System.out.println(st2);
		
        
//creating student
		Student st3 = new Student();
		st3.setId(104);
		st3.setName("NIKUNG");
		st3.setCity("MUMBAI");
		System.out.println(st3);

		
//creating object of address class
		Address ad=new Address();
		ad.setStreet("street1");
		ad.setCity("DELHI");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1234.87);
	//	ad.setImage(null);
		
		//Reading Image
		FileInputStream fis=new FileInputStream("src/main/java/images.png");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
		Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

		session.save(st);
		session.save(ad);

		tx.commit();
		session.close();
		System.out.println("Done");

		// System.out.println(factory);
		// System.out.println(factory.isClosed());
	}
}
