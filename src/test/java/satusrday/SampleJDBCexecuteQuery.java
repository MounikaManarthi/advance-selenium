package satusrday;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCexecuteQuery {

	public static void main(String[] args) throws SQLException {
		
		//get driver from MySql jar and register this in driver manager
		Driver driverRef=new Driver();
		
		// step : 1 register the driver
		DriverManager.registerDriver(driverRef);
		
		// step : 2 get the connection with driver----- - provide the             dbname
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb", "root", "root");
		
		// step : 3 issue create statement
		Statement state = conn.createStatement();
		
		// step : 4 execute the query     table name
	ResultSet result = state.executeQuery("select * from sampletable;");
		while(result.next())
		{
			System.out.println(result.getString(1)+ " "+result.getString(2)+" "+result.getString(3));//it accepts only coloum index
			
		}
		
		// step : 5 close the database
        conn.close(); 
	}

}
