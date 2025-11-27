package org.sparadrap.dao;

import org.sparadrap.connection.DBconnection;
import org.sparadrap.gui.PatientDisplay;
import org.sparadrap.model.DoctorModel.Doctor;
import org.sparadrap.model.DummyData.DummyData;
import org.sparadrap.model.InsuranceModel.Insurance;
import org.sparadrap.model.InsuranceModel.InsurancePlan;
import org.sparadrap.model.PatientModel.Patient;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DaoPatient {
    public static void addPatient(Patient patient) throws SQLException {
        String sql = "insert into patients (first_name, last_name, social_sec_number, birth_date, telephone, email, city, post_code, address, insurance_id, doctor_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        DBconnection dbcon = new DBconnection();

        try(Connection conn  = dbcon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,patient.getName());
            pstmt.setString(2,patient.getLastName());
            pstmt.setString(3,patient.getSocialSecurityNumber());
            pstmt.setDate(4,java.sql.Date.valueOf(patient.getDateOfBirth()));
            pstmt.setString(5,patient.getTelephone());
            pstmt.setString(6,patient.getEmail());
            pstmt.setString(7,patient.getCity());
            pstmt.setString(8,patient.getPostalCode());
            pstmt.setString(9,patient.getAddress());
            pstmt.setInt(10,patient.getInsuranceId());
            pstmt.setInt(11,patient.getDoctorId());

            pstmt.executeUpdate();
        }
    }
    public static Patient getPatientById(int id) throws SQLException {

        String sql =
                "SELECT " +
                        " p.*, " +
                        " d.doctor_id AS d_id, d.first_name AS d_first_name, d.last_name AS d_last_name, " +
                        " d.address AS d_address, d.post_code AS d_post_code, d.city AS d_city, " +
                        " d.email AS d_email, d.telephone AS d_telephone, d.license_number AS d_license, " +
                        " i.insurance_id AS ins_id, i.insurance_name AS ins_name, i.address AS ins_address, " +
                        " i.post_code AS ins_post_code, i.city AS ins_city, i.email AS ins_email, " +
                        " i.telephone AS ins_telephone, dep.department_number AS dept_number, " +
                        " ip.plan_id AS plan_id, ip.plan_name AS plan_name, ip.coverage AS coverage " +
                        "FROM patients p " +
                        "LEFT JOIN doctors d ON p.doctor_id = d.doctor_id " +
                        "LEFT JOIN insurances i ON p.insurance_id = i.insurance_id " +
                        "LEFT JOIN insurance_plans ip ON i.insurance_id = ip.insurance_id " +
                        "LEFT JOIN departments dep ON i.department_id = dep.department_id " +
                        "WHERE p.patient_id = ?";

        try(Connection conn  = new DBconnection().getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1,id);

            try (ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    return createPatientFromResultSet(rs);
                }
            }
        }
        return null;
    }

    public static ArrayList<Patient> getAllPatients() throws SQLException {

        String sql =
                "SELECT " +
                        " p.*, " +
                        " d.first_name AS d_first_name, d.last_name AS d_last_name, " +
                        " d.address AS d_address, d.post_code AS d_post_code, " +
                        " d.city AS d_city, d.email AS d_email, " +
                        " d.telephone AS d_telephone, d.license_number AS d_license, " +
                        " i.insurance_id AS ins_id, " +
                        " i.insurance_name AS ins_name, i.address AS ins_address, " +
                        " i.post_code AS ins_post_code, i.city AS ins_city, " +
                        " i.email AS ins_email, i.telephone AS ins_telephone, " +
                        " ip.plan_id AS plan_id, ip.plan_name AS plan_name, " +
                        " dep.department_number AS dept_number, " +
                        " ip.coverage AS coverage " +
                        "FROM patients p " +
                        "LEFT JOIN doctors d ON p.doctor_id = d.doctor_id " +
                        "LEFT JOIN insurances i ON p.insurance_id = i.insurance_id " +
                        "LEFT JOIN departments dep ON i.department_id = dep.department_id " +
                        "LEFT JOIN insurance_plans ip ON i.insurance_id = ip.insurance_id";

        ArrayList<Patient> patients = new ArrayList<>();

        try (Connection conn = new DBconnection().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery())
        {

            while (rs.next()) {
                patients.add(createPatientFromResultSet(rs));
            }
        }

        return patients;
    }

    private static Patient createPatientFromResultSet(ResultSet rs) throws SQLException {

        // -------- Doctor --------
        Doctor doctor = new Doctor(
                rs.getString("d_first_name"),
                rs.getString("d_address"),
                rs.getString("d_post_code"),
                rs.getString("d_city"),
                rs.getString("d_email"),
                rs.getString("d_telephone"),
                rs.getString("d_last_name"),
                rs.getString("d_license")
        );

        // -------- Insurance Plans --------
        ArrayList<InsurancePlan> plans = new ArrayList<>();
        String planName = rs.getString("plan_name");
        if (planName != null) {
            plans.add(InsurancePlan.valueOf(planName.trim()));
        }

        // -------- Insurance --------
        Insurance insurance = new Insurance(
                rs.getString("ins_name"),
                rs.getString("ins_address"),
                rs.getString("ins_post_code"),
                rs.getString("ins_city"),
                rs.getString("ins_email"),
                rs.getString("ins_telephone"),
                rs.getString("dept_number"),
                plans
        );

        // -------- Patient --------
        Patient patient = new Patient(
                rs.getString("first_name"),
                rs.getString("address"),
                rs.getString("post_code"),
                rs.getString("city"),
                rs.getString("email"),
                rs.getString("telephone"),
                rs.getString("social_sec_number"),
                rs.getString("last_name"),
                rs.getDate("birth_date").toLocalDate(),
                doctor,
                insurance,
                plans.isEmpty() ? 0 : plans.getFirst().getCoverage()
        );

        return patient;
    }



    public static void deletePatient(int id) throws SQLException {
        String sql = "delete from patients where patient_id = ?";

        try(Connection conn = new DBconnection().getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,id);
            int rowsDeleted = pstmt.executeUpdate();
                if(rowsDeleted > 0){
                    System.out.println("deleted patient");
                }else {
                System.out.println("delete failed");
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        //ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        //doctors = DaoDoctor.getAllDoctors();
        //System.out.println(doctors);
        //System.out.println(DaoInsurance.getInsuranceById(2));
        //System.out.println(DaoDoctor.getAllDoctors());
        //System.out.println(DaoPatient.getAllPatients());
        //System.out.println(DaoPatient.getPatientById(1));
        //PatientDisplay.allPatientsDisplay();
        //DoctorDisplay.allDoctorsDisplay();
        DaoPatient.deletePatient(4);

        Patient patient = new Patient("Isabella", "Name", "1100258796297", LocalDate.of(1996, 1, 22), "0564298347", "isabella@example.com",
                "no mans land", "25000", "70 rue rex", 1, 1 );
        //DaoPatient.addPatient(patient);
    }


}
