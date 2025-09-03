package org.sparadrap.model;

import java.util.ArrayList;
import java.util.List;

public class InsuranceCompaniesList {

    private static List<Insurance> insurances = new ArrayList<>();

    public static List<Insurance> getInsurance() {
        return insurances;
    }
    public static void addInsurance(Insurance insurance) {
        insurances.add(insurance);
    }
    public static void removeInsurance(Insurance insurance) {
        insurances.remove(insurance);
    }
}
