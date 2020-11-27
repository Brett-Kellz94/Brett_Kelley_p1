package TRMSJavalin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	/*Singleton - reuse the same copy of an object in memory
	 * check if instance exists
	 * if it does, return that instance
	 * if not, create the instance and return it
	*/
	
	public Connection createConnection() throws SQLException{                                    
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?", "postgres", "password");
		return conn;
	}
		
	}

	
