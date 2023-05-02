package App;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DB")
public class Check  extends HttpServlet{
	 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 res.setContentType("text/html");
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			PreparedStatement pst=con.prepareStatement("select * from userpassword where username=? and password=?");
			String name=req.getParameter("user");
			String pass=req.getParameter("pass");
			pst.setString(1, name);
			pst.setString(2, pass);
			ResultSet rs=pst.executeQuery();
			PrintWriter pw=res.getWriter();
			if(rs.next()) {
				RequestDispatcher rd=req.getRequestDispatcher("Calculator.html");
				rd.forward(req, res);
			}
			else {
				pw.println("Invalid username & password...");
				RequestDispatcher rd=req.getRequestDispatcher("Login.html");
				rd.include(req, res);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
