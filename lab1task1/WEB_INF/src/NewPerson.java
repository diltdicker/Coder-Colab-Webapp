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

public class NewPerson extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fName = req.getParameter("FirstN");
		String lName = req.getParameter("LastN");
		Cookie[] cookies = req.getCookies();
		//
		if (fName != null && lName != null && !fName.equals("") && ! lName.equals("")) {
			// create cookie here
			Cookie cookieUsr;
			if (cookies.length == 0) {
				cookieUsr = new Cookie("lab1cookie_PreviousVisit", "{\"first\":\"" + fName + "\", \"last\":\"" + lName + "\"}");
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
					cookieUsr = cookies[i];
					cookieUsr.setValue("{\"first\":\"" + fName + "\", \"last\":\"" + lName + "\"}");
				} else {
					cookieUsr = new Cookie("lab1cookie_PreviousVisit", "{\"first\":\"" + fName + "\", \"last\":\"" + lName + "\"}");
				}
			}
			resp.addCookie(cookieUsr);
		}
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println(fName);
		out.println(lName);
		out.println("</html>");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<html>");
		out.println("Um, why are you here?");
		out.println("Get back to where you belong");
		out.println("<a href=\"/task1\">Where you belong</a>");
		out.println("</html>");
	}
}
