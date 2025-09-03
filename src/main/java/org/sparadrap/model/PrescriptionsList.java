package org.sparadrap.model;

import java.util.ArrayList;
import java.util.List;

public class PrescriptionsList {

    // ------ create list ------
    private static List<Prescription> prescriptionsList = new ArrayList<>();


    // ------- get list --------
    public  static List<Prescription> getPrescriptions() {
        return prescriptionsList;
    }

    // -------- add and delete prescriptions to list -------
    public static void addPrescription(Prescription prescription) {
        prescriptionsList.add(prescription);
    }
    public static void removePrescription(Prescription prescription) {
        prescriptionsList.remove(prescription);
    }
}
