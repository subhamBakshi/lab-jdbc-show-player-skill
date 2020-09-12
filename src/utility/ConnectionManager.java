package utility;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		//properties object
		Properties prop = null;
		try {
			prop = loadPropertiesFile();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		final String driver = prop.getProperty("driver");
		final String url = prop.getProperty("url");
		final String username = prop.getProperty("username");
		final String password = prop.getProperty("password");
		
		//Register the driver class
		Class.forName(driver);
		
		//create the connection object
		Connection con = null;
		con =DriverManager.getConnection(url,username,password);
		return con;
	}
	
	  //properties method
	  public static Properties loadPropertiesFile() throws Exception 
	   {
		Properties prop = new Properties();
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);in.close();
		return prop; 
	   } 
	
}
