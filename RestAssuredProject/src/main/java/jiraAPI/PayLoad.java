package jiraAPI;

public class PayLoad {
	
	public static String getPayLoad() {
		
		
		String payload = "\r\n" + 
				"{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \"project\":\r\n" + 
				"       {\r\n" + 
				"          \"key\": \"RES\"\r\n "+ 
				"       },\r\n" + 
				"       \"summary\": \"REST API defect #1\",\r\n" + 
				"       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
				"       \"issuetype\": {\r\n" + 
				"          \"name\": \"Bug\"\r\n" + 
				"       }\r\n" + 
				"   }\r\n" + 
				"}";    
		
		
		
		return payload;
		
		
		
		
		}
	
	

}
