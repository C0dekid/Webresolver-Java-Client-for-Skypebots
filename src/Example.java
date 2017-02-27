import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import nl.webresolver.wrclient.*;

public class Example {

	public static void main(String[] args)
	{
		WebresolverAPI client = new WebresolverAPI();
		try {
			client.SetKey("53CDX-ULBMX-9GYA9-K615P");
			client.setJson(true);
			client.setUseragent("Skypebot/1.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");
			
			if(client.isJson() == true)
			{
				JSONObject j = new JSONObject(client.Request("echo123", "resolve"));
				
				if(!j.getBoolean("success"))
				{
					System.out.print(j.getString("error"));
					
				}else{
					System.out.println(j.getString("ip"));
				}
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
	}
}