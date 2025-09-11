package org.sparadrap.model;

import java.util.HashMap;
import java.util.Map;

public class InsuranceCompaniesList {

    private static Map<Integer, Insurance> insurances = new HashMap<>();
    private static int idCounter = 1;

    public static Map<Integer, Insurance> getInsuranceCompaniesList() {
        return insurances;
    }

    public static void addInsurance(Insurance insurance) {
        insurances.put(idCounter++, insurance);
    }

    public static void removeInsurance(int id) {
        insurances.remove(id);
    }

    public static Insurance getInsuranceById(int id) {
        return insurances.get(id);
    }

    public static void getInsuranceCompaniesFullNamesList() {
        System.out.println("================ ALL INSURANCE COMPANIES ================");
        System.out.printf("%-10s | %-30s%n", "Insurance ID", "Company Name");
        System.out.println("---------------------------------------------------------");

        for (Map.Entry<Integer, Insurance> entry : insurances.entrySet()) {
            System.out.printf("%-10d | %-30s%n", entry.getKey(), entry.getValue().getName());
        }

        System.out.println("=========================================================");
    }
}
