package org.sparadrap.view;

import org.sparadrap.model.Medicine;
import org.sparadrap.model.MedicineList;

import java.util.Map;

public class MedsListDisplay {
    public static void medsListDisplay(){
        System.out.println("\nAvailable Medicines:");
        System.out.println("-----------------------------");
        System.out.printf("%-5s | %-25s | %-10s%n", "ID", "Medicine Name", "Stock Qty");
        for (Map.Entry<Integer, Medicine> entry : MedicineList.getMedicineStockList().entrySet()) {
            Medicine m = entry.getValue();
            System.out.printf("%-5d | %-25s | %-10d%n", entry.getKey(), m.getMedicineName(), m.getQuantity());
        }
    }
}
