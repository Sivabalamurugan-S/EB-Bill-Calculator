package App;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/open")
public class OutputClass extends HttpServlet {
                     @Override
                   public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                    	// TODO Auto-generated method stub
                    		res.setContentType("text/html");
                    		  int unit=Integer.parseInt(req.getParameter("value"));
                    		  double amount=0.0d;
                    		  if(unit<=100) {
                    			  amount=0.0d;
                    			  res.getWriter().println("<table border=2px cellpadding=10px cellspacing=0>"+"<tr>"+"<th>"+"EB_Unit"+"</th>"+"<th>"+"Amount"+"</th>"+"<tr>"+
                    			  "<td>"+unit+"</td>"+"<td>"+"Rs."+amount+"</td>"+"</tr>"+"</table>");
                    			  
                    		  }else if(unit>100&&unit<=400) {
                    			  int st=1;
                    			  double per_unit=4.0d;
                    			  
                    			  for(int j=101;j<=unit;j++) {
                    				  amount=(st++)*per_unit;
                    			  }
                    			  res.getWriter().println("<table border=2px cellpadding=10px cellspacing=0>"+"<tr>"+"<th>"+"EB_Unit"+"</th>"+"<th>"+"Amount"+"</th>"+"<tr>"+
                    					  "<td>"+unit+"</td>"+"<td>"+"Rs."+amount+"</td>"+"</tr>"+"</table>");
                    		  }else if(unit>400) {
                    			  int st=1;
                    			  double per_unit=5.0d;
                    			  
                    			  for(int j=101;j<=unit;j++) {
                    				  amount=(st++)*per_unit;
                    			  }
                    			  res.getWriter().println("<table border=2px cellspacing=0 cellpadding=10px>"+"<tr>"+"<th>"+"EB_Unit"+"</th>"+"<th>"+"Amount"+"</th>"+"<tr>"+
                    					  "<td>"+unit+"</td>"+"<td>"+"Rs."+amount+"</td>"+"</tr>"+"</table>");
                    		  }
                    		  
                    		
                    	
                    }
}
