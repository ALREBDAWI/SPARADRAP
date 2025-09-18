package org.sparadrap.model.PrescriptionModel;

import java.util.HashMap;

/**
 * Manages a collection of Prescription objects.
 * Provides methods to add, remove, and retrieve prescriptions by unique ID.
 */
public class PrescriptionsList {

    /** Stores prescriptions with a unique ID as key */
    private static HashMap<Integer, Prescription> prescriptionsList = new HashMap<>();

    /** Counter to assign unique IDs to prescriptions */
    private static int idCounter = 1;

    /**
     * Returns the current map of prescriptions.
     *
     * @return HashMap of prescription ID to Prescription object
     */
    public static HashMap<Integer, Prescription> getPrescriptions() {
        return prescriptionsList;
    }

    /**
     * Adds a new prescription to the collection with a unique ID.
     *
     * @param prescription Prescription object to add
     */
    public static void addPrescription(Prescription prescription) {
        prescriptionsList.put(idCounter++,prescription);
    }

    /**
     * Removes a prescription from the collection.
     *
     * @param prescription Prescription object to remove
     */
    public static void removePrescription(Prescription prescription) {
        prescriptionsList.remove(prescription);
    }

}

