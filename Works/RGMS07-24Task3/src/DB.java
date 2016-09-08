import java.sql.*;

import javax.swing.JOptionPane;

public class DB{
	public static Statement st;
	public static void connectdb(){
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			Connection conn=DriverManager.getConnection("jdbc:odbc:RGMSDB");
			
			st= conn.createStatement();

		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}

}
