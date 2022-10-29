package com.hql;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Transient;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibebernate.MavenHibeProject.Student;

public class HQLExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session s=factory.openSession();
        //HQL
        //Syntax
        String query="from Student as s where s.city=:x and s.name=:n";
       Query q= s.createQuery(query);
       q.setParameter("x", "Odisha");
       q.setParameter("n", "Deepak");
       //single-(Unique)
       //multiple-list
       List<Student>list=q.list();
       for(Student student:list)
       {
    	   System.out.println(student.getName()+" : "+student.getCerti().getCourse());
       }
       
       System.out.println("----------------------------------------");
       
       Transaction tx=s.beginTransaction();
       //Delete Query
//       Query q2=s.createQuery("delete from Student s where s.city=:c");
//       q2.setParameter("c", "GOA");
//       int r=q2.executeUpdate();
//       System.out.println("Deleted :  ");
//       System.out.println(r);
       //Update Query
      Query q2 = s.createQuery("update  Student set city=:c where name=:n");
      q2.setParameter("c", "Delhi");
      q2.setParameter("n", "Neha");
      int r=q2.executeUpdate();
      System.out.println(r+"objects update");
       
       tx.commit();
       //How to execute Join Query
       Query q3=s.createQuery("select q.question , q.questionId , a.answer from Question as q INNER JOIN q.answers as a");
       List<Object []> list3=q3.getResultList();
       for(Object[] arr:list3) {
    	   System.out.println(Arrays.toString(arr));
       }
       s.close();
       factory.close();
	}

}
