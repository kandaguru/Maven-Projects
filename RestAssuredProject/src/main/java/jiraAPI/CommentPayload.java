package jiraAPI;

public class CommentPayload {
	
	
	public static String getAddCommentPayload() {
	
		
		String addCommentPayload = "{\r\n" + "    \"body\": \"First automated Comment.\",\r\n"
				+ "    \"visibility\": {\r\n" + "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n" + "    }\r\n" + "}";
		
		return addCommentPayload;
		
	}
	
	
	
	

	public static String getUpdaeCommentPayload() {
	
	String commentUpdatePayload = "{\r\n" + "    \"body\": \"Comment Updated using Rest API automation.\",\r\n"
			+ "    \"visibility\": {\r\n" + "        \"type\": \"role\",\r\n"
			+ "        \"value\": \"Administrators\"\r\n" + "    }\r\n" + "}";
	
	return commentUpdatePayload;
	
	}
	
	
	
}
