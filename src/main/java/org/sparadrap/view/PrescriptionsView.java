package org.sparadrap.view;

import org.sparadrap.model.MedicineModel.Medicine;
import org.sparadrap.model.PrescriptionModel.Prescription;

import java.util.HashMap;

public class PrescriptionsView {

    public static void displayPrescriptions(HashMap<Integer, Prescription> prescriptions) {
        System.out.println(ConsoleColors.CYAN_BOLD + "==== Prescriptions List ====" + ConsoleColors.RESET);

        for (Integer id : prescriptions.keySet()) {
            Prescription p = prescriptions.get(id);

            // ID
            System.out.println(ConsoleColors.YELLOW_BOLD + "ID: " + id + ConsoleColors.RESET);

            // Prescription Info
            System.out.println(ConsoleColors.PURPLE + "Date          : " + ConsoleColors.RESET + p.getPrescriptionDate());
            System.out.println(ConsoleColors.PURPLE + "Treating Doctor: " + ConsoleColors.RESET + p.getTreatingDoctor().getFullName());
            System.out.println(ConsoleColors.PURPLE + "Patient       : " + ConsoleColors.RESET + p.getPatient().getFullName());
            System.out.println(ConsoleColors.PURPLE + "Coverage %    : " + ConsoleColors.RESET + p.getPatient().getPercentage() + "%");

            // Medicines List (single line per medicine)
            System.out.println(ConsoleColors.GREEN_BOLD + " Medicines:" + ConsoleColors.RESET);
            for (Medicine medicine : p.getMedicineList()) {
                System.out.printf("  - %s | %s | Price: %.2f | Prescription: %s%n",
                        ConsoleColors.BLUE_BOLD + medicine.getMedicineName() + ConsoleColors.RESET,
                        ConsoleColors.CYAN + medicine.getCategory() + ConsoleColors.RESET,
                        medicine.getPrice(),
                        medicine.isWithPrescription() ? ConsoleColors.RED + "Yes" + ConsoleColors.RESET
                                : ConsoleColors.GREEN + "No" + ConsoleColors.RESET);
            }

            System.out.println(ConsoleColors.CYAN_BOLD + "--------------------------------\n" + ConsoleColors.RESET);
        }
    }

    public static void displayPrescriptionsCompact(HashMap<Integer, Prescription> prescriptions) {
        System.out.println(ConsoleColors.CYAN_BOLD + "==== Prescriptions List (Compact) ====" + ConsoleColors.RESET);

        for (Integer id : prescriptions.keySet()) {
            Prescription p = prescriptions.get(id);

            StringBuilder medsLine = new StringBuilder();
            for (Medicine medicine : p.getMedicineList()) {
                medsLine.append(ConsoleColors.BLUE_BOLD)
                        .append(medicine.getMedicineName())
                        .append(ConsoleColors.RESET)
                        .append(" (")
                        .append(ConsoleColors.CYAN)
                        .append(medicine.getCategory())
                        .append(ConsoleColors.RESET)
                        .append(", Price: ")
                        .append(medicine.getPrice())
                        .append(", Rx: ")
                        .append(medicine.isWithPrescription() ? ConsoleColors.RED + "Yes" + ConsoleColors.RESET
                                : ConsoleColors.GREEN + "No" + ConsoleColors.RESET)
                        .append("); ");
            }

            System.out.printf("%sID:%d%s | Date:%s%s%s | Doctor:%s%s%s | Patient:%s%s%s | Coverage:%s%d%%%s | Medicines: %s%n",
                    ConsoleColors.YELLOW_BOLD, id, ConsoleColors.RESET,
                    ConsoleColors.PURPLE, p.getPrescriptionDate(), ConsoleColors.RESET,
                    ConsoleColors.PURPLE, p.getTreatingDoctor().getFullName(), ConsoleColors.RESET,
                    ConsoleColors.PURPLE, p.getPatient().getFullName(), ConsoleColors.RESET,
                    ConsoleColors.PURPLE, p.getPatient().getPercentage(), ConsoleColors.RESET,
                    medsLine.toString()
            );
        }
        System.out.println(ConsoleColors.CYAN_BOLD + "-------------------------------------\n" + ConsoleColors.RESET);
    }
}
