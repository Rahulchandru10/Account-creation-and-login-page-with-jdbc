package login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import org.apache.catalina.connector.Response;
public class Logincheck {
        static String dbUrl="jdbc:mysql://localhost:3306/users";
        static String dbUname="root";
        static String dbPass="";
        static String dbDriver="com.mysql.cj.jdbc.Driver";
        public boolean chk(String a,String b)
        {
        	Connection con = null;
        	try
        	{
        		Class.forName(dbDriver);
                con = DriverManager.getConnection(dbUrl,dbUname,dbPass);
	        	String c = "select pass from user where fname = '"+a+"' and pass = '"+b+"'";
	        	Statement s = con.createStatement();
	        	ResultSet r = s.executeQuery(c);
	        	r.next();
	        	if(b.equals(r.getString("pass")))
	        		return true;
	        	else
	        		return false;
        	}
        	catch(Exception e)
        	{
        		System.out.print(e);
        		return false;
        	}
        }
}
