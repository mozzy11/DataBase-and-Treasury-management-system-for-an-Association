
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class UPDATE_DB {
     Connection con =DBcon.dbcon();
     
       Statement stmt;
       ResultSet rs;
       

   String m_id;

    
    
        public void Update_DataBase(String fn, String ln, String genda, String m_status2, String couse, String year_in, Date date, String contact1,
            String contact2, String email, String gdian_Name, String gdian_contact, String hm_district, String hm_email, String religon , String A
     
    ) // SAVING THE DATA IN THE DATABASE IE alocting the strings to the coresponding coilumns
    {
           
        try {
            int cont1 = Integer.parseInt(contact1);// converting the strings to int so that they fit in the database
            int cont2 = Integer.parseInt(contact2);
            int cont3 = Integer.parseInt(gdian_contact);
            
           // String dob = String.format("%s %s  %S", DoB, month, day);
           
           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String date2 = sdf.format(date);//converting the date from date picker into string
            
              stmt = (Statement) con.createStatement(rs.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "select m_id from data_base where fname like '" + A + "'  ";//NAME OF TABLE IN DATABASE where to get coresponding mid
            rs = stmt.executeQuery(sql);
            rs.next();
            m_id = rs.getString("m_id" );
            

            String query = "UPDATE data_base  SET fname = '" + fn +" ' where m_id = '"+m_id+"' "; //(select m_id from data_base where fname like '" + editcombo.getSelectedItem()  + "' )";//(0,'" + fn + "','" + ln + "','" + sabb1 + "','" + prime1 + "','" + kHosp1 + "','" + m_id + "', '" + sabbSch1 + "','" + thxGve1 + "','" + devine1 + "', '" + devt1 + "','" + districtProj1 + "','" + lunch1 + "','" + welfare1 + "','" + campExp1 + "','" + evangelism1 + "','" + LCB1 + "','" + otherOffer1 + "', '" + date2 + "' )";
                  
                   
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
