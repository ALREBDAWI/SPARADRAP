package org.sparadrap.model;

import java.util.HashMap;

public class PatientsList {
    private static HashMap<Integer, Patient> patientsMap = new HashMap<>();
    private static int idCounter = 1;

    public static HashMap<Integer, Patient> getPatientsMap() {
        return patientsMap;
    }

    public static void addPatient(Patient patient) {
        patientsMap.put(idCounter++, patient);
    }

    public static void removePatient(int patientId) {
        patientsMap.remove(patientId);
    }

    public static Patient getPatientById(int patientId) {
        return patientsMap.get(patientId);
    }

    public static void getPatientsFullNamesList() {
        System.out.println("=================================================");
        System.out.printf("%-10s | %-30s%n", "Patient ID", "Full Name");
        System.out.println("-------------------------------------------------");

        for (HashMap.Entry<Integer, Patient> entry : patientsMap.entrySet()) {
            System.out.printf("%-10d | %-30s%n", entry.getKey(), entry.getValue().getFullName());
        }

        System.out.println("=================================================");
    }
}