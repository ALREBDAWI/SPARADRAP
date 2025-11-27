package org.sparadrap.dao;

import org.sparadrap.connection.DBconnection;
import org.sparadrap.model.DoctorModel.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;

public class DaoDoctor {
    public static Doctor getDoctorById(int id) throws SQLException {
        String sql = "select * from doctors where doctor_id=?";

        Doctor doctor = null;
        try (Connection conn = new DBconnection().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()){
                if (rs.next()){
                    doctor = new Doctor(
                            rs.getString("first_name"),
                            rs.getString("address"),
                            rs.getString("post_code"),
                            rs.getString("city"),
                            rs.getString("email"),
                            rs.getString("telephone"),
                            rs.getString("last_name"),
                            rs.getString("license_number")
                    );
                }
            }
        }
        return doctor;
    }

    public static ArrayList<Doctor> getAllDoctors() throws SQLException {
        String sql = "select * from doctors";
        ArrayList<Doctor> doctors = new ArrayList<>();

        try (Connection conn = new DBconnection().getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()){

                while (rs.next()){

                    Doctor doctor = new Doctor(
                            rs.getString("first_name"),
                            rs.getString("address"),
                            rs.getString("post_code"),
                            rs.getString("city"),
                            rs.getString("email"),
                            rs.getString("telephone"),
                            rs.getString("last_name"),
                            rs.getString("license_number")
                    );

                    doctors.add(doctor);

                }
            }
        return doctors;
    }
}
