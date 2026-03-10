package com.hospital.dao;

import com.hospital.model.Claim;
import com.hospital.util.DBConnection;
import java.sql.*;
import java.util.*;

public class ClaimDAO {

    // Insert using primitive values (patientId is stored as integer in the model)
    public void insertClaim(int patientId, String policyNo, double claimAmount, String diagnosis, String status, double fraudScore) {
        String query = "INSERT INTO claims (patient_id, policy_no, claim_amount, diagnosis, status, fraud_score) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, patientId);
            stmt.setString(2, policyNo);
            stmt.setDouble(3, claimAmount);
            stmt.setString(4, diagnosis);
            stmt.setString(5, status);
            stmt.setDouble(6, fraudScore);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Claim> getAllClaims() {
        List<Claim> claims = new ArrayList<>();
        String query = "SELECT * FROM claims";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                claims.add(new Claim(
                    rs.getInt("claim_id"),
                    rs.getInt("patient_id"),
                    rs.getString("policy_no"),
                    rs.getDouble("claim_amount"),
                    rs.getString("diagnosis"),
                    rs.getString("status"),
                    rs.getDouble("fraud_score")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return claims;
    }

    // Convenience method used by GUI: add a Claim object
    public void addClaim(Claim c) {
        if (c == null) return;
        insertClaim(c.getPatientId(), c.getPolicyNo(), c.getClaimAmount(), c.getDiagnosis(), c.getStatus(), c.getFraudScore());
    }
}
