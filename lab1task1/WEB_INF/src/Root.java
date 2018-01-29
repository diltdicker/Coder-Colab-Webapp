import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.xml.XMLSerializer;

/*
	@Author: Dillon Dickerson
	@Version: 1.0
	Copyright Dillon Dickerson 2018
*/

public class Root extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fName;
		String lName;
		Cookie[] cookies = req.getCookies();

		if (cookies.length == 0) {
			// do nothing
		} else {
			int i = 0;
			boolean flag = false;
			for (; i < cookies.length; i++) {
				if (cookies[i].getName().equals("lab1cookie_PreviousVisit")){
					flag = true;
					break;
				}
			}
			if (flag) {
				// parse cookie values
			}
		}
		String test = "{\"test\":\"Help ME!\"}";
		JSONObject jsonObj = (JSONObject) JSONSerializer.toJSON(test);
		DynaBean bean = (DynaBean) JSONSerializer.toJava(jsonObj);
		String value = (String) bean.get("test");
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
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<form action=\"/task1/newperson\" method=\"post\"");
		out.println("<p>Welcom to Task 1: now hand over your personal information</p>");
		out.println("First Name: <input type=\"text\" name=\"firstN\"><br>");
		out.println("Last Name: <input type=\"text\" name=\"lastN\"><br>");
		out.println("<input type=\"submit\" value=\"Submit\">");
		out.println("</form>");
		out.println("<h1>"+ value +"</h1>");
		out.println("</body>");
		out.println("<footer>Copyright Dillon Dickerson 2018</footer>");
		out.println("</html>");
	}
}
