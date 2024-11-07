package datadrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseConnectivity {
    public static void main(String[] args) throws SQLException {
    	Connection conn=null;
    	try {
		Driver driref = new Driver();
		DriverManager.registerDriver(driref);
		 conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/techpyramid", "root@%", "root");
		Statement stat = conn.createStatement();
		ResultSet resultset = stat.executeQuery("select * from student");
		while(resultset.next()) {
			  System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3));
		}
    	}catch (Exception e) {
		System.out.println("====Handle the exception=======");
		}
    	finally {
    		conn.close();
    		System.out.println("====close the connection====");
		}
		
	}        
}
