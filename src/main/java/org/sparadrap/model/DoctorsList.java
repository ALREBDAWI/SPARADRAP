package org.sparadrap.model;

import java.util.ArrayList;
import java.util.List;

public class DoctorsList {
   private static List<Doctor> doctorsList = new ArrayList<>();

   public static List<Doctor> getDoctorsList() {
      return doctorsList;
   }
   public static void addDoctor(Doctor doctor) {
      doctorsList.add(doctor);
   }
   public static void removeDoctor(Doctor doctor) {
      doctorsList.remove(doctor);
   }
}

