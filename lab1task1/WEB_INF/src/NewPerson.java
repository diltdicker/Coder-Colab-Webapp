import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/*
	@Author: Dillon Dickerson
	@Version: 1.0
	Copyright Dillon Dickerson 2018
*/

public class NewPerson extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fName = req.getParameter("FirstN");
		String lName = req.getParameter("LastN");
		//
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println(fName);
		out.println(lName);
		out.println("</html>");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("Testting Get Persons");
		out.println("</html>");
	}
}
