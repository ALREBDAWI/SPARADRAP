package org.sparadrap.model.PurchaseModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages a collection of Purchase objects.
 * Provides methods to add, remove, and retrieve purchases by unique ID.
 */
public class PurchaseList {

    /** Stores purchases with a unique ID as key */
    private static Map<Integer, Purchase> purchaseList = new HashMap<>();

    /** Counter to assign unique IDs to purchases */
    private static int id = 1;

    /**
     * Returns the current map of purchases.
     *
     * @return Map of purchase ID to Purchase object
     */
    public static Map<Integer, Purchase> getPurchaseList() {
        return purchaseList;
    }

    /**
     * Adds a new purchase to the collection with a unique ID.
     *
     * @param purchase Purchase object to add
     */
    public static void addPurchaseToList(Purchase purchase) {
        purchaseList.put(id++, purchase);
    }

    /**
     * Retrieves a purchase by its unique ID.
     *
     * @param id ID of the purchase
     * @return Purchase object if found, otherwise null
     */
    public static Purchase getPurchaseById(int id) {
        return purchaseList.get(id);
    }

    /**
     * Removes a purchase from the collection.
     *
     * @param purchase Purchase object to remove
     */
    public static void removePurchaseFromList(Purchase purchase) {
        purchaseList.values().remove(purchase);
    }
}