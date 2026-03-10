package com.hospital.gui;

import com.hospital.dao.*;
import com.hospital.model.*;
import com.hospital.service.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.List;

public class ClaimEntryDashboard extends JFrame {

    private ClaimDAO claimDAO = new ClaimDAO();
    private JTable table;

    public ClaimEntryDashboard() {
        setTitle("Claim Entry Dashboard");
        setSize(900, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ======== Top Panel for Form Inputs ========
        JPanel inputPanel = new JPanel(new GridLayout(3, 4, 10, 10));
        JTextField patientIdField = new JTextField();
        JTextField policyField = new JTextField();
        JTextField amountField = new JTextField();
        JTextField diagnosisField = new JTextField();
        JComboBox<String> statusBox = new JComboBox<>(new String[]{"Pending", "Approved", "Rejected"});
        JButton addBtn = new JButton("Add Claim");

        inputPanel.add(new JLabel("Patient ID:"));
        inputPanel.add(patientIdField);
        inputPanel.add(new JLabel("Policy No:"));
        inputPanel.add(policyField);
        inputPanel.add(new JLabel("Claim Amount:"));
        inputPanel.add(amountField);
        inputPanel.add(new JLabel("Diagnosis:"));
        inputPanel.add(diagnosisField);
        inputPanel.add(new JLabel("Status:"));
        inputPanel.add(statusBox);
        inputPanel.add(new JLabel(""));
        inputPanel.add(addBtn);

        add(inputPanel, BorderLayout.NORTH);

        // ======== Center Table to Display All Claims ========
        table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);

        // ======== Load Existing Claims ========
        refreshTable();

        // ======== Add Claim Button Action ========
        addBtn.addActionListener(e -> {
            try {
                int patientId = Integer.parseInt(patientIdField.getText().trim());
                String policyNo = policyField.getText().trim();
                double amount = Double.parseDouble(amountField.getText().trim());
                String diagnosis = diagnosisField.getText().trim();
                String status = (String) statusBox.getSelectedItem();

                if (policyNo.isEmpty() || diagnosis.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Create Claim object
                Claim c = new Claim();
                c.setPatientId(patientId);
                c.setPolicyNo(policyNo);
                c.setClaimAmount(amount);
                c.setDiagnosis(diagnosis);
                c.setStatus(status);

                // ✅ Automatically calculate fraud score internally
                double score = FraudAnalyzer.calculateFraudScore(c);
                c.setFraudScore(score);

                // Insert into Database
                claimDAO.addClaim(c);

                JOptionPane.showMessageDialog(this,
                        "✅ Claim added successfully!\nFraud Score: " + score,
                        "Success", JOptionPane.INFORMATION_MESSAGE);

                // Clear fields after adding
                patientIdField.setText("");
                policyField.setText("");
                amountField.setText("");
                diagnosisField.setText("");
                statusBox.setSelectedIndex(0);

                // Refresh table data
                refreshTable();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values for ID and Amount.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding claim: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // ======== Bottom Button to Open Fraud Dashboard ========
        JButton dashboardBtn = new JButton("Open Fraud Dashboard");
        dashboardBtn.addActionListener(e -> new FraudDashboard());
        add(dashboardBtn, BorderLayout.SOUTH);

        setVisible(true);
    }

    // ======== Refresh Table Data from DB ========
    private void refreshTable() {
        List<Claim> claims = claimDAO.getAllClaims();
        String[] cols = {"Claim ID", "Patient ID", "Policy No", "Amount", "Diagnosis", "Status", "Fraud Score"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (Claim c : claims) {
            model.addRow(new Object[]{
                    c.getClaimId(),
                    c.getPatientId(),
                    c.getPolicyNo(),
                    c.getClaimAmount(),
                    c.getDiagnosis(),
                    c.getStatus(),
                    c.getFraudScore()
            });
        }
        table.setModel(model);
    }

    // ======== Main Method (for testing directly) ========
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ClaimEntryDashboard::new);
    }
}
