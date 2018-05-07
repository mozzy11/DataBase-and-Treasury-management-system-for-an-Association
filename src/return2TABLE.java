
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class return2TABLE {
    
     Connection con =DBcon.dbcon();
       Statement stmt;
       ResultSet rs;
       Date date;
       /**public JTable  general_WEEK_sum;
       public JTable  database_table;
       
       public void setTable( JTable  general_WEEK_sum , JTable  database_table){
       this.general_WEEK_sum = general_WEEK_sum;
       this.database_table = database_table;
       }**/
    
         public void getdate(Date date){
      this.date= date;}
         
    public Vector<Vector<String>> data; //used to get data from database to populate tabe
    public Vector<String> header; //used to store data header
    
  
   
    
      public Vector get() {
          
           //Date date = datePicker_generalReport.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String date3 = sdf.format(date);

        Vector<Vector<String>> doublevector = new Vector<Vector<String>>();
        try {
        PreparedStatement pre1 = con.prepareStatement("select * from data_base db INNER JOIN trust_fund tf ON tf.m_id=db.m_id  WHERE date_entry =( SELECT date_entry From trust_fund where date_entry like'"+date3+"')");//for combining two tables only

            ResultSet rs1 = pre1.executeQuery();
            while (rs1.next()) {
                Vector<String> singlevector = new Vector<String>();
                //singlevector.add(rs1.getString(1));
                singlevector.add(rs1.getString(2));
                singlevector.add(rs1.getString(3));
                singlevector.add(rs1.getString(19));
                singlevector.add(rs1.getString(20));
                singlevector.add(rs1.getString(21));
                singlevector.add(rs1.getString(22));
                singlevector.add(rs1.getString(23));
                singlevector.add(rs1.getString(25));
                singlevector.add(rs1.getString(26));
                singlevector.add(rs1.getString(27));
                singlevector.add(rs1.getString(28));
                singlevector.add(rs1.getString(29));
                singlevector.add(rs1.getString(30));
                singlevector.add(rs1.getString(31));
                singlevector.add(rs1.getString(32));
                singlevector.add(rs1.getString(33));
                singlevector.add(rs1.getString(34));
                singlevector.add(rs1.getString(35));
                doublevector.add(singlevector);

            }
        } catch (Exception e) {
        }

        return doublevector;
    }
    
       public void fillTable() {
        data = get();

//create header for the table
        header = new Vector<String>();
        header.add("First Name");
        header.add("Last Name");
        header.add("Tithe");
        header.add("Campmeeting offer");
        header.add("13 Sabbath");
        header.add("prime Radio");
        header.add("Kireka Hospital");
        header.add("sabbath School");
        header.add("Thanks Giving");
        header.add("Devine");
        header.add("Develpment");
        header.add("District project");
        header.add("lunch");
        header.add("well Fare");
        header.add("Evangelism");
        header.add("L.C.B");
        header.add("Other offering");
        //DefaultTableModel model = new DefaultTableModel(data, header);
       // general_WEEK_sum.setModel(model);
    }

       
       
       //RETURNING TO GENERAL DATABASE
         
       
        
    public Vector<Vector<String>> data_databae; //used to get data from database to populate tabe
    public Vector<String> header_database; //used to store data header 
    
    public Vector get2() {

        Vector<Vector<String>> doublevector = new Vector<Vector<String>>();
        try {
        PreparedStatement pre1 = con.prepareStatement("select * from data_base ");//for combining two tables only
 //           PreparedStatement pre1 = con.prepareStatement("select * from data_base db INNER JOIN trust_fund tf INNER JOIN combd_offer co INNER JOIN general_offering go ON tf.m_id = db.m_id and co.m_id =db.m_id and go.m_id= db.m_id ");
            

            ResultSet rs2 = pre1.executeQuery();
            while (rs2.next()) {
                Vector<String> singlevector = new Vector<String>();
                //singlevector.add(rs1.getString(1));
                singlevector.add(rs2.getString(2));
                singlevector.add(rs2.getString(3));
                singlevector.add(rs2.getString(4));
                singlevector.add(rs2.getString(5));
                singlevector.add(rs2.getString(6));
                singlevector.add(rs2.getString(7));
                singlevector.add(rs2.getString(8));
                singlevector.add(rs2.getString(9));
                singlevector.add(rs2.getString(10));
                singlevector.add(rs2.getString(11));
                singlevector.add(rs2.getString(12));
                singlevector.add(rs2.getString(13));
                singlevector.add(rs2.getString(14));
                singlevector.add(rs2.getString(15));
                singlevector.add(rs2.getString(16));
              doublevector.add(singlevector);

            }
        } catch (Exception e) {
        }

        return doublevector;
    }

   // MAKES THE HEADERS FOR THE GENERAL RETURN DATABASE TABLE
    public void filldatabaseTable() {
        data_databae = get2();

//create header for the table
        header_database = new Vector<String>();
        header_database.add("First Name");
       header_database.add("SECOND NAME");
        header_database.add("GENDER");
        header_database.add("MARITAL STATUS");
       header_database.add("COURSE");
        header_database.add("YEAR OF ENTRY");
       header_database.add("DATE OF BIRTH");
        header_database.add("CONTACT 1");
        header_database.add("CONTACT 2");
        header_database.add("EMAIL ADDRESS");
        header_database.add("GURDIAN'S NAMES");
       header_database.add("GURDIAN'S CONTACT");
       header_database.add("HOME DISTRICT");
        header_database.add("EMAIL ADREES");
       header_database.add("HOME RELOGION");
      // DefaultTableModel model = new DefaultTableModel(data_databae, header_database);
        //database_table.setModel(model);
    }


   
}
