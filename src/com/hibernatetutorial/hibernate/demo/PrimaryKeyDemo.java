package com.hibernatetutorial.hibernate.demo;

import com.hibernatetutorial.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class PrimaryKeyDemo {

    public static void main (String[] args){
        SessionFactory factory = new Configuration().configure(new File("hibernate.cfg.xml"))
                                                    .addAnnotatedClass(Student.class)
                                                    .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            System.out.println("Creating new students object...");

            Student student1 = new Student("Mary", "Person", "mary.person@fkemail.com");
            Student student2 = new Student("John", "Smith", "john.smith@fkemail.com");
            Student student3 = new Student("Charles", "Darwin", "charles.darwin@fkemail.com");

            session.beginTransaction();

            System.out.println("Saving the students...");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
