import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/*
	@Author: Dillon Dickerson
	@Version: 1.0
	Copyright Dillon Dickerson 2018
*/

public class GetPersons extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("Testting Get Persons");
		out.println("</html>");
	}
}

