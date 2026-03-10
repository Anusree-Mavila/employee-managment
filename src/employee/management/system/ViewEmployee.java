

package employee.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class ViewEmployee extends JFrame implements ActionListener {

    JTable table;
    DefaultTableModel model;
    JComboBox<String> deptSearch;
    JButton searchBtn, showAllBtn;

    public ViewEmployee() {

        setLayout(null);

        // ---- Department Search Label ----
        JLabel searchLabel = new JLabel("Search by Department:");
        searchLabel.setBounds(20, 10, 160, 30);
        add(searchLabel);

        // ---- Department Dropdown ----
        String[] departments = {
                "HR", "IT", "Finance", "Marketing",
                "Sales", "Operations"
        };

        deptSearch = new JComboBox<>(departments);
        deptSearch.setBounds(180, 10, 150, 30);
        add(deptSearch);

        // ---- Search Button ----
        searchBtn = new JButton("Search");
        searchBtn.setBounds(350, 10, 100, 30);
        searchBtn.addActionListener(this);
        add(searchBtn);

        // ---- Show All Button ----
        showAllBtn = new JButton("Show All");
        showAllBtn.setBounds(470, 10, 100, 30);
        showAllBtn.addActionListener(this);
        add(showAllBtn);

        // ---- Table Columns ----
        String[] columnNames = {
                "ID", "Name", "DOB", "Address", "Email",
                "Phone", "Designation", "Department",
                "Salary", "Qualification"
        };

        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 60, 850, 350);
        add(scrollPane);

        // Load all employees initially
        loadTable("SELECT * FROM employee");

        setSize(900, 470);
        setLocation(300, 150);
        setVisible(true);
    }

    // ---- Load Data Method ----
    public void loadTable(String query) {
        try {
            model.setRowCount(0); // Clear old data

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {

                Object[] row = {
                        rs.getInt("emp_id"),
                        rs.getString("name"),
                        rs.getString("dob"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("designation"),
                        rs.getString("department"),
                        rs.getString("salary"),
                        rs.getString("qualification")
                };

                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---- Button Actions ----
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == searchBtn) {

            String selectedDept = deptSearch.getSelectedItem().toString();
            String query = "SELECT * FROM employee WHERE department = '" + selectedDept + "'";
            loadTable(query);

        } else if (ae.getSource() == showAllBtn) {

            loadTable("SELECT * FROM employee");

        }
    }
}