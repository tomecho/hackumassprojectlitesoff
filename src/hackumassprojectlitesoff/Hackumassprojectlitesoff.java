
package hackumassprojectlitesoff;
import java.io.IOException;

import org.json.JSONException;

public class Hackumassprojectlitesoff {
	public static void main(String args[]) throws IOException, JSONException {
		RobinApiConnection rac = new RobinApiConnection("https://api.robinpowered.com/v1.0/spaces/763/presence", 
				"lFfjRcer4Pd6zS229nEVuIuG6NhFE3RMnuOU5F1Rjh2OD3xRbBZO215hinjkRxQOJ6f6ULoMCvXUHIl7gLgWU80y377HNwoPXWc0jGVnspVP1zt6pc8tFVTAIDViklPi");
		String[] users = rac.getUsers();
		for(String user: users){
			System.out.println(user);
		}
	}
}
