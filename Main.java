import java.sql.*;
import java.util.*; 
import java.sql.Connection;
import java.sql.DriverManager;

class Main 
{ 
	public static void main(String a[]) 
	{ 
		//Creating the connection 
		String url = "jdbc:mysql://127.0.0.1:3306/mini_project"; 
		String user = "root"; 
		String pass = "root@123"; 

		//Entering the data 
		Scanner k = new Scanner(System.in); 
		System.out.println("Enter Firstname:"); 
		String fname = k.next(); 
		System.out.println("Enter Lastname:"); 
		String lname = k.next(); 
		System.out.println("Enter Mobile:"); 
		String mobile = k.next(); 
		System.out.println("Enter Email (*This will be your username):"); 
		String email = k.next();
		
		String chkQuery = "select candidate_id from candidate where email = '"+email+"';";

		//Inserting data using SQL query 
		String sql = "insert into mini_project.candidate (firstname, lastname, mobile, email, created_on) values('"+fname+"','"+lname+"','"+mobile+"','"+email+"', now())"; 
		Connection con=null; 

		try { 
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
			


			//Reference to connection interface 
		    con = (Connection)DriverManager.getConnection(url,user,pass); 
		

			Statement st = con.createStatement(); 
			
			Object objId = st.execute(chkQuery);
			
			int m = st.executeUpdate(sql); 
			if (m == 1) 
				System.out.println("inserted successfully : "+sql); 
			else
				System.out.println("insertion failed"); 
			con.close();
		} 
		catch(Exception ex) 
		{ 
			System.err.println(ex); 
		} 
	} 
} 
