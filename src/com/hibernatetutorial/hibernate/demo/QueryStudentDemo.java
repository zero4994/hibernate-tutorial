package com.hibernatetutorial.hibernate.demo;

import com.hibernatetutorial.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.List;

public class QueryStudentDemo {

    public static void main (String[] args){
        //create session factory

        //create session
        SessionFactory factory = new Configuration().configure(new File("hibernate.cfg.xml"))
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            //query students
            List<Student> theStudents = session.createQuery("from Student").list();

            //display the students
            displayStudents(theStudents);

            //query students: lastName='Doe'
            theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();
            System.out.println("\n\nStudents who have last name of Doe");
            displayStudents(theStudents);


            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }
}
