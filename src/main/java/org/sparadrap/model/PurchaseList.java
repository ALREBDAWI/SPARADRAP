package org.sparadrap.model;

import java.util.ArrayList;
import java.util.List;

public class PurchaseList {
    private static List<Purchase> purchaseList =  new ArrayList<Purchase>();

    public static List<Purchase> getPurchaseList() {
        System.out.println("getPurchaseList");
        return purchaseList;
    }
    public static void addPurchaseToList(Purchase purchase) {
        purchaseList.add(purchase);
    }
}
