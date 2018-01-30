import java.io.*;
import java.util.*;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.xml.XMLSerializer;

public class FileManager {

    String fileName = "../webapps/task1/lab1.xml";//"coderbook.xml";//
    JSONObject root;
    JSONArray list;

    public FileManager(){

    }

    private void initFM() {
        list = new JSONArray();
        root = new JSONObject().element("list", list);
    }
    /*
        might return void
    */
    public synchronized JSONObject readFile() {
        JSONObject fileValue = new JSONObject();
        String content = "";
        String fileLine;
        System.out.println("before grabbing file");
        try {
            BufferedReader buf = new BufferedReader(new FileReader(fileName));
            fileLine = buf.readLine();
            while (fileLine != null) {
                content +=  fileLine;
                fileLine = buf.readLine();
            }
            System.out.println(content);
            buf.close();
            XMLSerializer xmlSerial = new XMLSerializer();
            fileValue = (JSONObject) xmlSerial.read(content);
        } catch(Exception e) {
            // do nothing
            e.printStackTrace();
        }
        System.out.println("after file");
        if (fileValue.size() == 0) {
            initFM();
            fileValue = root;
        } else {
            root = fileValue;
            list = fileValue.getJSONArray("list");
        }
        return fileValue;
    }

    public synchronized void writeFile() {
        try {
            PrintWriter wrtr = new PrintWriter(new FileOutputStream(fileName));
            XMLSerializer xmlSerial =  new XMLSerializer();
            String xml = xmlSerial.write((JSON) root);
            wrtr.println(xml);
            wrtr.close();
        } catch (Exception e) {
            // do nothing
            e.printStackTrace();
        }

    }

    public JSONArray getList() {
        return this.list;
    }

    public void setList(JSONArray list) {
        this.list = list;
    }

    public void setRoot(JSONObject root) {
        this.root = root;
    }

    public JSONObject getRoot() {
        return this.root;
    }

    public void addUser(JSONObject usr) {
        // needed for convience
        int loc = isUser(usr);
        if (loc != -1) {
            list.remove(loc);
        }
        list.add(usr);
        root = new JSONObject().element("list", list);
    }

    public int isUser(JSONObject usr) {
        int flag = -1;
        String first = usr.getString("first");
        String last = usr.getString("last");
        for (int i = 0; i < list.size(); i++) {
            if (first.equals(list.getJSONObject(i).getString("first")) && last.equals(list.getJSONObject(i).getString("last"))) {
                flag = i;
                break;
            }
        }
        return flag;
    }
}
