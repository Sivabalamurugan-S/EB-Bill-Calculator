package App;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/account")
public class AccountCreate extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/HTML");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			PreparedStatement pst=con.prepareStatement("insert into userpassword values(?,?,?)");
			String name=req.getParameter("un");
			String phonenumber=req.getParameter("pn");
			String password=req.getParameter("pw");
			pst.setString(1,name);
			pst.setString(2,password);
			pst.setString(3,phonenumber);
			pst.executeUpdate();
			res.getWriter().println("Account create Successfully"+(char)1);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
