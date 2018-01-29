import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.xml.XMLSerializer;

public class Test {
    public static void main(String[] args) {
        /*
        String test = "{\"test\":\"Help ME!\"}";
		JSONObject jsonObj = (JSONObject) JSONSerializer.toJSON(test);
		DynaBean bean = (DynaBean) JSONSerializer.toJava(jsonObj);
		String value = (String) bean.get("test");
        */
        /*String str = "{'string':'JSON', 'integer': 1, 'double': 2.0, 'boolean': true}";
        JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON( str );
        DynaBean bean = (DynaBean) JSONSerializer.toJava( jsonObject );
        */System.out.println("test");//bean.get("string") );
    }
}
