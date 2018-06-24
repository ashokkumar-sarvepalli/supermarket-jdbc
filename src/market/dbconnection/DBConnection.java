package market.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static Connection con;
	static{
		
		try{
		// load the class of the driver.
		Class.forName("com.mysql.jdbc.Driver");
		// establish the connection.
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "admin");

		}catch(Exception ex){
			
		}
	}
	
	public static Connection getConnection(){
		return con;
	}

}
