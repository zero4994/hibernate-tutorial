package com.hibenatetutorial.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main (String[] args){
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false" +
                         "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "testUser";
        String pass = "Upiicsa1030#";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection successful!!!");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
