package org.sparadrap.model;

import java.util.ArrayList;
import java.util.List;

public class PatientsList {
    private static List<Patient> patientsList = new ArrayList<>();

    // --------------- get patients list --------------------
    public static List<Patient> getPatientsList() {
        return patientsList;
    }

    // -------------- add and delete patients from list -------------
    public static void addPatient(Patient patient) {
        patientsList.add(patient);
    }
    public static void removePatient(Patient patient) {
        patientsList.remove(patient);
    }
}
