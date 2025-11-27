package org.sparadrap.dao;

import org.sparadrap.connection.DBconnection;
import org.sparadrap.model.InsuranceModel.InsurancePlan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoInsurancePlans {
    public static ArrayList<InsurancePlan> getInsurancePlans(int id) throws SQLException {

            String sql = "select plan_name from insurance_plans where insurance_id = ?";

        ArrayList<InsurancePlan> insurancePlans = new ArrayList<>();

            try (Connection conn = new DBconnection().getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql);
            ){
                pstmt.setInt(1, id);
                try (ResultSet rs = pstmt.executeQuery()){
                    while (rs.next()) {

                        String planName = rs.getString("plan_name");
                        if(planName != null){
                            try {
                                InsurancePlan plan = InsurancePlan.valueOf(planName.trim());
                                insurancePlans.add(plan);
                            }catch(IllegalArgumentException e){
                                System.out.println("invalid enum name " + e.getMessage());
                            }
                        }
                    }
                }
            }
            return insurancePlans;
        }
    }

