package org.sparadrap.gui;

import org.sparadrap.dao.DaoDoctor;
import org.sparadrap.model.DoctorModel.Doctor;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorDisplay {
    public static void allDoctorsDisplay() throws SQLException {
        ArrayList<Doctor> doctors = DaoDoctor.getAllDoctors();
        String[] columnsNames = {"first name", "last name", "license number", "telephone", "email", "postal code", "city", "address"};

        Object[][] data = new Object[doctors.size()][columnsNames.length];
        for (int i =0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            data[i][0] = doctor.getName();
            data[i][1] = doctor.getLastName();
            data[i][2] = doctor.getApprovalNumber();
            data[i][3] = doctor.getTelephone();
            data[i][4] = doctor.getEmail();
            data[i][5] = doctor.getPostalCode();
            data[i][6] = doctor.getCity();
            data[i][7] = doctor.getAddress();
        }
        JTable table = new JTable(data, columnsNames);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame("all doctors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
