

import java.io.IOException;



import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;











import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	Connection con = null;
	
	ResultSet rs;

	
	
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }


    
    public void init(ServletConfig config) throws ServletException {
    	try {
			con = DbConnection.getConnection();
			System.out.print("Connection Established");
			
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	String uname=request.getParameter("uname");
	String fname=request.getParameter("fname");
	String lname=request.getParameter("lname");
	String password=request.getParameter("password");
	
	String email=request.getParameter("email");
	String phno=request.getParameter("phno");
	String location=request.getParameter("location");
	PreparedStatement ps;
	try 
	{

		Statement st = con.createStatement();
		System.out.println("1");
		
	 ps = con.prepareStatement("insert into `myproject`.`registration`(`uname`,`pword`,`fname`,`lname`,`email`,`phno`,`location`) values('"+uname+"','"+password+"','"+fname+"','"+lname+"','"+email+"','"+phno+"','"+location+"')");
		
		
		int result =ps.executeUpdate();
		if (result>0)
			
		{
			System.out.print("Registered Successfully");
			response.sendRedirect("Registration.jsp?Add=Done");
		}
		else
		{
			
			System.out.print("Registration Fail");
			response.sendRedirect("Registration.jsp?Add=Fail");
	
		}
	}
catch (Exception e) {
System.out.print("Exception "+e);
	// TODO: handle exception
}	

		
	
	
	
	}

}
		
	
