package org.sparadrap.view;

import java.util.Scanner;

public class PatientModifyMenu {
    public static void patientModifyMenu(){

        String[] options = {
                "0 - Go Back",
                "1 - First Name",
                "2 - Last Name",
                "3 - Postal Code",
                "4 - Phone Number",
                "5 - Email",
                "6 - Address",
                "7 - City",
                "8 - Date of Birth",
                "9 - Social Security Number",
                "10 - Treating Doctor",
                "11 - Insurance Company",
                "12 - Insurance Coverage %",
                "13 - See Modified Patient"
        };

        int width = 44;

        System.out.println(ConsoleColors.CYAN_BOLD + "╔" + "═".repeat(width) + "╗" + ConsoleColors.RESET);
        for (String option : options) {
            int paddingRight = width - option.length();
            System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.GREEN + option + " ".repeat(paddingRight - 1) + ConsoleColors.CYAN_BOLD + "║" + ConsoleColors.RESET);
        }
        System.out.println(ConsoleColors.CYAN_BOLD + "╚" + "═".repeat(width) + "╝" + ConsoleColors.RESET);
        System.out.print(ConsoleColors.YELLOW_BOLD + "👉 Enter choice: " + ConsoleColors.RESET);


    }
}
