import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import nl.webresolver.wrclient.*;

public class Example {

	public static void main(String[] args)
	{
		WebresolverAPI client = new WebresolverAPI();
		try {
			client.setKey("XXXXX-XXXXX-XXXXX-XXXXX");
			client.setJson(true);
			client.setUseragent("Skypebot/1.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");
			// client.port(443);
			
			System.out.println(client.Request("https://www.webresolver.nl", "geoip").replaceAll("(?i)<br */?>", "\r\n"));
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}
}
