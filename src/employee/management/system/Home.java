package employee.management.system;

import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JMenuBar mb;
    JMenu employee;
    JMenuItem add, view, remove, exit;

    public Home() {

        setTitle("Employee Management System");

        mb = new JMenuBar();
        employee = new JMenu("Employee");

        add = new JMenuItem("Add Employee");
        view = new JMenuItem("View Employee");
        remove = new JMenuItem("Remove Employee");
        exit = new JMenuItem("Exit");

        add.addActionListener(this);
        view.addActionListener(this);
        remove.addActionListener(this);
        exit.addActionListener(this);

        employee.add(add);
        employee.add(view);
        employee.add(remove);
        employee.add(exit);

        mb.add(employee);
        setJMenuBar(mb);

        setSize(600, 400);
        setLocation(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {
            new AddEmployee();
        } else if (ae.getSource() == view) {
            new ViewEmployee();
        } else if (ae.getSource() == remove) {
            new RemoveEmployee();
        } else if (ae.getSource() == exit) {
            System.exit(0);
        }
    }
}
