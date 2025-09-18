package org.sparadrap.model.DoctorModel;

import java.util.HashMap;

   /**
    * Manages a collection of Doctor objects.
    * Provides static methods to add, remove, retrieve, and display doctors.
    */
public class DoctorsList {

   /** Stores doctors with a unique ID as key */
   private static HashMap<Integer, Doctor> doctorsMap = new HashMap<>();

   /** Counter to generate unique IDs for doctors */
   private static int idCounter = 1;

   // ---------- Getters ----------

      /**
       * Returns the map of all doctors.
       *
       * @return HashMap where key is doctor ID and value is Doctor object
       */
   public static HashMap<Integer, Doctor> getDoctorsMap() {
      return doctorsMap;
   }

      // =====================================
      // ---------- CRUD Operations ----------
      // =====================================

      /**
       * Adds a new doctor to the collection and assigns a unique ID automatically.
       *
       * @param doctor Doctor object to add
       */
   public static void addDoctor(Doctor doctor) {
      doctorsMap.put(idCounter++, doctor);
   }

      /**
       * Removes a doctor from the collection by their unique ID.
       *
       * @param doctorId ID of the doctor to remove
       */
   public static void removeDoctor(int doctorId) {
      doctorsMap.remove(doctorId);
   }

      /**
       * Retrieves a doctor by their unique ID.
       *
       * @param doctorId ID of the doctor to retrieve
       * @return Doctor object if found, otherwise null
       */
   public static Doctor getDoctorById(int doctorId) {
      return doctorsMap.get(doctorId);
   }

      /**
       * Prints a formatted list of all doctors' IDs and full names.
       */
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
