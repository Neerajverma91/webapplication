

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.dav.EmpDv;
import com.emp.entity.Employee;



public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	//	String n=request.getParameter("name");
		//out.print("Welcome"+n);
		List<Employee> l=EmpDv.getAllEmployees();
		out.print("<table border='1'>");
		out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th colspan='2'>Action</th>");
		for(Employee e:l)
		{
		
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()
			+"</td><td><a href='Servlet3?id="+e.getId()+"'>Update</a></td><td><a href='Servlet4?id="+e.getId()+"'>Delete</a></td></tr>");
	}
		out.print("</table>");
		
		
			
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
