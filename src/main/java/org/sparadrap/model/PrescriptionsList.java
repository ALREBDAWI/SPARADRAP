package org.sparadrap.model;

import org.sparadrap.model.DummyData.DummyData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrescriptionsList {

    // ------ create list ------
    private static HashMap<Integer, Prescription> prescriptionsList = new HashMap<>();

    // ------- get list --------
    public static HashMap<Integer, Prescription> getPrescriptions() {
        return prescriptionsList;
    }

    // -------- add and delete prescriptions to list -------
    private static int idCounter = 1;
    public static void addPrescription(Prescription prescription) {
        prescriptionsList.put(idCounter++,prescription);
    }
    public static void removePrescription(Prescription prescription) {
        prescriptionsList.remove(prescription);
    }

}

