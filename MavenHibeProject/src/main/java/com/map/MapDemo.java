package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
     
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
//     //creating question
//       Question q1=new Question();
//        q1.setQuestionId(1212);
//        q1.setQuestion("What is Java");
//        
//       //Creating Answer
//        Answer answer=new Answer();
//        answer.setAnswerId(343);
//        answer.setAnswer("Java is a Programming Language");
//       answer.setQuestion(q1);
//        
//        //Creating Answer1
//        Answer answer1=new Answer();
//        answer1.setAnswerId(344);
//        answer1.setAnswer("With the help of java we can create softwares");
//        answer1.setQuestion(q1);
//        
//       //Creating Answer2
//        Answer answer2=new Answer();
//       answer2.setAnswerId(345);
//        answer2.setAnswer("Java is secure language");
//        answer2.setQuestion(q1);
//       
//        List<Answer> list=new ArrayList<Answer>(); 
//        list.add(answer);
//        list.add(answer1);
//        list.add(answer2);
//         q1.setAnswers(list);
        
        
/*		
		 * //creating question2 Question q2=new Question(); q2.setQuestionId(242);
		 * q2.setQuestion("What is collection framework ?");
		 * 
		 * //Creating Answer2 Answer answer1=new Answer(); answer1.setAnswerId(344);
		 * answer1.setAnswer("API to work with obects in java");
		 * answer1.setQuestion(q2); q2.setAnswer(answer1);
		 */
        //Session
        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        
//        //save
//        s.save(q1);
//        s.save(answer);
//        s.save(answer1);
//        s.save(answer2);
//        
        Question q=(Question)s.get(Question.class, 1212);
        System.out.println(q.getQuestion());
        System.out.println(q.getQuestionId());
        //lazy
        //System.out.println(q.getAnswers().size());
      
       
        tx.commit();
        
        //Fetching
//        Question newQ=(Question)s.get(Question.class,1212);
//        System.out.println(newQ.getQuestion());
//        System.out.println(newQ.getAnswer().getAnswer());
        
        s.close();
        factory.close();
	}

}
