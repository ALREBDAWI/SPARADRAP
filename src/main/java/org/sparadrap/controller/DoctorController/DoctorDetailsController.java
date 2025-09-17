package org.sparadrap.controller.DoctorController;

import org.sparadrap.model.DoctorModel.DoctorsList;

import java.util.Scanner;

public class DoctorDetailsController {
    public static void doctorDetails() {
        Scanner sc = new Scanner(System.in);
        DoctorsList.getDoctorsFullNamesList();
        System.out.println("choose doctor by typing his ID");
        int id = sc.nextInt();
        System.out.println(DoctorsList.getDoctorById(id));
    }
}
