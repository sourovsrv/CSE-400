package database;
import java.sql.*;
import java.util.*;
public class Data {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public Data(){
        try{
            Class.forName("com.mysql.jdbc.Driver");       
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","");
            st= con.createStatement();   
            
        }catch(Exception ex){
        System.out.println("Surver not found !!!!!");
        }
    } ////end of data cunnection ....
    
 public void getData(){ 
     try{
         String query = "select * from student";
          rs = st.executeQuery(query);
          System.out.println("Record from Database");
          while(rs.next()){
              String id = rs.getString("id");
              String name  = rs.getString("name");
              String email  = rs.getString("Email");
              
          System.out.println("Name : "+name+"\nId : "+id+"\nEmail : "+email);
          }
     }catch(Exception ex){
     System.err.println("Got an exception at insert");
     System.out.println(ex);
     }
 }///end of get data......
 
 public void find_data(String Val){
     try{
         String query = "select * from student";
          rs = st.executeQuery(query);
          while(rs.next()){
              String id = rs.getString("id");
              String name  = rs.getString("name");
              String email  = rs.getString("Email");
              if(id.equalsIgnoreCase(Val))
                System.out.println("Name : "+name+"\nId : "+id+"\nEmail : "+email);
          }
     }catch(Exception ex){
     System.err.println("Got an exception at find data");
     System.out.println(ex);     
     } 
 }//find a data .....
public void insert_data(String id , String name, String Email){
     try
    {
      
      //Calendar calendar = Calendar.getInstance();
     // java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
      
       // the mysql insert statement
      String query = " insert into student(id,name,Email)"  + " values (?, ?, ?)";

      // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, id);
            preparedStmt.setString (2, name);
            preparedStmt.setString (3, Email);

      // execute the preparedstatement
      preparedStmt.execute();
      
      //con.close();
    }
         catch (Exception e)
            {
              System.err.println("Got an exception at insert");
              System.err.println(e.getMessage());
            }
  }////end of insert .........
void data_delete(String Id){
     try
    {

      // create the mysql delete statement.
      // i'm deleting the row where the id is "3", which corresponds to my
      // "Barney Rubble" record.
            String query = "delete from student where id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, Id.toUpperCase());

      // execute the preparedstatement
      preparedStmt.execute();
      
      //con.close();
    }
        catch (Exception e)
            {
              System.err.println("Got an exception! ");
              System.err.println(e.getMessage());
            }
}////end of data delete........
public void update(String id,String name){
         try
    {
      // create the java mysql update preparedstatement
        String query = "update student set name = ? where id = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(1, name);
        preparedStmt.setString(2, id);
       

      // execute the java preparedstatement
      preparedStmt.executeUpdate();
      
      //conn.close();
    }
        catch (Exception e)
        {
          System.err.println("Got an exception at update");
          System.err.println(e.getMessage());
        }
  }

} 
