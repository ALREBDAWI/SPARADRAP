package org.sparadrap.model.PatientModel;

import java.util.HashMap;

/**
 * Manages a collection of Patient objects.
 * Provides static methods to add, remove, and retrieve patients by their unique ID.
 */
public class PatientsList {

    /** Stores patients with a unique ID as key */
    private static HashMap<Integer, Patient> patientsMap = new HashMap<>();

    /** Counter to assign unique IDs to patients */
    private static int idCounter = 1;

    /**
     * Returns the current map of patients.
     *
     * @return HashMap of patient ID to Patient object
     */
    public static HashMap<Integer, Patient> getPatientsMap() {
        System.out.println("Patients Map");
        return patientsMap;
    }

    /**
     * Adds a new patient to the collection with a unique ID.
     *
     * @param patient Patient object to add
     */
    public static void addPatient(Patient patient) {
        patientsMap.put(idCounter++, patient);
    }

    /**
     * Removes a patient from the collection by ID.
     *
     * @param patientId ID of the patient to remove
     */
    public static void removePatient(int patientId) {
        patientsMap.remove(patientId);
    }

    /**
     * Prints a list of all patients with their IDs and full names.
     */
    public static Patient getPatientById(int patientId) {
        return patientsMap.get(patientId);
    }

    /**
     * Prints a list of all patients with their IDs and full names.
     */
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