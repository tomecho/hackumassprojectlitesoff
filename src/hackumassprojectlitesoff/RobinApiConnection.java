package hackumassprojectlitesoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONException;
//Author Thomas Peck
public class RobinApiConnection {
	Paraser p;
	public RobinApiConnection(String url,String auth) throws IOException, JSONException{
        URL u = new URL(url);
        URLConnection uc = u.openConnection();
        uc.setRequestProperty("Authorization", "Access-Token " + auth);
        uc.connect();
        ArrayList<String> allofit = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream(), "UTF-8"))) {
        	String line = "";
        	while((line = reader.readLine()) != null) {
                allofit.add(line);
            }
        }
        if(allofit.size() > 1) System.out.println("this has never happened before how embaresing");
        p = new Paraser(allofit.get(0));
        if(!p.getStatus().equals("OK")){
        	System.err.print("api error");
        	System.exit(1);
        }
	}
	public String[] getUsers() throws JSONException{
        return p.getUsers();
	}
	public boolean getStatus() throws JSONException{
		return (p.getStatus().equals("OK"));
	}
}	

