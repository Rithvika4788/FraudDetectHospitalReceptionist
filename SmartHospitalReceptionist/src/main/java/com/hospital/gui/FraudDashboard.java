package com.hospital.gui;

import com.hospital.dao.ClaimDAO;
import com.hospital.model.Claim;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FraudDashboard extends JFrame {

    public FraudDashboard() {
        setTitle("Fraud Detection Dashboard");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 4, 10, 10));

        ClaimDAO dao = new ClaimDAO();
        List<Claim> claims = dao.getAllClaims();

        for (Claim c : claims) {
            JButton btn = new JButton("ID:" + c.getClaimId());
            double score = c.getFraudScore();
            if (score < 40) btn.setBackground(Color.GREEN);
            else if (score < 70) btn.setBackground(Color.CYAN);
            else btn.setBackground(Color.RED);
            btn.setOpaque(true);
            btn.addActionListener(e -> JOptionPane.showMessageDialog(this,
                    "Patient ID: " + c.getPatientId() +
                            "\nPolicy: " + c.getPolicyNo() +
                            "\nAmount: " + c.getClaimAmount() +
                            "\nDiagnosis: " + c.getDiagnosis() +
                            "\nFraud Score: " + c.getFraudScore()));
            add(btn);
        }

        setVisible(true);
    }
}
