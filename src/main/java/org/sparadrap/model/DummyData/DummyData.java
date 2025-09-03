package org.sparadrap.model.DummyData;

import org.sparadrap.model.*;

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

                Insurance insurance1 = new Insurance(
                        "HealthPlus", "1 Health St", "5000", "CityX",
                        "contact@healthplus.com", "5555555555", "54", 80
                );
                Insurance insurance2 = new Insurance(
                        "MediCare", "2 Health St", "5001", "CityY",
                        "contact@medicare.com", "6666666666", "54", 30
                );
                Insurance insurance3 = new Insurance(
                        "WellCare", "3 Health St", "5002", "CityZ",
                        "contact@wellcare.com", "7777777777", "54", 35
                );
                InsuranceCompaniesList.addInsurance(insurance1);
                InsuranceCompaniesList.addInsurance(insurance2);
                InsuranceCompaniesList.addInsurance(insurance3);



// -------------------- Patients dummy data -----------------------

        List<Patient> patients = List.of(
                new Patient("Michael", "12 Elm St", "1010", "CityX", "michael@example.com", "1111111111",
                        "SSN001", "Johnson", LocalDate.of(1990, 5, 10), doctors.get(0), insurance1),
                new Patient("Laura", "34 Maple St", "1020", "CityY", "laura@example.com", "2222222222",
                        "SSN002", "Williams", LocalDate.of(1985, 8, 20), doctors.get(0), insurance2),
                new Patient("David", "56 Oak St", "1030", "CityZ", "david@example.com", "3333333333",
                        "SSN003", "Brown", LocalDate.of(1978, 12, 5), doctors.get(1), insurance3),
                new Patient("Emma", "78 Pine St", "1040", "CityA", "emma@example.com", "4444444444",
                        "SSN004", "Davis", LocalDate.of(1992, 3, 15), doctors.get(1), insurance1),
                new Patient("James", "90 Cedar St", "1050", "CityB", "james@example.com", "5555555555",
                        "SSN005", "Miller", LocalDate.of(1988, 7, 25), doctors.get(1), insurance2),
                new Patient("Sophia", "11 Birch St", "1060", "CityC", "sophia@example.com", "6666666666",
                        "SSN006", "Wilson", LocalDate.of(1995, 11, 30), doctors.get(2), insurance3),
                new Patient("Daniel", "22 Spruce St", "1070", "CityD", "daniel@example.com", "7777777777",
                        "SSN007", "Moore", LocalDate.of(1980, 6, 18), doctors.get(2), insurance1),
                new Patient("Olivia", "33 Willow St", "1080", "CityE", "olivia@example.com", "8888888888",
                        "SSN008", "Taylor", LocalDate.of(1993, 9, 12), doctors.get(2), insurance2),
                new Patient("William", "44 Fir St", "1090", "CityF", "william@example.com", "9999999999",
                        "SSN009", "Anderson", LocalDate.of(1982, 4, 8), doctors.get(0), insurance3),
                new Patient("Isabella", "55 Aspen St", "1100", "CityG", "isabella@example.com", "1010101010",
                        "SSN010", "Thomas", LocalDate.of(1996, 1, 22), doctors.get(1), insurance1)
        );
        patients.forEach(patient -> {PatientsList.addPatient(patient);});

// ---------------- Medicines dummy data ----------------------

        Medicine med1 = new Medicine("Amoxicillin", MedicineCategory.ANTIBIOTIC, 15, LocalDate.of(2023, 3, 1), 20, true);
        Medicine med2 = new Medicine("Ibuprofen", MedicineCategory.PAINKILLER, 8, LocalDate.of(2022, 10, 15), 50, false);
        Medicine med3 = new Medicine("Paracetamol", MedicineCategory.PAINKILLER, 5, LocalDate.of(2023, 1, 10), 100, false);
        Medicine med4 = new Medicine("Cetirizine", MedicineCategory.ANTIHISTAMINE, 12, LocalDate.of(2023, 6, 20), 40, false);
        Medicine med5 = new Medicine("Influvac", MedicineCategory.VACCINE, 30, LocalDate.of(2023, 9, 1), 15, true);


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
        prescriptions.forEach(prescription -> {PrescriptionsList.addPrescription(prescription);});
    }

    public static void main(String[] args) {
        DummyData.dummyData();
        System.out.println(PrescriptionsList.getPrescriptions());
        System.out.println(PatientsList.getPatientsList());
        System.out.println(DoctorsList.getDoctorsList());
        System.out.println(InsuranceCompaniesList.getInsurance());
    }
}
