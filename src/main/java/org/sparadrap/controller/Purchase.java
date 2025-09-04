package org.sparadrap.controller;

import org.sparadrap.model.DummyData.DummyData;

import java.util.Scanner;

public class Purchase {
    public Purchase CreatePurchase(){
        DummyData.dummyData();
        Scanner sc = new Scanner(System.in);
        boolean withPrescription;
        System.out.println("purchase with or without prescription? true / false");
        withPrescription = sc.nextBoolean();
        sc.nextLine();
        if(withPrescription){

        }



    }
}
