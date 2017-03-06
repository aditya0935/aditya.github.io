

import java.io.IOException;







import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import com.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	Connection con = null;
	
	ResultSet rs;

	
	
    public Edit() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		
		try
		{
		 String fname=request.getParameter("fname");
		String Status=request.getParameter("status");
		HttpSession session=request.getSession();
	
		String lname=session.getAttribute("lname").toString();	
		String email=session.getAttribute("email").toString();	
		String phno=session.getAttribute("phno").toString();	
		String location=session.getAttribute("location").toString();	
		
	System.out.print(lname);
	
	
	
		PreparedStatement ps = con.prepareStatement("update `registration` set fname='"+fname+"',lname='"+lname+"',email='"+email+"',phno='"+phno+"',location='"+location+"'   where fname ='"+fname+"' ");		
		
		ps.executeUpdate();
		
		}
   catch(Exception e) {
System.out.print("Exception "+e);
// TODO: handle exception
}	

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	
		
	
	
	
	}

}
		
	
