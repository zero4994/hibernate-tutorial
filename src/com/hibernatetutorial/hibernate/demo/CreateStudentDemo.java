package com.hibernatetutorial.hibernate.demo;

import com.hibernatetutorial.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class CreateStudentDemo {

    public static void main (String[] args){
        //create session factory

        //create session
        SessionFactory factory = new Configuration().configure(new File("hibernate.cfg.xml"))
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            //create student object
            System.out.println("Creating new student object...");

            Student student = new Student("John", "Doe", "john.doe@fkemail.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student...");
            session.save(student);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
