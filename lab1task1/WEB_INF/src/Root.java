import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/*
	@Author: Dillon Dickerson
	@Version: 1.0
	Copyright Dillon Dickerson 2018
*/

public class Root extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		/*
		<!DOCTYPE>
		<html>
			<body>
				<div>
					<form action="/task1/newperson" method="post">
						<p>Enter Info Here</p>
						First Name: <input type="text" name="firstN"><br>
						Last Name: <input type="text" name="LastN"><br>
						<input type="submit" value="Submit">
					</form>
				<div>
			</body>
			<footer>
				<p>Copyright Dillon Dickerson 2018</p>
			</footer>
		</html>
		*/
		//
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<form action=\"/task1/newperson\" method=\"post\"");
		out.println("<p>Welcom to Task 1: now hand over your personal information</p>");
		out.println("First Name: <input type=\"text\" name=\"firstN\"><br>");
		out.println("Last Name: <input type=\"text\" name=\"LastN\"><br>");
		out.println("<input type=\"submit\" value=\"Submit\">");
		out.println("</form>");
		out.println("<h1>testing</h1>");
		out.println("</body>");
		out.println("<footer>Copyright Dillon Dickerson 2018</footer>");
		out.println("</html>");
	}
}
