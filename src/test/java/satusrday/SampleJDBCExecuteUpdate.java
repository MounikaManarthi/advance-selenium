package satusrday;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		//get driver from MySql jar and register this in driver manager
				Driver driverRef=new Driver();
				
				// step : 1 register the driver
				DriverManager.registerDriver(driverRef);
				
				// step : 2 get the connection with driver----- - provide the             dbname
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb", "root", "root");
				
				// step : 3 issue create statement
				Statement state = conn.createStatement();
				
				// step : 4 execute the query -provide    table name
			   String query = "insert into sampletable values('jack',5,'california'); ";
				int result = state.executeUpdate(query);
			   
			   //validate
				if(result==1)
				{
					System.out.println("data added");
				}
				else
				{
					System.out.println("data not added");
				}
				
				ResultSet res = state.executeQuery("select * from sampletable");
				while(res.next())
				{
					System.out.println(res.getString(1));
				}
				// step : 5 close the database
		        conn.close(); 

	}

}
