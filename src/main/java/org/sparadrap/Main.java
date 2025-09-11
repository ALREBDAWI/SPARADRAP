package org.sparadrap;

import org.sparadrap.model.DummyData.DummyData;
import org.sparadrap.view.MainPage;

public class Main {
    public static void main(String[] args) {

        DummyData.dummyData();
        MainPage.menu();
    }
}