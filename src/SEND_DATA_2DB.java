
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
//ResultSetput

public class SEND_DATA_2DB {
      Connection con = DBcon.dbcon();
    
    
    
    //FIELDS
    Statement stmt;
    ResultSet rs;
    
    
      public void saveDataBase(String fn, String ln, String genda, String m_status2, String couse, String year_in, Date date, String contact1,
            String contact2, String email, String gdian_Name, String gdian_contact, String hm_district, String hm_email, String religon,
            String IMGdir
     
    ) // SAVING THE DATA IN THE DATABASE IE alocting the strings to the coresponding coilumns
    {
        try {
            int cont1 = Integer.parseInt(contact1);// converting the strings to int so that they fit in the database
            int cont2 = Integer.parseInt(contact2);
            int cont3 = Integer.parseInt(gdian_contact);
            
           // String dob = String.format("%s %s  %S", DoB, month, day);
           
           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String date2 = sdf.format(date);//converting the date from date picker into string
            
            // SENDING IMAGE FILE
            File imgfile = new File (IMGdir);
        FileInputStream Fis = new FileInputStream (imgfile);
            
            stmt = (Statement) con.createStatement(rs.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select * From data_base";//NAME OF TABLE IN DATABASE
            rs = stmt.executeQuery(sql);

            rs.moveToInsertRow();
            rs.updateString("fname", fn);
            rs.updateString("lname", ln);
            rs.updateString("Gender", genda);
            rs.updateString("marriage_status", m_status2);
            rs.updateString("course", couse);
            rs.updateString("year_in", year_in);
            rs.updateString("Date_of_birth", date2);
            rs.updateInt("contact1", cont1);
            rs.updateInt("contact2", cont2);
            rs.updateString("email", email);
            rs.updateString("gurdian_name", gdian_Name);
            rs.updateInt("gurdian_contact", cont3);
            rs.updateString("home_district", hm_district);
            rs.updateString("gurdian_email", hm_email);
            rs.updateString("home_religion", religon);
            rs.updateBinaryStream("images", (InputStream) Fis,(int)imgfile.length());
            
            rs.insertRow();
            JOptionPane.showMessageDialog(null, "Saved successfully!!");
            stmt.close();
            rs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
         
      
       public void saveTrustFund(String xtian_name, String tithe, String camp, String sabb, String prime, String kHosp, Date date,
      String sabbSch, String thxGve, String devine,  String devt, String districtProj, String lunch, String welfare, String campExp,
            String evangelism, String LCB, String otherOffer  )  
     // SAVING THE DATA IN THE DATABASE IE alocting the strings to the coresponding coilumns
    {
        try {
            float tithe1 = Float.parseFloat(tithe);
            float camp1 = Float.parseFloat(camp);
            float sabb1 = Float.parseFloat(sabb);
            float prime1 = Float.parseFloat(prime);
            float kHosp1 = Float.parseFloat(kHosp);
            float sabbSch1 = Float.parseFloat(sabbSch);
            float thxGve1 = Float.parseFloat(thxGve);
            float devine1 = Float.parseFloat(devine);
             float devt1 = Float.parseFloat(devt);
            float districtProj1 = Float.parseFloat(districtProj);
            float lunch1 = Float.parseFloat(lunch);
            float welfare1 = Float.parseFloat(welfare);
            float campExp1 = Float.parseFloat(campExp);
            float evangelism1 = Float.parseFloat(evangelism);
            float LCB1 = Float.parseFloat(LCB);
            float otherOffer1 = Float.parseFloat(otherOffer);
            stmt = (Statement) con.createStatement(rs.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select * From data_base WHERE fname like '%" + xtian_name + "%'";//NAME OF TABLE IN DATABASE where to get coresponding mid
            rs = stmt.executeQuery(sql);
            rs.next();
            String m_id = rs.getString("m_id");
            //JOptionPane.showMessageDialog(rootPane, m_id);
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String date2 = sdf.format(date);

            String query = "INSERT INTO trust_fund VALUES(0,'" + tithe1 + "','" + camp1 + "','" + sabb1 + "','" + prime1 + "','" + kHosp1 + "','" + m_id + "', '" + sabbSch1 + "','" + thxGve1 + "','" + devine1 + "', '" + devt1 + "','" + districtProj1 + "','" + lunch1 + "','" + welfare1 + "','" + campExp1 + "','" + evangelism1 + "','" + LCB1 + "','" + otherOffer1 + "', '" + date2 + "' )";
                  
                   
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved successfully!!");

            stmt.close();
           rs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
    
}
