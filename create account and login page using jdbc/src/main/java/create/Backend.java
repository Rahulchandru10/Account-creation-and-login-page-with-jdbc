package create;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.*;
public class Backend {
	       static String dbUrl="jdbc:mySql://localhost:3306/users";
	       static String dbUname="root";
	       static String dbPassword="";
	       static String dbDriver="com.mysql.cj.jdbc.Driver";
        public void adduser(String fname,String lname,String email,String pass,String cpass)
        {
        	Connection con = null;
        	try
        	{
                Class.forName(dbDriver);
                con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);
                String a = "insert into user(fname,lname,email,pass,cpass)"+"values('"+fname+"','"+lname+"','"+email+"','"+pass+"','"+cpass+"')";
                Statement s = con.createStatement();
                s.execute(a);
                con.close();
        	}
        	catch(Exception e)
        	{
        		System.out.print(e);
        	}
        }
}
