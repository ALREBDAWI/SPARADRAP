package org.sparadrap.model;

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
}