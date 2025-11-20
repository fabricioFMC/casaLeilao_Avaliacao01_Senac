
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class conectaDAO {
    
    Connection conn;
    
    public Connection connectDB(){
    
        try {
            conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/casaleilao","root", "1234");
                             
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return conn;
    }
    
    
    
}