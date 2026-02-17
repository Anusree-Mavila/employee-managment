package employee.management.system;

import javax.swing.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField id, name, salary, dept;
    JButton submit;

    public AddEmployee() {
        JLabel l1 = new JLabel("Employee ID");
        l1.setBounds(50, 30, 100, 30);
        add(l1);

        id = new JTextField();
        id.setBounds(160, 30, 150, 30);
        add(id);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(50, 70, 100, 30);
        add(l2);

        name = new JTextField();
        name.setBounds(160, 70, 150, 30);
        add(name);

        JLabel l3 = new JLabel("Salary");
        l3.setBounds(50, 110, 100, 30);
        add(l3);

        salary = new JTextField();
        salary.setBounds(160, 110, 150, 30);
        add(salary);

        JLabel l4 = new JLabel("Department");
        l4.setBounds(50, 150, 100, 30);
        add(l4);

        dept = new JTextField();
        dept.setBounds(160, 150, 150, 30);
        add(dept);

        submit = new JButton("Submit");
        submit.setBounds(120, 200, 100, 30);
        submit.addActionListener(this);
        add(submit);

        setSize(400, 300);
        setLocation(500, 250);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn c = new Conn();
            String q = "insert into employee(emp_id,name,salary,department) values('"
                    + id.getText() + "','" + name.getText() + "','" +
                    salary.getText() + "','" + dept.getText() + "')";
            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Employee Added");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


