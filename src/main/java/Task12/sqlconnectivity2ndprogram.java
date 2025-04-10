package Task12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlconnectivity2ndprogram {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306";
		String username="root";
		String password="root";
		//step 2
		Connection connection = DriverManager.getConnection(url, username, password);
		//step 3
		String createDB = "create Database Task02DB_april10";
		String useDB="Use Task02DB_april10";
		String createTable="create table empdetails(empcode int,empname varchar(25),empage int,esalary int)";
		String insertvalues="insert into empdetails(empcode,empname,empage,esalary) values (101,'Jenny',25,10000),(102,'Jacky',30,20000),(103,'Joe',20,40000),(104,'John',40,80000),(105,'Shammer',25,90000)";
		String selectquery="select * from empdetails";
		//step 4:
		Statement smt = connection.createStatement();
		smt.execute(createDB);
		smt.execute(useDB);
		smt.execute(createTable);
		smt.executeUpdate(insertvalues);
		ResultSet rs= smt.executeQuery(selectquery);
		//step: 5
		while(rs.next())
		{
			System.out.println(rs.getInt("empcode")+"-->"+rs.getString("empname")+"-->"+rs.getInt("empage")+"-->"+rs.getInt("esalary"));
		}
		connection.close();
		
		}
	}


