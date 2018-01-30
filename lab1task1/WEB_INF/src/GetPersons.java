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

public class GetPersons extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		resp.setStatus(405);
		out.println("<html>");
		out.println("Um, why are you here?");
		out.println("Get back to where you belong");
		out.println("<a href=\"/task1\">Where you belong</a>");
		out.println("</html>");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//

		FileManager fm = new FileManager();
		fm.readFile();
		JSONArray list = fm.getList();

		JSONObject qry = new JSONObject();
		String first = "";
		String last = "";
		JSONArray langs = new JSONArray();
		JSONArray days = new JSONArray();
		JSONArray os = new JSONArray();

		if (req.getQueryString() != null) {
			String query = req.getQueryString();
			String[] q1 = query.split("&");
			for (int i = 0; i < q1.length; i++) {
				String[] q2 = q1[i].split("=");
				if (q2[0].equals("langs") & q2.length > 1) {
					JSONArray jtmp = new JSONArray();
					String[] stmp = q2[1].split("+");
					for (int j = 0; j < stmp.length; j++) {
						jtmp.add(stmp[j]);
					}
					qry.element("langs", jtmp);
				} else if (q2[0].equals("days") && q2.length > 1) {
					JSONArray jtmp = new JSONArray();
					String[] stmp = q2[1].split("+");
					for (int j = 0; j < stmp.length; j++) {
						jtmp.add(stmp[j]);
					}
					qry.element("days", jtmp);
				} else if (q2[0].equals("os") && q2.length > 1) {
					JSONArray jtmp = new JSONArray();
					String[] stmp = q2[1].split("+");
					for (int j = 0; j < stmp.length; j++) {
						jtmp.add(stmp[j]);
					}
					qry.element("os", jtmp);
				} else if (q2[0].equals("first") && q2.length > 1) {
					qry.element("first", q2[1]);
				} else if (q2[0].equals("last") && q2.length > 1) {
					qry.element("last", q2[1]);
				}
			}

			//first
			if (qry.containsKey("first")) {
				for (int i = 0; i < list.size(); i++) {
					if ((list.getJSONObject(i).getString("first")).contains(qry.getString("first"))) {

					} else {
						list.remove(i);
						i--;
					}
				}
			}

			//last

			if (qry.containsKey("last")) {
				for (int i = 0; i < list.size(); i++) {
					if (list.getJSONObject(i).getString("last").contains(qry.getString("last"))) {

					} else {
						list.remove(i);
						i--;
					}
				}
			}

			//Langs

			if (qry.containsKey("langs")) {
				for (int i = 0; i < list.size(); i++) {
					boolean has =false;
					for (int j = 0; j < qry.getJSONArray("langs").size(); j++ ) {
						for (int k = 0; k < list.getJSONObject(i).getJSONArray("langs").size(); k++) {
							if (list.getJSONObject(i).getJSONArray("langs").getString(k).contains(qry.getJSONArray("langs").getString(j))) {
								has = true;
							} else {

							}
						}
					}
					if (!has) {
						list.remove(i);
						i--;
					}
				}
			}

			//days

			if (qry.containsKey("langs")) {
				for (int i = 0; i < list.size(); i++) {
					boolean has =false;
					for (int j = 0; j < qry.getJSONArray("langs").size(); j++ ) {
						for (int k = 0; k < list.getJSONObject(i).getJSONArray("langs").size(); k++) {
							if (list.getJSONObject(i).getJSONArray("langs").getString(k).contains(qry.getJSONArray("langs").getString(j))) {

							} else {

							}
						}
					}
					if (!has) {
						list.remove(i);
						i--;
					}
				}
			}

			//os

			if (qry.containsKey("langs")) {
				for (int i = 0; i < list.size(); i++) {
					boolean has =false;
					for (int j = 0; j < qry.getJSONArray("langs").size(); j++ ) {
						for (int k = 0; k < list.getJSONObject(i).getJSONArray("langs").size(); k++) {
							if (list.getJSONObject(i).getJSONArray("langs").getString(k).contains(qry.getJSONArray("langs").getString(j))) {

							} else {

							}
						}
					}
					if (!has) {
						list.remove(i);
						i--;
					}
				}

			}

		}

		PrintWriter out = resp.getWriter();
		//out.println("<html>");
		//out.println("");
		out.println(list.toString(4));
		//out.println("</html>");
	}
}
