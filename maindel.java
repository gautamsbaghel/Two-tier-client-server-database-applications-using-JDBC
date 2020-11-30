import java.sql.*;
import java.util.*; 
import java.sql.Connection;
import java.sql.DriverManager;

class maindel
{ 
	public static void main(String a[]) 
	{ 
		//Creating the connection 
		String url = "jdbc:mysql://127.0.0.1:3306/mini_project"; 
		String user = "root"; 
		String pass = "root@123"; 

		//Entering the data 
		Scanner k = new Scanner(System.in); 
		System.out.println("Enter the candidate_Id  to be deleted:"); 
		int cand_id = k.nextInt(); 
		

		//Inserting data using SQL query 
		String sql = "delete from mini_project.candidate where candidate_id ="+ cand_id; 
		Connection con=null; 

		try { 
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
			


			//Reference to connection interface 
		    con = (Connection)DriverManager.getConnection(url,user,pass); 
		

			Statement st = con.createStatement(); 
			
			
			int m = st.executeUpdate(sql); 
			if (m == 1) 
				System.out.println("Deleted successfully : "+sql); 
			else
				System.out.println("deletion failed"); 
			con.close();
		} 
		catch(Exception ex) 
		{ 
			System.err.println(ex); 
		} 
	} 
} 
