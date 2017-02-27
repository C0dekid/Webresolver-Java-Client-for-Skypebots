# Webresolver-Java-Client-for-Skypebots

How to use?

1. Import the class `import nl.webresolver.wrclient.*;`

Function example:

To use the WRClient write this in your code:

`WebresolverAPI client = new WebresolverAPI();`

Then you have to set your API Key by doing `client.setKey"("your key")`. By default the script outputs JSON, if you don't want to
use JSON, use `client.setJson(false)`. To set a custom useragent use:

`client.setUseragent("Skypebot/1.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");`

If you are using the portscan API, you can set a specific portnumber by using `client.port(number)` or leave it if you want to show
all the ports.
