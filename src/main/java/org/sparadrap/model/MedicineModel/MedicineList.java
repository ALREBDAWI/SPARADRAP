package org.sparadrap.model.MedicineModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the stock of Medicine objects.
 * Provides methods to add, remove, and retrieve medicines by their unique ID.
 */
public class MedicineList {

    /** Stores medicines with a unique ID as key */
    private static Map<Integer, Medicine> medicineStockList = new HashMap<>();

    /** Counter to generate unique IDs for medicines */
    private static int idCounter = 1;

    // ---------- Getters ----------

    /**
     * Returns the map of all medicines in stock.
     *
     * @return Map of medicine ID and Medicine object
     */
    public static Map<Integer, Medicine> getMedicineStockList() {
        return medicineStockList;
    }

    // =======================================
    // ---------- CRUD Operations ----------
    // =======================================

    /**
     * Adds a new medicine to the stock.
     *
     * @param medicine Medicine object to add
     */
    public static void addMedicineToStock(Medicine medicine){
        medicineStockList.put(idCounter++, medicine);
    }

    /**
     * Removes a medicine from the stock.
     *
     * @param id ID of the medicine to remove
     */
    public static void removeMedicineFromStock(int id){
        medicineStockList.remove(id);
    }

    /**
     * Retrieves a medicine from the stock by its unique ID.
     *
     * @param id ID of the medicine to retrieve
     * @return Medicine object if found
     */
    public static Medicine getMedicineById(int id) {
        return medicineStockList.get(id);
    }


}