

package employee.management.system;

import javax.swing.*;
import java.sql.*;

public class ViewEmployee extends JFrame {
    JTextArea area;

    public ViewEmployee() {
        area = new JTextArea();
        area.setBounds(20, 20, 450, 300);
        add(area);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while (rs.next()) {
                area.append(
                        rs.getInt("emp_id") + "  " +
                        rs.getString("name") + "  " +
                        rs.getString("department") + "\n"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(500, 400);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);
    }
}
