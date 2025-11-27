package org.sparadrap.gui;

import org.sparadrap.dao.DaoPatient;
import org.sparadrap.model.PatientModel.Patient;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class PatientDisplay {

    public static void allPatientsDisplay() throws SQLException {
        ArrayList<Patient> patients = DaoPatient.getAllPatients();
        String[] columnsNames = {
                "first_name", "last_name", "social security number", "birth date", "telephone", "email", "city", "postal code",
                "address", "insurance"
        };

        Object[][] data = new Object[patients.size()][columnsNames.length];
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            data[i][0] = patient.getName();
            data[i][1] = patient.getLastName();
            data[i][2] = patient.getSocialSecurityNumber();
            data[i][3] = patient.getDateOfBirth();
            data[i][4] = patient.getTelephone();
            data[i][5] = patient.getEmail();
            data[i][6] = patient.getCity();
            data[i][7] = patient.getPostalCode();
            data[i][8] = patient.getAddress();
            data[i][9] = patient.getInsurance().getName();
        }
        JTable table = new JTable(data, columnsNames);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame("all patients");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
