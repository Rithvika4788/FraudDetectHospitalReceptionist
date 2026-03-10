package com.hospital.model;

public class Claim {
    private int claimId;
    private int patientId;
    private String policyNo;
    private double claimAmount;
    private String diagnosis;
    private String status;
    private double fraudScore;

    // ======== Constructors ========
    public Claim() {
        // Default constructor (used when creating a new claim)
    }

    public Claim(int claimId, int patientId, String policyNo, double claimAmount,
                 String diagnosis, String status, double fraudScore) {
        this.claimId = claimId;
        this.patientId = patientId;
        this.policyNo = policyNo;
        this.claimAmount = claimAmount;
        this.diagnosis = diagnosis;
        this.status = status;
        this.fraudScore = fraudScore;
    }

    // ======== Getters and Setters ========

    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getFraudScore() {
        return fraudScore;
    }

    public void setFraudScore(double fraudScore) {
        this.fraudScore = fraudScore;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimId=" + claimId +
                ", patientId=" + patientId +
                ", policyNo='" + policyNo + '\'' +
                ", claimAmount=" + claimAmount +
                ", diagnosis='" + diagnosis + '\'' +
                ", status='" + status + '\'' +
                ", fraudScore=" + fraudScore +
                '}';
    }
}
