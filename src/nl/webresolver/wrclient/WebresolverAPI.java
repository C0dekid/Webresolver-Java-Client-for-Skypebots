package nl.webresolver.wrclient;

/*
 * Webresolver Resolver Class in Java 
 * This class has been written due some technical issues with the useragents.
 * To avoid more request regarding to this issue, i've written a simple example
 * wich you can use for free.
 * 
 * You're not allowed to resell this script or offer it as download.
 * This script is for personal use for your bot only.
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class WebresolverAPI
{
	private static String API_KEY;
	private static String ConnOutput;
	private static String useragent;
	private static Integer port = 0;
	public static Boolean json = true;
		
	/*
	 * @param String input
	 * This is the username, IP or email address 
	 * 
	 * @param String tool
	 * The tool you want to use e.g. 'resolve'
	*/
	
	public static void main(String[] args) { }
	
	public String Request(String str, String tool) throws IOException
	{
		try {
			URL wrurl = new URL("https://webresolver.nl/api.php?key=" + getKey() + "&action=" + tool + "&string=" + str + ((json) ? "&json" : "") + ((!port.equals(0)) ? "&port=" + port : ""));
			
			URLConnection connection = (URLConnection) wrurl.openConnection();
			
			/*
				As we blocking foreing useragent containing
				'Java' and 'Python' for example, you have to put a custom useragent.
			*/
			
			connection.setRequestProperty("User-Agent", useragent);
			connection.setUseCaches(false);
			connection.connect();

			System.out.println("Content-Type: " + connection.getHeaderField(2));
			System.out.println("Cookie: " + connection.getHeaderField(5));
			System.out.println("HTTP Response: " + connection.getHeaderField(0));
			System.out.println("Cache: " + connection.getHeaderField(9) + "\r\n\r\n");
				
			BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			ConnOutput = buffer.readLine();
			
			buffer.close();
			
			return ConnOutput;
			
		} catch (IOException e) {
			
			throw new IOException("This URL doesn't exists (anymore)");
			
		}
	}
	
	public void port(Integer port)
	{
		WebresolverAPI.port = port;
	}
	
	public void setUseragent(String string)
	{
		WebresolverAPI.useragent = string;
	}
	
	public void setJson(Boolean bool)
	{
		WebresolverAPI.json = bool;
	}
	
	public void setKey(String apikey)
	{
		WebresolverAPI.API_KEY = apikey;
	}
	
	private static String getKey()
	{
		return WebresolverAPI.API_KEY;
	}
	
	public static boolean isJson()
	{
		return WebresolverAPI.json;
	}
}
