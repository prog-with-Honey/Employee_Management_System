

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class employee_details
 */
@WebServlet("/employee_details")
public class employee_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employee_details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		String gender=request.getParameter("gender");
		String contact=request.getParameter("contact");
		String salary=request.getParameter("salary");
		
		String deleteURL="delete_employee?eid="+eid;
	    String updateURL= "update_employee?eid="+eid+"&ename="+ename+"&gender="+gender+"&contact="+contact+"&salary"+salary;
		
		out.println("<h1>Employee Details</h1>");
		out.println("<h4>Employee ID : "+eid+"</h4>");
		out.println("<h4>Employee name : "+ename+"</h4>");
		out.println("<h4>Employee Gender : "+gender+"</h4>");
		out.println("<h4>Employee Contact : "+contact+"</h4>");
		out.println("<h4>Employee Salary : "+salary+"</h4>");
	    out.println("<a href='"+deleteURL+"'>"+"Delete"+"</a>" +"    "+  "<a href='"+updateURL+"'>"+"Update"+"</a><br><br>" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
