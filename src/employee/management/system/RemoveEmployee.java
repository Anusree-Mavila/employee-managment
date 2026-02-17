

package employee.management.system;

import javax.swing.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    JTextField id;
    JButton delete;

    public RemoveEmployee() {
        JLabel l1 = new JLabel("Employee ID");
        l1.setBounds(50, 50, 100, 30);
        add(l1);

        id = new JTextField();
        id.setBounds(160, 50, 150, 30);
        add(id);

        delete = new JButton("Delete");
        delete.setBounds(120, 100, 100, 30);
        delete.addActionListener(this);
        add(delete);

        setSize(400, 200);
        setLocation(500, 250);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn c = new Conn();
            c.s.executeUpdate("delete from employee where emp_id='" + id.getText() + "'");
            JOptionPane.showMessageDialog(null, "Employee Removed");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
