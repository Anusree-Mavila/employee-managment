package employee.management.system;

import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JTextField tfusername;
    JPasswordField tfpassword;
    JButton login, cancel;

    public Login() {

        setTitle("Login");

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 40, 100, 30);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 40, 150, 30);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 90, 100, 30);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 90, 150, 30);
        add(tfpassword);

        login = new JButton("Login");
        login.setBounds(40, 150, 100, 30);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 150, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        setSize(350, 250);
        setLocation(500, 300);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
if (ae.getSource() == login) {

            String username = tfusername.getText();
            String password = new String(tfpassword.getPassword());

            if (username.equals("admin") && password.equals("admin")) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Login");
                tfusername.setText("");
                tfpassword.setText("");
            }

        } else if (ae.getSource() == cancel) {
            System.exit(0);
        }
    }
}
    
