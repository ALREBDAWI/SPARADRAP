package org.sparadrap.model.InsuranceModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages a collection of Insurance company objects.
 * Provides static methods to add, remove, retrieve, and display insurance companies.
 */
public class InsuranceCompaniesList {

    /** Stores insurance companies with a unique ID as key */
    private static Map<Integer, Insurance> insurances = new HashMap<>();

    /** Counter to generate unique IDs for insurance companies */
    private static int idCounter = 1;

    // -----------------------------
    // ---------- Getters ----------
    // -----------------------------

    /**
     * Returns the map of all insurance companies.
     *
     * @return Map where key is insurance ID and value is Insurance object
     */
    public static Map<Integer, Insurance> getInsuranceCompaniesList() {
        return insurances;
    }

    // =====================================
    // ---------- CRUD Operations ----------
    // =====================================

    /**
     * Adds a new insurance company to the collection and assigns a unique ID automatically.
     *
     * @param insurance Insurance object to add
     */
    public static void addInsurance(Insurance insurance) {
        insurances.put(idCounter++, insurance);
    }

    /**
     * Removes an insurance company from the collection by its unique ID.
     *
     * @param id ID of the insurance company to remove
     */
    public static void removeInsurance(int id) {
        insurances.remove(id);
    }

    /**
     * Retrieves an insurance company by its unique ID.
     *
     * @param id ID of the insurance company to retrieve
     * @return Insurance object if found, otherwise null
     */
    public static Insurance getInsuranceById(int id) {
        return insurances.get(id);
    }

    // ---------- Display Methods ----------

    /**
     * Prints a formatted list of all insurance companies IDs and names.
     */
    public static void getInsuranceCompaniesFullNamesList() {
        System.out.println("================ ALL INSURANCE COMPANIES ================");
        System.out.printf("%-10s | %-30s%n", "Insurance ID", "Company Name");
        System.out.println("---------------------------------------------------------");

        for (Map.Entry<Integer, Insurance> entry : insurances.entrySet()) {
            System.out.printf("%-10d | %-30s%n", entry.getKey(), entry.getValue().getName());
        }

        System.out.println("=========================================================");
    }
}
