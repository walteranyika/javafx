/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickme;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author waltersanchez
 */
public class DBOps {
     // JDBC driver name and database URL

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/USERS";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    
    public static void save(String names,String email,String age,String city)
    {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "INSERT INTO `watu`( `names`, `email`, `age`, `city`) VALUES (?,?,?,?)";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            
            pstmt.setString(1, names);
            pstmt.setString(2, email);
            pstmt.setString(3, age);
            pstmt.setString(4, city);
            pstmt.execute();
            
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally tryÏ

        }
    
    }    
    public static ArrayList<Person> getData()
    {
        Connection conn = null;
        Statement stmt = null;
        ArrayList<Person> data=new ArrayList<>();
        try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                 String sql = "select * from watu limit 10";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) 
                {
                    data.add(new Person(rs.getString("names"), rs.getString("email"), rs.getString("age"), rs.getString("city")));
                }
                rs.close();
                stmt.close();
                stmt.close();
                conn.close();

           } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally tryÏ

        }
        
        
      return data;
    }
}
