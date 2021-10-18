

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.dav.EmpDv;
//import com.emp.entity.EmpDao;
import com.emp.entity.Employee;



public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//		String name=request.getParameter("name");
//		String password=request.getParameter("pass");
//		if(password.equals("admin")) {
//			RequestDispatcher rd=request.getRequestDispatcher("Servlet2");
//			rd.forward(request, response);
//		}else {
//			out.print("Sorry name and user not found");
//			RequestDispatcher rd=request.getRequestDispatcher("/index.html");
//			rd.include(request, response);
//		}
//		out.print("Hello"+name);
//		out.print("Hello");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("pass");
		String email=request.getParameter("email");
		
		Employee e=new Employee();
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		int status=EmpDv.save(e);
		if(status>0)
		{
			out.print("Record added");
			
		}else {
			out.print("Failed ");
			request.getRequestDispatcher("index.html").include(request, response);
		}
	}

}
