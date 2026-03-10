package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    Connection con;   // renamed from c → con (clear name)
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee_db",
                    "root",
                    "Anusree@03"
            );

            s = con.createStatement();

            System.out.println("Database connected successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}