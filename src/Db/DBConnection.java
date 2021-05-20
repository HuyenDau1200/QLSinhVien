/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import com.microsoft.sqlserver.jdbc.SQLServerXAResource;
import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class DBConnection {
        java.sql.Connection conn=null;
         private ResultSet rs=null;
    public java.sql.Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost;databaseName=QL_diem_SV;user=sa;password=123";
             conn=DriverManager.getConnection(url);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không kết nối được với cơ sở dữ liệu");
        }
        return conn;
    }
    public void closeConnection(){
        try {
            if(rs != null){
                rs.close();
            }
            if(conn != null){
                conn.close();
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
