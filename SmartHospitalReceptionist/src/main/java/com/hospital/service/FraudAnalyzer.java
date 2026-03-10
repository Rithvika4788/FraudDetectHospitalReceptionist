package com.hospital.service;

import com.hospital.dao.ClaimDAO;
import com.hospital.model.Claim;
import java.util.*;

public class FraudAnalyzer {

    public static double calculateFraudScore(double claimAmount, String diagnosis, String policyNo, List<Claim> allClaims) {
        double score = 0;

        // Rule 1: High claim amount
        if (claimAmount > 100000) score += 40;

        // Rule 2: Mismatch between diagnosis and amount
        if (diagnosis.equalsIgnoreCase("fever") && claimAmount > 50000) score += 30;

        // Rule 3: Duplicate policy number
        long count = allClaims.stream().filter(c -> c.getPolicyNo().equals(policyNo)).count();
        if (count > 1) score += 30;

        return Math.min(score, 100);
    }

    // Overloaded helper: calculate fraud score for a Claim object (GUI convenience)
    public static double calculateFraudScore(Claim c) {
        if (c == null) return 0;
        ClaimDAO dao = new ClaimDAO();
        List<Claim> all = dao.getAllClaims();
        return calculateFraudScore(c.getClaimAmount(), c.getDiagnosis(), c.getPolicyNo(), all);
    }
}
