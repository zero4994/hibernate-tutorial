package com.hibernatetutorial.hibernate.demo;

import com.hibernatetutorial.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class UpdateStudentDemo {

    public static void main (String[] args){
        //create session factory

        //create session
        SessionFactory factory = new Configuration().configure(new File("hibernate.cfg.xml"))
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            int studentId = 1;

            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating student...");
            myStudent.setFirstName("Scobby");
            //commit the transaction
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Update email for all students");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();


            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
