package com.hospital.gui;

import com.hospital.dao.UserDAO;
import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {

    public LoginScreen() {
        setTitle("Login - Smart Hospital Receptionist");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginBtn = new JButton("Login");

        add(userLabel); add(userField);
        add(passLabel); add(passField);
        add(new JLabel()); add(loginBtn);

        loginBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            UserDAO dao = new UserDAO();
            if (dao.validateUser(username, password)) {
                dispose();
                new ClaimEntryDashboard();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials");
            }
        });

        setVisible(true);
    }
}
