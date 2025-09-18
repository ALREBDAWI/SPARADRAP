package org.sparadrap;

import org.sparadrap.model.DummyData.DummyData;
import org.sparadrap.view.MainPage;

/**
 * Main class - entry point of the application.
 * <p>
 * This class initializes dummy data and launches the main menu of the application.
 */
public class Main {

    /**
     * Main method - starts the program.
     * <p>
     * It first loads dummy data into the system using {@link DummyData#dummyData()},
     * then displays the main menu via {@link MainPage#menu()}.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        DummyData.dummyData();
        MainPage.menu();
    }
}