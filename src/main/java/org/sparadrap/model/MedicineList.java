package org.sparadrap.model;

import java.util.ArrayList;
import java.util.List;

public class MedicineList {

    // creating list
    private static List<Medicine> medicineList =  new ArrayList<>();


    public static List<Medicine> getMedicineList() {
        return medicineList;
    }

    public static void addMedicine(Medicine medicine){
        medicineList.add(medicine);
    }

    public static void removeMedicine(Medicine medicine){
        medicineList.remove(medicine);
    }
}
