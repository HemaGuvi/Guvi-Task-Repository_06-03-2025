package Task12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlconnectivity {

	public static void main(String[] args) throws SQLException  {
		// TODO Auto-generated method stub
		//step 1
		String url="jdbc:mysql://localhost:3306";
		String username="root";
		String password="root";
		//step 2
		Connection connection = DriverManager.getConnection(url, username, password);
		//step 3
		String createDB = "create Database Task12DB_april1020251";
		String useDB="Use Task12DB_april1020251";
		String createTable="create table Employeedetails(EmpNo int,EName varchar(25),Job varchar(25),Mgr varchar(25),HireDate int,sal int,Comm decimal(10,2),Deptno int)";
		String valuesInsertion = "insert into Employeedetails (EmpNo, EName, Job, Mgr, HireDate, sal, Comm, Deptno) " +
			    "VALUES (8369, 'SMITH', 'CLERK', 8902, 1990-12-18, 800.00, NULL, 20), " +
			    "(8499, 'ANYA', 'SALESMAN', 8698, '1991-02-20', 1600.00, 300.00, 30), " +
			    "(8521, 'SETH', 'SALESMAN', 8698, '1991-02-22', 1250.00, 500.00, 30), " +
			    "(8566, 'MAHADEVAN', 'MANAGER', 8839, '1991-04-22', 2985.00, NULL, 20), " +
			    "(8654, 'MOMIN', 'SALESMAN', 8698, '1991-09-28', 1250, 1400, 30), " +
			    "(8698, 'BINA', 'MANAGER', 8839, '1991-05-01', 2850.00, NULL, 30), " +
			    "(8882, 'SHIVANSH', 'MANAGER', 8839, '1991-06-09', 2450, NULL, 10), " +
			    "(8888, 'SCOTT', 'ANALYST', 8566, '1992-12-09', 3000.00, NULL, 20), " +
			    "(8839, 'AMIR', 'PRESIDENT', NULL, '1991-11-18', 5000.00, NULL, 10), " +
			    "(8844, 'KULDEEP', 'SALESMAN', 8698, '1991-09-08', 1500.00, 0.00, 30);";
		String selectquery="Select * from Employeedetails";
		//step : 4
		Statement smt = connection.createStatement();
		//smt.execute(createDB);
		smt.execute(useDB);
		//smt.execute(createTable);
		//smt.executeUpdate(valuesInsertion);
		ResultSet result= smt.executeQuery(selectquery);
		
		while(result.next())
		{
			System.out.println(result.getInt("EmpNo")+"--->"+result.getString("EName")+"--->"+result.getString("Job")+"--->"+result.getInt("Mgr")+"--->"+result.getInt("HireDate")+"--->"+result.getInt("sal")+"--->"+result.getBigDecimal("Comm")+"--->"+result.getInt("Dept.no."));
		}
			connection.close();
		
}}
