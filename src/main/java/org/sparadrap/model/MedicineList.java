package org.sparadrap.model;

import java.util.ArrayList;
import java.util.List;

public class MedicineList {

    // creating list
    private static List<Medicine> medicineStockList =  new ArrayList<>();


    public static List<Medicine> getMedicineStockList() {
        return medicineStockList;
    }

    public static void addMedicineToStock(Medicine medicine){
        medicineStockList.add(medicine);
    }

    public static void removeMedicineFromStock(Medicine medicine){
        medicineStockList.remove(medicine);
    }
}
