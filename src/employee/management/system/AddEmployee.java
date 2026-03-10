package employee.management.system;

import javax.swing.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField name, dob, address, email, phone, designation, salary, qualification;
    JComboBox<String> department;
    JButton submit;

    public AddEmployee() {

        setLayout(null);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(50, 30, 120, 30);
        add(l1);

        name = new JTextField();
        name.setBounds(180, 30, 200, 30);
        add(name);

        JLabel l2 = new JLabel("DOB (YYYY-MM-DD)");
        l2.setBounds(50, 70, 150, 30);
        add(l2);

        dob = new JTextField();
        dob.setBounds(180, 70, 200, 30);
        add(dob);

        JLabel l3 = new JLabel("Address");
        l3.setBounds(50, 110, 120, 30);
        add(l3);

        address = new JTextField();
        address.setBounds(180, 110, 200, 30);
        add(address);

        JLabel l4 = new JLabel("Email");
        l4.setBounds(50, 150, 120, 30);
        add(l4);

        email = new JTextField();
        email.setBounds(180, 150, 200, 30);
        add(email);

        JLabel l5 = new JLabel("Phone");
        l5.setBounds(50, 190, 120, 30);
        add(l5);

        phone = new JTextField();
        phone.setBounds(180, 190, 200, 30);
        add(phone);

        JLabel l6 = new JLabel("Designation");
        l6.setBounds(50, 230, 120, 30);
        add(l6);

        designation = new JTextField();
        designation.setBounds(180, 230, 200, 30);
        add(designation);

        JLabel l7 = new JLabel("Department");
        l7.setBounds(50, 270, 120, 30);
        add(l7);

        String[] departments = {
                "HR",
                "IT",
                "Finance",
                "Marketing",
                "Sales",
                "Operations"
        };

        department = new JComboBox<>(departments);
        department.setBounds(180, 270, 200, 30);
        add(department);

        JLabel l8 = new JLabel("Salary");
        l8.setBounds(50, 310, 120, 30);
        add(l8);

        salary = new JTextField();
        salary.setBounds(180, 310, 200, 30);
        add(salary);

        JLabel l9 = new JLabel("Qualification");
        l9.setBounds(50, 350, 120, 30);
        add(l9);

        qualification = new JTextField();
        qualification.setBounds(180, 350, 200, 30);
        add(qualification);

        submit = new JButton("Submit");
        submit.setBounds(150, 400, 120, 30);
        submit.addActionListener(this);
        add(submit);

        setSize(500, 500);
        setLocation(500, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        try {
            Conn c = new Conn();

            String query = "INSERT INTO employee(name, dob, address, email, phone, designation, department, salary, qualification) VALUES ('"
                    + name.getText() + "','"
                    + dob.getText() + "','"
                    + address.getText() + "','"
                    + email.getText() + "','"
                    + phone.getText() + "','"
                    + designation.getText() + "','"
                    + department.getSelectedItem() + "','"
                    + salary.getText() + "','"
                    + qualification.getText() + "')";

            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Employee Added Successfully");
            setVisible(false);

        } catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, e.getMessage());
}
    }
}