package database;

public class DataBase {

    public static void main(String[] args) {
       Data connect = new Data();
       //connect.insert_data("UG02-31-12-007","Vocket","null");  //id,name,email
       //connect.data_delete("UG02-31-12-003");  // id .. 
       connect.update("UG02-31-12-001","Vocket");
       connect.getData();
       //connect.find_data("UG02-31-12-001");
    }
}
