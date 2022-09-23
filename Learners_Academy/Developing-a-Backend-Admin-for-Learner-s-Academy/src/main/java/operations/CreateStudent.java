package operations;
import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.util.Util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class CreateStudent extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.getRequestDispatcher("add-student.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("Name");
		String RollNo = request.getParameter("rollno");
		String Class = request.getParameter("class");
		
		try {
			
			SessionFactory factory = Util.buildConnection();
			
			Session session = factory.openSession();
			
			AllDetails.StudentDetails studentdetails = new AllDetails.StudentDetails(name, RollNo, Class);
			
			Transaction tx = session.beginTransaction();
			
			session.save(studentdetails);
			
			tx.commit();
			
			if(session != null) {
				out.println("<div align='center'><h2 style='color:green'>STUDENT ADDED SUCCESSFULLY!</h2>"
						+ "<a href='admin-page.html'>RETURN To MainMenu</a>"
						+ "</div>");
			}
			session.close();
		} catch (Exception e) {
			out.println("<div align='center'><h2 style='color:red'>TRY AGAIN! OPERATION FAILED...</h2>"
					+ "<a href='admin-page.html'>RETURN To MainMenu</a>"
					+ "</div>");
		}
		
		saveData(request, response);
	}

	public static void saveData (HttpServletRequest request, HttpServletResponse response) {
		
		String name = (String) request.getParameter("Name");
		String RollNo = (String)request.getParameter("rollno");
		String Class = (String) request.getParameter("class");
		
		try {
				SessionFactory factory = Util.buildConnection();
			
				Session session = factory.openSession();
				
				Transaction tx = session.beginTransaction();
				
				AllDetails.StudentDetails studentdetails = new AllDetails.StudentDetails();
				studentdetails.setName(name);
				studentdetails.setRollNo(RollNo);
				studentdetails.setClass(Class);
				
				session.save(studentdetails);
				tx.commit();
				if(session != null) {
					System.out.println("<div align='center'><h2 style='color:green'>STUDENT ADDED SUCCESSFULLY!</h2>"
							+ "<a href='admin-page.html'>RETURN To MainMenu</a>"
							+ "</div>");
				}
				session.close();
			} catch (Exception e) {
				System.out.println("<div align='center'><h2 style='color:red'>TRY AGAIN! OPERATION FAILED...</h2>"
						+ "<a href='admin-page.html'>RETURN To MainMenu</a>"
						+ "</div>");
			}
	
	}
}