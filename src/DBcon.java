

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBcon {
      public static Connection con =null ;
         UPDATE_DB db = new UPDATE_DB ();
    
     public static Connection  dbcon() {
            
          //Connection con =null ; 
        try {
            String host = "jdbc:mysql://localhost:3306/MozzyDB";
            String uName = "root";
            String uPass =  "moses";
          
             Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(host, uName, uPass);
          //  JOptionPane.showMessageDialog(null, "Connected!!");
           
           
            
       
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
              JOptionPane.showInputDialog(null, e.getMessage());
        }; 
    return con; 
    } 
//      public void setCons (){
//       db.setCon(con);
//      }
    
       
}

