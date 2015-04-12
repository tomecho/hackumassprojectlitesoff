package hackumassprojectlitesoff;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Paraser {
	String data;
	public Paraser(String json){
		data = json;
	}
	public String getStatus() throws JSONException{
		JSONObject obj = new JSONObject(data);
        JSONObject obj2 = obj.getJSONObject("meta");
        Object level = obj2.get("status");
        return level.toString();
	}
	public String[] getUsers() throws JSONException{
		JSONObject obj = new JSONObject(data);
        JSONArray obj2 = obj.getJSONArray("data");
        int len = obj2.length();
        ArrayList<String> out = new ArrayList<String>();
        for(int i=0;i<len;i++){
        	out.add( (String) obj2.getJSONObject(i).getJSONObject("user").get("name"));
        }
        return out.toArray(new String[out.size()]);
	}
}
