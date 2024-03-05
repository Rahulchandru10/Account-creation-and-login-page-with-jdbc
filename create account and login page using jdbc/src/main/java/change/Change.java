package change;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Change {

	static String dbUrl="jdbc:mysql://localhost:3306/users";
	static String dbName = "root";
	static String dbPass="";
	static String dbDriver="com.mysql.cj.jdbc.Driver";
	public void update(String a,String b,String c)
	{
		Connection con = null;
		try
		{
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbUrl,dbName,dbPass);
			String s = "update user set pass = '"+b+"' , cpass = '"+c+"' where email = '"+a+"' " ;
			Statement st = con.createStatement();
			st.execute(s);
			con.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
}
