package koneksidb;
import java.sql.*;
import javax.swing.JOptionPane;

// by adji muhamad zidan
public class koneksi_db {
    Connection sambung_db;
    
    public static Connection sambung_db() {
        try {
            String host = "jdbc:mysql://localhost/sistem_rekam_medis";
            String user = "root";
            String pass = "";
            String driver = "com.mysql.jdbc.Driver";
            
            Class.forName(driver);
            Connection sambung_db = DriverManager.getConnection(host, user, pass);
            return sambung_db;
        }
        
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return null;
    }
}
