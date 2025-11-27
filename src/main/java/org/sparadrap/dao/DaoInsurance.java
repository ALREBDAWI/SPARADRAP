package org.sparadrap.dao;

import org.sparadrap.connection.DBconnection;
import org.sparadrap.model.InsuranceModel.Insurance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DaoInsurance {
    public static Insurance getInsuranceById(int id) throws SQLException {
        String sql = "select * from insurances where insurance_id=?";

        Insurance insurance = null;

        try(Connection conn = new DBconnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, id);

            try(ResultSet rs = pstmt.executeQuery()){

                if(rs.next()){
                    insurance = new Insurance(
                            rs.getString("insurance_name"),
                            rs.getString("address"),
                            rs.getString("post_code"),
                            rs.getString("city"),
                            rs.getString("email"),
                            rs.getString("telephone"),
                            "55", //rs.getString("department_id"), //fix here
                            DaoInsurancePlans.getInsurancePlans(rs.getInt("insurance_id"))
                    );
                }
            }
        }
        return insurance;
    }

}
