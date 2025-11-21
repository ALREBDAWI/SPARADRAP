package org.sparadrap.dao;

import org.sparadrap.connection.DBconnection;
import org.sparadrap.model.InsuranceModel.Insurance;
import org.sparadrap.model.PatientModel.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPatient {
    public static void addPatient(Patient patient) throws SQLException {
        String sql = "insert into patients (first_name, last_name, social_sec_number, telephone, email, post_code, address, insurance_id, doctor_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

        try(Connection conn  = DBconnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,patient.getName());
            pstmt.setString(2,patient.getLastName());
            pstmt.setString(3,patient.getSocialSecurityNumber());
            pstmt.setString(4,patient.getTelephone());
            pstmt.setString(5,patient.getEmail());
            pstmt.setString(6,patient.getPostalCode());
            pstmt.setString(7,patient.getAddress());
            pstmt.setInt(8,patient.getInsurance().getId());
            pstmt.setInt(9,patient.getTreatingDoctor().getId());

            pstmt.executeUpdate();
        }
    }
    public static List<Patient> getAllPatients() throws SQLException {
        ArrayList<Patient> patients = new ArrayList<>();
        String sql = "select * from patients";
        try(Connection conn  = DBconnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()){
            while(rs.next()){
                Patient patient = new Patient(
                        patient.setName(rs.getString("first_name")),
                        patient.setLastName(rs.getString("last_name")),
                        patient.setSocialSecurityNumber(rs.getString("social_sec_number")),
                        patient.setTelephone(rs.getString("telephone")),
                        patient.setEmail(rs.getString("email")),
                        patient.setPostalCode(rs.getString("post_code")),
                        patient.setAddress(rs.getString("address")),
                        patient.getInsurance()

                );
            }
        }return patients;
        }
}
