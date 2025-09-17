package org.sparadrap.model.PurchaseModel;

import java.util.HashMap;
import java.util.Map;

public class PurchaseList {
    private static Map<Integer, Purchase> purchaseList = new HashMap<>();
    private static int id = 1;

    public static Map<Integer, Purchase> getPurchaseList() {
        return purchaseList;
    }

    public static void addPurchaseToList(Purchase purchase) {
        purchaseList.put(id++, purchase);
    }

    public static Purchase getPurchaseById(int id) {
        return purchaseList.get(id);
    }

    public static void removePurchaseFromList(Purchase purchase) {
        purchaseList.values().remove(purchase);
    }
}