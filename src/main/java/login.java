

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

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
		
		res.setContentType("text/html");
		res.getWriter();
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CEC", "root", "root");
			
			PreparedStatement p=con.prepareStatement("SELECT * FROM register WHERE username=? AND password=?");
			p.setString(1, username);
			p.setString(2, password);
			
			ResultSet r=p.executeQuery();
			
			if(r.next())
			{
				System.out.println("<h1>Loged In Successfully</h1>");
				System.out.println("<a href=\"addEmployee.jsp\">Add Employee</a>");
				
			}
			else
			{
				System.out.println("<h1>Please Check your Username and Password Again...</h1>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
