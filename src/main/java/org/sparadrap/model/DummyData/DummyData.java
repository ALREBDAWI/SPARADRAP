package org.sparadrap.model.DummyData;

import org.sparadrap.model.DoctorModel.Doctor;
import org.sparadrap.model.DoctorModel.DoctorsList;
import org.sparadrap.model.InsuranceModel.Insurance;
import org.sparadrap.model.InsuranceModel.InsuranceCompaniesList;
import org.sparadrap.model.InsuranceModel.InsurancePlan;
import org.sparadrap.model.MedicineModel.Medicine;
import org.sparadrap.model.MedicineModel.MedicineCategory;
import org.sparadrap.model.MedicineModel.MedicineList;
import org.sparadrap.model.PatientModel.Patient;
import org.sparadrap.model.PatientModel.PatientsList;
import org.sparadrap.model.PrescriptionModel.Prescription;
import org.sparadrap.model.PrescriptionModel.PrescriptionsList;
import org.sparadrap.model.PurchaseModel.Purchase;
import org.sparadrap.model.PurchaseModel.PurchaseList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DummyData {
    public static void dummyData(){

        List<Doctor> doctors = List.of(

                new Doctor(
                        "John", "123 Main St", "1000", "CityA",
                        "john@example.com", "1234567890", "Doe", "APP123"
                ),
                new Doctor(
                        "Jane", "456 Oak St", "2000", "CityB",
                        "jane@example.com", "0987654321", "Smith", "APP456"
                ),
                new Doctor(
                        "Alice", "789 Pine St", "3000", "CityC",
                        "alice@example.com", "1122334455", "Brown", "APP789"
                )
        );
                doctors.forEach(doctor -> {
                    DoctorsList.addDoctor(doctor);});


// ---------------------- insurance dummy data -------------------------

        ArrayList<InsurancePlan> plans1 = new ArrayList<>();
        plans1.add(InsurancePlan.STANDARD);
        plans1.add(InsurancePlan.PREMIUM);

        ArrayList<InsurancePlan> plans2 = new ArrayList<>();
        plans2.add(InsurancePlan.ULTRA);


                Insurance insurance1 = new Insurance(
                        "HealthPlus", "1 Health St", "5000", "CityX",
                        "contact@healthplus.com", "5555555555", "54",plans1
                );
                Insurance insurance2 = new Insurance(
                        "MediCare", "2 Health St", "5001", "CityY",
                        "contact@medicare.com", "6666666666", "54",plans2
                );
                Insurance insurance3 = new Insurance(
                        "WellCare", "3 Health St", "5002", "CityZ",
                        "contact@wellcare.com", "7777777777", "54",plans2
                );
                InsuranceCompaniesList.addInsurance(insurance1);
                InsuranceCompaniesList.addInsurance(insurance2);
                InsuranceCompaniesList.addInsurance(insurance3);


// -------------------- Patients dummy data -----------------------

        List<Patient> patients = List.of(
                new Patient("Michael", "12 Elm St", "1010", "CityX", "michael@example.com", "1111111111",
                        "1231231231235", "Johnson", LocalDate.of(1990, 5, 10), doctors.get(0), insurance1, insurance1.getPlans().get(0).getCoverage()),
                new Patient("Laura", "34 Maple St", "1020", "CityY", "laura@example.com", "2222222222",
                        "1231231234567", "Williams", LocalDate.of(1985, 8, 20), doctors.get(0), insurance2, 30),
                new Patient("David", "56 Oak St", "1030", "CityZ", "david@example.com", "3333333333",
                        "1472583698527", "Brown", LocalDate.of(1978, 12, 5), doctors.get(1), insurance3, 10),
                new Patient("Emma", "78 Pine St", "1040", "CityA", "emma@example.com", "4444444444",
                        "2584567891594", "Davis", LocalDate.of(1992, 3, 15), doctors.get(1), insurance1, 70),
                new Patient("James", "90 Cedar St", "1050", "CityB", "james@example.com", "5555555555",
                        "1471591239514", "Miller", LocalDate.of(1988, 7, 25), doctors.get(1), insurance2, 50),
                new Patient("Sophia", "11 Birch St", "1060", "CityC", "sophia@example.com", "6666666666",
                        "1478526547539", "Wilson", LocalDate.of(1995, 11, 30), doctors.get(2), insurance3, 10),
                new Patient("Daniel", "22 Spruce St", "1070", "CityD", "daniel@example.com", "7777777777",
                        "1472588526872", "Moore", LocalDate.of(1980, 6, 18), doctors.get(2), insurance1, 30),
                new Patient("Olivia", "33 Willow St", "1080", "CityE", "olivia@example.com", "8888888888",
                        "1234896572584", "Taylor", LocalDate.of(1993, 9, 12), doctors.get(2), insurance2, 30),
                new Patient("William", "44 Fir St", "1090", "CityF", "william@example.com", "9999999999",
                        "1471591479875", "Anderson", LocalDate.of(1982, 4, 8), doctors.get(0), insurance3, 10),
                new Patient("Isabella", "55 Aspen St", "1100", "CityG", "isabella@example.com", "1010101010",
                        "1471591239514", "Thomas", LocalDate.of(1996, 1, 22), doctors.get(1), insurance1, 10)
        );
        patients.forEach(patient -> {
            PatientsList.addPatient(patient);});

// ---------------- Medicines dummy data ----------------------

        Medicine med1 = new Medicine("Amoxicillin", MedicineCategory.ANTIBIOTIC, 15, LocalDate.of(2023, 3, 1), 20, true);
        Medicine med2 = new Medicine("Ibuprofen", MedicineCategory.PAINKILLER, 8, LocalDate.of(2022, 10, 15), 50, false);
        Medicine med3 = new Medicine("Paracetamol", MedicineCategory.PAINKILLER, 5, LocalDate.of(2023, 1, 10), 10, false);
        Medicine med4 = new Medicine("Cetirizine", MedicineCategory.ANTIHISTAMINE, 12, LocalDate.of(2023, 6, 20), 40, false);
        Medicine med5 = new Medicine("Influvac", MedicineCategory.VACCINE, 30, LocalDate.of(2023, 9, 1), 15, true);
        MedicineList.addMedicineToStock(med1);
        MedicineList.addMedicineToStock(med2);
        MedicineList.addMedicineToStock(med3);
        MedicineList.addMedicineToStock(med4);
        MedicineList.addMedicineToStock(med5);

// ----------------- Prescriptions dummy data-------------------

        List<Prescription> prescriptions = List.of(
                new Prescription(
                        LocalDate.of(2024, 9, 1),
                        doctors.get(0),
                        patients.get(0),
                        new ArrayList<>(List.of(med1, med2))
                ),
                new Prescription(
                        LocalDate.of(2024, 8, 20),
                        doctors.get(1),
                        patients.get(2),
                        new ArrayList<>(List.of(med3))
                ),
                new Prescription(
                        LocalDate.of(2024, 7, 15),
                        doctors.get(2),
                        patients.get(5),
                        new ArrayList<>(List.of(med4, med5))
                ),
                new Prescription(
                        LocalDate.of(2024, 6, 10),
                        doctors.get(0),
                        patients.get(8),
                        new ArrayList<>(List.of(med2, med3, med4))
                ),
                new Prescription(
                        LocalDate.of(2024, 5, 5),
                        doctors.get(1),
                        patients.get(9),
                        new ArrayList<>(List.of(med1))
                )
        );
        prescriptions.forEach(prescription -> {
            PrescriptionsList.addPrescription(prescription);});

        // ----------------- Purchases dummy data -------------------


        // Purchase with prescription
        Purchase purchase1 = new Purchase(prescriptions.get(0), LocalDate.now(), prescriptions.get(0).getMedicineList());

        // Purchase without prescription (yesterday)
        List<Medicine> medsWithoutRx1 = new ArrayList<>();
        medsWithoutRx1.add(med2);
        medsWithoutRx1.add(med3);
        Purchase purchase2 = new Purchase(LocalDate.now().minusDays(1), medsWithoutRx1);

        // Purchase with prescription (3 days ago)
        Purchase purchase3 = new Purchase(prescriptions.get(1), LocalDate.now().minusDays(3), prescriptions.get(1).getMedicineList());

        // Purchase without prescription (5 days ago)
        List<Medicine> medsWithoutRx2 = new ArrayList<>();
        medsWithoutRx2.add(med4);
        Purchase purchase4 = new Purchase(LocalDate.now().minusDays(5), medsWithoutRx2);

        // Purchase with prescription (7 days ago)
        Purchase purchase5 = new Purchase(prescriptions.get(2), LocalDate.now().minusDays(7), prescriptions.get(2).getMedicineList());

        // Purchase without prescription (10 days ago)
        List<Medicine> medsWithoutRx3 = new ArrayList<>();
        medsWithoutRx3.add(med1);
        medsWithoutRx3.add(med5);
        Purchase purchase6 = new Purchase(LocalDate.now().minusDays(10), medsWithoutRx3);

        PurchaseList.addPurchaseToList(purchase1);
        PurchaseList.addPurchaseToList(purchase2);
        PurchaseList.addPurchaseToList(purchase3);
        PurchaseList.addPurchaseToList(purchase4);
        PurchaseList.addPurchaseToList(purchase5);
        PurchaseList.addPurchaseToList(purchase6);

    }

}
