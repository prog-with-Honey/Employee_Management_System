

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
 * Servlet implementation class update_employee
 */
@WebServlet("/update_employee")
public class update_employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_employee() {
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
        PrintWriter out = response.getWriter();

        String eid = request.getParameter("eid");
        String ename=request.getParameter("ename");
		String gender=request.getParameter("gender");
		String contact=request.getParameter("contact");
		String salary=request.getParameter("salary");
		
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CEC", "root", "root");
            
            PreparedStatement p = con.prepareStatement("SELECT * FROM employee WHERE eid=?");
            p.setString(1, eid);
            ResultSet r = p.executeQuery();

            if (r.next()) 
            {
            	ename = r.getString("ename");
			    gender = r.getString("gender");
			    contact = r.getString("contact");
			    salary = r.getString("salary");
              
			    out.println("<h1>Update Employee Details</h1>");
                out.println("<form action='update_book' method='POST'>");
                out.println("<input type='hidden' name='eid' value='" + eid + "'/>");
                out.println("Employee Name: <input type='text' name='ename' value='" + ename + "'/><br/><br/>");
                out.println("Employee Gender: <input type='text' name='gender' value='" + gender + "'/><br/><br/>");
                out.println("Employee Contact: <input type='text' name='contact' value='" + contact + "'/><br/><br/>");
                out.println("Employee Salary: <input type='text' name='salary' value='" + salary + "'/><br/><br/>");
                out.println("<input type='submit' value='Update Book'/>");
                out.println("</form>");
            } 
            else 
            {
                out.println("<h1>Employee not found!</h1>");
            }

        } 
        catch (Exception e) 
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
