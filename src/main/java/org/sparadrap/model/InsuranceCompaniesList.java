package org.sparadrap.model;

import java.util.HashMap;
import java.util.Map;

public class InsuranceCompaniesList {

    private static Map<Integer, Insurance> insurances = new HashMap<>();
    private static int idCounter = 1;

    // رجّع كل شركات التأمين
    public static Map<Integer, Insurance> getInsuranceCompaniesList() {
        return insurances;
    }

    // أضف شركة جديدة
    public static void addInsurance(Insurance insurance) {
        insurances.put(idCounter++, insurance);
    }

    // احذف شركة تأمين بالـ ID
    public static void removeInsurance(int id) {
        insurances.remove(id);
    }

    // احصل على شركة تأمين بالـ ID
    public static Insurance getInsuranceById(int id) {
        return insurances.get(id);
    }
}
