package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibebernate.MavenHibeProject.Student;


public class HQLPagination {

	public static void main(String[] args) {
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    Session s=factory.openSession();
    Query q=s.createQuery("from Student");
    
    //Implementing pegination using hibernate
    q.setFirstResult(2);
    q.setMaxResults(2);
    List<Student> list=q.list();
    for(Student st : list) {
    	System.out.println(st.getId()+" : "+st.getName()+" : "+st.getCity());
    }
    
    
    
    s.close();
    
    factory.close();
	}

	

}
