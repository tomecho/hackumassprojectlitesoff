
package hackumassprojectlitesoff;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import org.json.JSONException;

public class Hackumassprojectlitesoff {
	public static void main(String args[]) throws IOException, JSONException{
		String stringUrl = "https://api.robinpowered.com/v1.0/spaces/763/presence";
        URL url = new URL(stringUrl);
        URLConnection uc = url.openConnection();
        uc.setRequestProperty("Authorization", "Access-Token "
        		+ "lFfjRcer4Pd6zS229nEVuIuG6NhFE3RMnuOU5F1Rjh2OD3xRbBZO215hinjkRxQOJ6f6ULoMCvXUHIl7gLgWU80y377HNwoPXWc0jGVnspVP1zt6pc8tFVTAIDViklPi");
        uc.connect();
        ArrayList<String> allofit = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream(), "UTF-8"))) {
        	String line = "";
        	while((line = reader.readLine()) != null) {
                allofit.add(line);
            }
        }
        if(allofit.size() > 1) System.out.println("this has never happened before how embaresing");
        Paraser p = new Paraser(allofit.get(0));
        if(!p.getStatus().equals("OK")){
        	System.err.print("api error");
        	System.exit(1);
        }
        for(String line: p.getUsers()){
        	System.out.println(line);
        }
	}
}
