

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.dav.EmpDv;
import com.emp.entity.Employee;

/**
 * Servlet implementation class Servlet3
 */

public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		Employee e=EmpDv.getEmployeeById(id);
		out.print("<form action='EditServlet' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'></td></tr>");
		out.print("<tr><td>Password:</td><td><input type='password' name='pass' value='"+e.getPassword()+"'></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'></td></tr>");
		out.print("<tr><td><input type='submit' value='Submit'></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
	}
		
		//String n=request.getParameter("name");		
	//	out.print("<a href='Servlet4?uname="+n+"'>visit</a>");
		
		
		
		
	//	out.print("Welcome"+n);
		
		//Cookie ck=new Cookie("uname",n);
	//	response.addCookie(ck);
		
	//	out.print("<form action='Servlet4'>");
		//out.print("<input type='hidden' name='uname' value='"+n+"'>");
		//out.print("<input type='submit' value='go'>");
		//out.print("</form>");
		
		//out.close();
		
		
	//	HttpSession session=request.getSession();
	//	session.setAttribute("uname", n);
		//out.print("<a href='Servlet4'>Visit</a>");
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
