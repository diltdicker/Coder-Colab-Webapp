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
		String fName = req.getParameter("firstN");
		String lName = req.getParameter("lastN");
		String[] langs = req.getParameterValues("langs");
		String[] days = req.getParameterValues("days");
		String[] os = req.getParameterValues("os");
		Cookie[] cookies = req.getCookies();
		JSONObject root = new JSONObject();
		String val = "test";
		boolean set = false;
		//
		if (fName != null && lName != null && !fName.equals("") && ! lName.equals("")) {
			// create cookie here
			root = new JSONObject();
			Cookie cookieUsr;
			if (cookies == null || cookies.length == 0) {
				JSONArray langJson = (JSONArray) JSONSerializer.toJSON(langs);
				JSONArray daysJson = (JSONArray) JSONSerializer.toJSON(days);
				JSONArray osJson = (JSONArray) JSONSerializer.toJSON(os);
				JSONObject jsonObj = new JSONObject().element("first", fName).element("last", lName).element("langs", langJson).element("days", daysJson).element("os", osJson);
				val = jsonObj.toString();
				val = val.replaceAll(",","--");
				val = val.replaceAll("\"","!!");
				cookieUsr = new Cookie("lab1cookie_PreviousVisit", val);
				root = jsonObj;
			} else {
				int i = 0;
				boolean flag = false;
				JSONArray langJson = (JSONArray) JSONSerializer.toJSON(langs);
				JSONArray daysJson = (JSONArray) JSONSerializer.toJSON(days);
				JSONArray osJson = (JSONArray) JSONSerializer.toJSON(os);
				JSONObject jsonObj = new JSONObject().element("first", fName).element("last", lName).element("langs", langJson).element("days", daysJson).element("os", osJson);
				val = jsonObj.toString();
				val = val.replaceAll(",","--");
				val = val.replaceAll("\"","!!");
				for (; i < cookies.length; i++) {
					if (cookies[i].getName().equals("lab1cookie_PreviousVisit")){
						flag = true;
						break;
					}
				}
				if (flag) {
					cookieUsr = cookies[i];
					cookieUsr.setValue(val);
				} else {
					cookieUsr = new Cookie("lab1cookie_PreviousVisit", val);
				}
				root = jsonObj;
			}
			resp.addCookie(cookieUsr);
			FileManager fm = new FileManager();
			fm.readFile();
			fm.addUser(root);
			fm.writeFile();
			set = true;
		}
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");

		if (set) {
			out.println("<p>Excellent the cookie has been set and the value has been added to the xml file</p>");
			out.println("<br>first: " + fName);
			out.println("<br>last: " + lName);
			out.println("<br>langs: " + root.getJSONArray("langs").toString());
			out.println("<br>days: " + root.getJSONArray("days").toString());
			out.println("<br>os: " + root.getJSONArray("os").toString());
		} else {
			out.println("there was a problem with the input");
		}
		out.println("<br><a href=\"/task1/\">Link back to home</a>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		resp.setStatus(405);
		out.println("<html>");
		out.println("Um, why are you here?");
		out.println("Get back to where you belong");
		out.println("<a href=\"/task1\">Where you belong</a>");
		out.println("</html>");
	}
}
