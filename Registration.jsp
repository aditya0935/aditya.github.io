

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page import=" com.util.DbConnection" %>






<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REGISTRATION FORM</title>

<script type="text/javascript">
	function Validate() {
		var uname = document.forms["f1"]["uname"].value;
		var fname = document.forms["f1"]["fname"].value;
		var lname = document.forms["f1"]["lname"].value;
		var password = document.forms["f1"]["password"].value;
		var cpassword = document.forms["f1"]["cpassword"].value;

		var phno = document.forms["f1"]["phno"].value;

		var location = document.forms["f1"]["location"].value;
		//uname

		if (uname == null || uname == "") {
			alert("Fill the Username Name");
			return false;
		}
		if (!isNaN(uname)) {
			alert("User Name Must be String");
			return false;
		}
		//fname

		if (fname == null || fname == "") {
			alert("Fill the First Name");
			return false;
		}
		if (!isNaN(fname)) {
			alert("First Name Must be String");
			return false;
		}
//lname

		if (lname == null || lname == "") {
			alert("Fill the last Name");
			return false;
		}
		if (!isNaN(lname)) {
			alert("Last Name Must be string");
			return false;
		}

		//password
		
		if (password == null || password == "") {
			alert("Password must be filled ");
			return false;
		}
		
		if(password.length<6)
			{
			alert("Password must be aleast contains of 6 characters" );
			return false;
			}
		

		if (cpassword == null || cpassword == "") {
			alert("Confirm Password must be filled ");
			return false;
		}
		
		if (password != cpassword)
			{
			alert("Password does not match ");
			return false;
			}
		
		
		//email
		var email = document.forms["f1"]["email"].value;
	var atpos = email.indexOf("@");
	var dotpos = email.lastIndexOf(".");
	if (atpos < 1 || (dotpos - atpos < 2)) {
		alert("Please enter correct email ID");
		return false;
	}

	
	//phone
	
	
	if(phno== null || phno <10 || phno == " " )
	{
		alert(" ");
		return false;
		
		
	}
	
	if (isNaN(phno)) {
		alert("Enter the valid Mobile Number");
		return false;
	}

	if ((phno.length < 10)) {
		alert(" Enter 10 Digit mobile Number");
		return false;
	}

	
	
	// location
	
	if(location== null || location ==" " )
	{
		alert(" ");
		return false;
		
		
	}
	
		
		

	}
</script>









</head>
<body>


<% 
if(request.getParameter("Add") != "Done")
{
	out.print("<script>alert('Registered Successfully')</script>");
}
%>



	<form action="Registration" method="post" name="f1" id="f1" onsubmit="return Validate()">

		<div align="center">
			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="uname" value="Aditya"></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<td>Confirm Password</td>
					<td><input type="password" name="cpassword">
				</tr>

				<tr>
					<td>First Name</td>
					<td><input type="text" name="fname">
				</tr>


				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lname">
				</tr>



				<tr>
					<td>Email</td>
					<td><input type="text" name="email">
				</tr>


				<tr>
					<td>Phone No.</td>
					<td><input type="text" name="phno">
				</tr>


				<tr>
					<td>Location</td>
					<td><input type="text" name="location">
				</tr>

				<tr>
					<td><input type="submit" value="Save"></td>
					<td><input type="reset" value="Reset"></td>
				</tr>



			</table>
		</div>

	</form>
<br><br><br>

<table border="2" cellspacing="5" cellpadding="10" align="Center">
		
		<tr align="center">
		<th>Sr.No.</th>
		<th> First Name</th>
		<th>Last Name</th>
		<th>Email </th>
		<th>Phone No.</th>
	<th>Location</th>
	<th>UPDATE</th>
	
		</tr>


<% 


Connection con = DbConnection.getConnection();
	PreparedStatement ps = con.prepareStatement("SELECT * FROM  `registration` ");
	ResultSet rs = ps.executeQuery();
	int sr_no = 0;
	String	fname=" ",lname=" ",email=" ",phno=" ",location=" ";
	while(rs.next())
	{
		sr_no++;
	fname= rs.getString("fname");
 lname=rs.getString("lname");
 email=rs.getString("email");
 phno=rs.getString("phno");
 location=rs.getString("location");
		
	


%>


<tr>
<td><%=sr_no %></td>

<td><input type="text" value="<%=fname %>" name="fname1" "></td>
<td><input type="text" value="<%=lname %>" name="lname1" "></td>
<td><input type="text" value="<%=email %>" name="email1" "></td>
<td><input type="text" value="<%=phno %>" name="phno1" "></td>
<td><input type="text" value="<%=location %>" name="location" "></td>
<%session.setAttribute("lname",lname );
session.setAttribute("email",email );
session.setAttribute("phno",phno );
session.setAttribute("location",location );


%>


<td><a href="Edit?<%=fname%>">Edit</a>|<a href="Delete?<%=fname%>">Delete</a></td>


</tr>


<% }%>


</table>








</body>
</html>