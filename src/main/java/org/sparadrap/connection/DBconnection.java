package org.sparadrap.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DBconnection {
        private static String url = "jdbc:mysql://localhost:3306/sparadrap_db?useSSL=false&serverTimezone=UTC";
        private static String user = "root";
        private static String password = "root";
        private static Connection conn = null;

        public  Connection getConnection() throws SQLException {

            try{
                if(conn == null || conn.isClosed()){
                    conn = DriverManager.getConnection(url, user, password);
                    System.out.println("Connected to database successfully");
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            return conn;
        }

        public static void closeConnection() throws SQLException{
            try {
                if (conn != null || !conn.isClosed()) {
                    conn.close();
                    System.out.println("Connection closed successfully");
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
