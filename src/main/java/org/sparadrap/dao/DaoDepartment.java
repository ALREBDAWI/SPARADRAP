package org.sparadrap.dao;

import org.sparadrap.connection.DBconnection;
import org.sparadrap.model.department.Department;

import java.sql.*;
import java.util.logging.Logger;

public class DaoDepartment {
    public static void addDepartment(Department department) throws SQLException {
        String sql = "insert into departments (department_name, department_number) values(?,?)";
        DBconnection dbcon = new DBconnection();
        try(Connection conn = dbcon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1,department.getName());
            pstmt.setString(2,department.getNumber());
            pstmt.executeUpdate();
        }
    }

    public static Department getDepartmentById(int id) throws SQLException {
        String sql = "select * from departments where department_id=?";
        DBconnection dbcon = new DBconnection();
        Department department = null;
        try(Connection conn = dbcon.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
            pstmt.setInt(1,id);
            try(ResultSet rs = pstmt.executeQuery()){
                if (rs.next()){
                    department = new Department(
                            rs.getInt("department_id"),
                            rs.getString("department_name"),
                            rs.getString("department_number")
                    );
                }
            }
        }
        return department;
    }

    public static void deleteDepartment(Department department) throws SQLException {

    }


}
