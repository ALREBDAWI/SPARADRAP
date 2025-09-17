package org.sparadrap.model.MedicineModel;

import java.util.HashMap;
import java.util.Map;

public class MedicineList {

    private static Map<Integer, Medicine> medicineStockList = new HashMap<>();
    private static int idCounter = 1;

    public static Map<Integer, Medicine> getMedicineStockList() {
        return medicineStockList;
    }

    public static void addMedicineToStock(Medicine medicine){
        medicineStockList.put(idCounter++, medicine);
    }

    public static void removeMedicineFromStock(int id){
        medicineStockList.remove(id);
    }

    public static Medicine getMedicineById(int id) {
        return medicineStockList.get(id);
    }

    public static void main(String[] args) {
        System.out.println(getMedicineStockList());
    }
}