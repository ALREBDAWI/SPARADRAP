package org.sparadrap;

import org.sparadrap.controller.PurchaseController;
import org.sparadrap.model.*;
import org.sparadrap.model.DummyData.DummyData;
import org.sparadrap.view.Menu;

import java.time.LocalDate;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*DummyData.dummyData();
        System.out.println(PrescriptionsList.getPrescriptions());
        System.out.println(PatientsList.getPatientsList());
        System.out.println(DoctorsList.getDoctorsList());
        System.out.println(InsuranceCompaniesList.getInsuranceCompaniesList());
        PurchaseController.CreatePurchase();
        System.out.println(PurchaseList.getPurchaseList());*/
        Menu.menu();


    }
}