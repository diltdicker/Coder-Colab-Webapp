import java.io.*;
import java.util.*;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.xml.XMLSerializer;

public class FileManager {

    String fileName = "coderbook.xml";//"../webapps/task1/coderbook.xml";
    JSONObject root;
    JSONArray list;

    public FileManager(){

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

    public void setRoot(JSONObject root) {
        this.root = root;
    }
}
