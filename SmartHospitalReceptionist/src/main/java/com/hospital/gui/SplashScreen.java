package com.hospital.gui;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame {

    public SplashScreen() {
        setTitle("Smart Hospital Receptionist");
        setSize(600, 400);
        setLocationRelativeTo(null);
    // Dispose the splash when it's done instead of exiting the JVM
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        JLabel title = new JLabel("Smart Hospital Receptionist", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(new Color(0, 102, 204));

        JLabel subtitle = new JLabel("Fraud Detection Portal", SwingConstants.CENTER);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setPreferredSize(new Dimension(550, 25));

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(Color.WHITE);
        panel.add(title, BorderLayout.NORTH);
        panel.add(subtitle, BorderLayout.CENTER);
        panel.add(progressBar, BorderLayout.SOUTH);
        add(panel);

        setVisible(true);

        // Simulate loading delay: run once after 3 seconds, then stop repeating
        javax.swing.Timer timer = new javax.swing.Timer(3000, e -> {
            dispose();
            new LoginScreen(); // after 3 seconds, go to login page
        });
        timer.setRepeats(false);
        timer.start();
    }

    // 👇 Add this main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SplashScreen::new);
    }
}
