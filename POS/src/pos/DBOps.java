/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author waltersanchez
 */
public class DBOps {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/POS";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public static boolean login(String username,String password) {
        Connection conn = null;
        Statement stmt = null;
        boolean success=false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "select * from users WHERE username='"+username+"' AND password='"+password+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) 
            {
              success=true;
            }
            rs.close();
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
      return success;
    } 
    public static void saveProduct(String names,int qty,int price,String category)
    {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "INSERT INTO `stocks`(`name`, `qty`, `price`, `category`) VALUES  (?,?,?,?)";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            
            pstmt.setString(1, names);
            pstmt.setInt(2, qty);
            pstmt.setInt(3, price);
            pstmt.setString(4, category);
            System.out.println(pstmt.toString());
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
    
    public static ArrayList<Item> getData()
    {
        Connection conn = null;
        Statement stmt = null;
        ArrayList<Item> data=new ArrayList<>();
        try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                 String sql = "select * from stocks";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) 
                {
                    data.add(new Item(rs.getString("name"), 1, rs.getInt("price"), rs.getInt("price")));
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
