package com.example.medicinereminderapp;

public class MedicationModel {

    String medicationName;
   String prescription1;
    String prescription2;

    public MedicationModel(String medicationName, String prescription1, String prescription2) {
        this.medicationName = medicationName;
        this.prescription1 = prescription1;
        this.prescription2 = prescription2;
    }
    public String getMedicationName() {
        return medicationName;
    }

    public String getPrescription1() {
        return prescription1;
    }

    public String getPrescription2() {
        return prescription2;
    }

}
