package org.sparadrap.view;

public class PurchaseControllerChoiceMenu {
    public static void purchaseMenu(){

        System.out.println("\n" + ConsoleColors.CYAN_BOLD + "╔═════════════════════════╗" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.GREEN + "1. With Prescription   " + ConsoleColors.CYAN_BOLD + " ║" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.GREEN + "2. Without Prescription" + ConsoleColors.CYAN_BOLD + " ║" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.RED + "0. Go Back             " + ConsoleColors.CYAN_BOLD + " ║" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + "╚═════════════════════════╝" + ConsoleColors.RESET);
        System.out.print(ConsoleColors.YELLOW_BOLD + "👉 Enter choice: " + ConsoleColors.RESET);




    }
}
