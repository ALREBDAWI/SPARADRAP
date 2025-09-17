package org.sparadrap.model.DoctorModel;

import java.util.HashMap;

public class DoctorsList {
   private static HashMap<Integer, Doctor> doctorsMap = new HashMap<>();
   private static int idCounter = 1;

   public static HashMap<Integer, Doctor> getDoctorsMap() {
      return doctorsMap;
   }

   public static void addDoctor(Doctor doctor) {
      doctorsMap.put(idCounter++, doctor);
   }

   public static void removeDoctor(int doctorId) {
      doctorsMap.remove(doctorId);
   }

   public static Doctor getDoctorById(int doctorId) {
      return doctorsMap.get(doctorId);
   }

   public static void getDoctorsFullNamesList() {
      System.out.println("================= ALL DOCTORS ==================");
      System.out.printf("%-10s | %-30s%n", "Doctor ID", "Full Name");
      System.out.println("-------------------------------------------------");

      for (HashMap.Entry<Integer, Doctor> entry : doctorsMap.entrySet()) {
         System.out.printf("%-10d | %-30s%n", entry.getKey(), entry.getValue().getFullName());
      }

      System.out.println("=================================================");
   }
}
