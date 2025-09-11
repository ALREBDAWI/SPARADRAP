package org.sparadrap.model;

import java.util.ArrayList;
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

    public static ArrayList<String> getPatientsFullNamesList() {
        ArrayList<String> list = new ArrayList<>();
        for (HashMap.Entry<Integer, Patient> entry : patientsMap.entrySet()) {
            list.add(entry.getKey() + " : " + entry.getValue().getFullName() );
        }
        return list;
    }
}