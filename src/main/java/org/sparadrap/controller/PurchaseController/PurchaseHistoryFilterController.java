package org.sparadrap.controller.PurchaseController;

import org.sparadrap.model.PurchaseModel.Purchase;
import org.sparadrap.model.PurchaseModel.PurchaseList;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Controller class to filter purchase history based on date criteria.
 * Provides methods to filter purchases for today, last week, or between two specified dates.
 */
public class PurchaseHistoryFilterController {

        /**
         * Filters the purchases made today.
         *
         * @return a map of purchase IDs to {@link Purchase} objects that were made today
         */
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

        /**
         * Filters the purchases made in the last 7 days, including today.
         *
         * @return a map of purchase IDs to {@link Purchase} objects made in the last week
         */
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

        /**
         * Filters purchases between two user-specified dates (inclusive).
         * Prompts the user to input the start and end dates.
         *
         * @return a map of purchase IDs to {@link Purchase} objects within the specified date range
         */
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

