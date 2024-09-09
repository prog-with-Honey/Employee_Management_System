

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class display_employee_detail
 */
@WebServlet("/display_employee_detail")
public class display_employee_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public display_employee_detail() {
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
		
		String ename=request.getParameter("ename");
		String gender=request.getParameter("gender");
		String contact=request.getParameter("contact");
		String salary=request.getParameter("salary");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CEC", "root", "root");
			
			PreparedStatement p=con.prepareStatement("SELECT * FROM employeedetails");
			
			ResultSet r=p.executeQuery();
			
			out.println("<h1>Employee Details</h1>");
			out.println("<table border='2' style='border-collapse: collapse;'>");
			out.println("<tr>");
			out.println("<th style='padding: 10px;'> ID </th>");
			out.println("<th style='padding: 10px;'> Name </th>");
			out.println("<th style='padding: 10px;'> Gender </th>");
			out.println("<th style='padding: 10px;'> Contact </th>");
			out.println("<th style='padding: 10px;'> Salary </th>");
			out.println("</tr>");

			while (r.next()) 
			{
			     int eid = r.getInt("eid");
			     ename = r.getString("ename");
			     gender = r.getString("gender");
			     contact = r.getString("contact");
			     salary = r.getString("salary");
			     String deleteURL="delete_book?eid="+eid;
			     String updateURL= "update_book?eid="+eid+"&ename="+ename+"&gender="+gender+"&contact"+contact+"&salary"+salary;
			     
			    out.println("<tr>");
			    out.println("<td style='padding: 10px;'>" + eid + "</td>");
			    out.println("<td style='padding: 10px;'>" + ename + "</td>");
			    out.println("<td style='padding: 10px;'>" + gender + "</td>");
			    out.println("<td style='padding: 10px;'>" + contact + "</td>");
			    out.println("<td style='padding: 10px;'>" + salary + "</td>");
			    out.println("<td style='padding: 10px;'>" + "<a href='"+deleteURL+"'>"+"Delete"+"</a><br><br>" +  "<a href='"+updateURL+"'>"+"Update"+"</a><br><br>" + "</td>");
			    out.println("</tr>");
			}
			out.println("</table>");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
