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

		String fName = "";
		String lName = "";
		JSONArray langs = new JSONArray();
		JSONArray days = new JSONArray();
		JSONArray os = new JSONArray();
		String jsonStr;
		Cookie[] cookies = req.getCookies();
		boolean flag = false;

		if (cookies == null || cookies.length == 0) {
			// do nothing
		} else {
			int i = 0;

			for (; i < cookies.length; i++) {
				if (cookies[i].getName().equals("lab1cookie_PreviousVisit")){
					flag = true;
					break;
				}
			}
			if (flag) {
				// parse cookie values
				jsonStr = cookies[i].getValue().replaceAll("--",",");
				jsonStr = jsonStr.replaceAll("!!","\"");
				JSONObject jsonObj = (JSONObject) JSONSerializer.toJSON( jsonStr );
				fName = jsonObj.getString("first");
				lName = jsonObj.getString("last");
				langs = jsonObj.getJSONArray("langs");
				days = jsonObj.getJSONArray("days");
				os = jsonObj.getJSONArray("os");

			}
		}
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
		out.println(req.getQueryString());
		if (flag) {
			out.println("<h3>Welcome back</h3>");
		}
		out.println("<body>");
		out.println("<form action=\"/task1/newperson\" method=\"post\"");
		out.println("<p>Welcom to Task 1: now hand over your personal information</p>");
		out.println("First Name: <input type=\"text\" name=\"firstN\" value=\"" + fName + "\"><br>");
		out.println("Last Name: <input type=\"text\" name=\"lastN\" value=\"" + lName + "\"><br>");
		out.println("Langs: <select name=\"langs\" multiple>");
		out.print("<option ");
		if (langs.indexOf("Java") != -1) {
			out.print("selected");
		}
		out.print(" value=\"Java\">");
		out.println("java</option>");
		out.print("<option ");
		if (langs.indexOf("C++") != -1) {
			out.print("selected");
		}
		out.print(" value\"C++\">");
		out.println("C++</option>");
		out.print("<option ");
		if (langs.indexOf("JavaScript") != -1) {
			out.print("selected");
		}
		out.print(" value\"JavaScript\">");
		out.println("JavaScript</option>");
		out.print("<option ");
		if (langs.indexOf("Python") != -1) {
			out.print("selected");
		}
		out.print(" value\"Python\">");
		out.println("Python</option>");
		out.println("</select><br>");
		out.println("Days: <select name=\"days\" multiple>");
		out.print("<option ");
		if (days.indexOf("Monday") != -1) {
			out.print("selected");
		}
		out.print(" value\"Monday\">");
		out.println("Monday</option>");
		out.print("<option ");
		if (days.indexOf("Tuesday") != -1) {
			out.print("selected");
		}
		out.print(" value\"Tuesday\">");
		out.println("Tuesday</option>");
		out.print("<option ");
		if (days.indexOf("Wednesday") != -1) {
			out.print("selected");
		}
		out.print(" value\"Wednesday\">");
		out.println("Wednesday</option>");
		out.print("<option ");
		if (days.indexOf("Thursday") != -1) {
			out.print("selected");
		}
		out.print(" value\"Thursday\">");
		out.println("Thursday</option>");
		out.print("<option ");
		if (days.indexOf("Friday") != -1) {
			out.print("selected");
		}
		out.print(" value\"Friday\">");
		out.println("Friday</option>");
		out.print("<option ");
		if (days.indexOf("Saturday") != -1) {
			out.print("selected");
		}
		out.print(" value\"Saturday\">");
		out.println("Saturday</option>");
		out.print("<option ");
		if (days.indexOf("Sunday") != -1) {
			out.print("selected");
		}
		out.print(" value\"Sunday\">");
		out.println("Sunday</option>");
		out.println("</select><br>");
		out.println("Operating sys: <select name=\"os\" multiple>");
		out.print("<option ");
		if (os.indexOf("Windows") != -1) {
			out.print("selected");
		}
		out.print(" value\"Windows\">");
		out.println("Windows</option>");
		out.print("<option ");
		if (os.indexOf("MacOSX") != -1) {
			out.print("selected");
		}
		out.print(" value\"MacOSX\">");
		out.println("MacOSX</option>");
		out.print("<option ");
		if (os.indexOf("Linux") != -1) {
			out.print("selected");
		}
		out.print(" value\"Linux\">");
		out.println("Linux</option>");
		out.println("</select><br>");
		out.println("<input type=\"submit\" value=\"Submit\">");
		out.println("</form>");
		if (cookies == null){
			out.println("test");
		}
		out.println("testing");
		//out.println("<h1><br>"+  +"<br></h1>");
		out.println("</body>");
		out.println("<footer>Copyright Dillon Dickerson 2018</footer>");
		out.println("</html>");
	}
}
