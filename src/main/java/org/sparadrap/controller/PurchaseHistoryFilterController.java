package org.sparadrap.controller;

import org.sparadrap.model.DummyData.DummyData;
import org.sparadrap.model.Purchase;
import org.sparadrap.model.PurchaseList;
import org.sparadrap.view.PrintPurchaseTable;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PurchaseHistoryFilterController {

        public static Map<Integer,Purchase> toDayFilter() {

            Map<Integer, Purchase> filteredList = new HashMap<>();
            for (Map.Entry<Integer, Purchase> entry : PurchaseList.getPurchaseList().entrySet()) {
                Purchase purchase = entry.getValue();
                if(purchase.getPurchaseDate().isEqual(LocalDate.now())) {
                    filteredList.put(entry.getKey(), purchase);
                }
            }
            return filteredList;
        }

        public static Map<Integer,Purchase> lastWeekFilter() {
            LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);
            Map<Integer, Purchase> filteredList = new  HashMap<>();
            for (Map.Entry<Integer, Purchase> entry : PurchaseList.getPurchaseList().entrySet()) {

                Purchase purchase = entry.getValue();
                LocalDate purchaseDate = purchase.getPurchaseDate();

                if( (purchaseDate.isEqual(sevenDaysAgo) || purchaseDate.isAfter(sevenDaysAgo)) &&
                        (purchaseDate.isEqual(LocalDate.now()) || purchaseDate.isBefore(LocalDate.now())) ) {

                    filteredList.put(entry.getKey(), purchase);

                }
            }
            return filteredList;
        }

        public static Map<Integer,Purchase> betweenTwoDatesFilter() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter start date (yyyy-MM-dd):");
            LocalDate firstDate = LocalDate.parse(sc.nextLine());
            System.out.println("Enter end date (yyyy-MM-dd):");
            LocalDate secondDate = LocalDate.parse(sc.nextLine());
            Map<Integer, Purchase> filteredList = new  HashMap<>();
            for (Map.Entry<Integer, Purchase> entry : PurchaseList.getPurchaseList().entrySet()) {
                Purchase purchase = entry.getValue();
                LocalDate purchaseDate = purchase.getPurchaseDate();
                if( (purchaseDate.isEqual(firstDate) || purchaseDate.isAfter(firstDate)) && (purchaseDate.isEqual(secondDate) || purchaseDate.isBefore(secondDate)) ) {
                    filteredList.put(entry.getKey(), purchase);
                }
            }
            return filteredList;
        }

    }

