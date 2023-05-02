package App;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/valid")
public class ForgotPassword extends HttpServlet{
	@Override
	    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			PreparedStatement pst=con.prepareStatement("select * from userpassword where Mobilenumber=?");
			String number=req.getParameter("num");
			String password=req.getParameter("pass");
			pst.setString(1,number);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				PreparedStatement pst1=con.prepareStatement("update userpassword set password=? where Mobilenumber=?");
				pst1.setString(1, password);
				pst1.setString(2, number);
				pst1.executeUpdate();
				res.getWriter().println("New Password updated successfully......");
				
			}else {
				res.getWriter().println("Miss Matching data please check your phone number...");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
