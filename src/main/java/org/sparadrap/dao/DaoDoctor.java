package org.sparadrap.dao;

import org.sparadrap.connection.DBconnection;
import org.sparadrap.model.DoctorModel.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import static java.sql.DriverManager.getConnection;

public class DaoDoctor {
    private static final Logger logger = Logger.getLogger(DaoDoctor.class.getName());
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
        }catch (SQLException ex){
            logger.severe("problem getting doctor by id " + ex.getMessage());
        }
        logger.fine("getting Doctor By Id successfully: " + doctor.getId());
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
        logger.fine("getting All Doctors successfully: " + doctors.size());
        return doctors;
    }
}
