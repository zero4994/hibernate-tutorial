package com.hibernatetutorial.hibernate.demo;

import com.hibernatetutorial.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class DeleteStudentDemo {

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

            /*System.out.println("Deleting student:" + myStudent);
            session.delete(myStudent);*/

            System.out.println("Deleting student id=2");
            session.createQuery("delete from Student where id=2").executeUpdate();

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
