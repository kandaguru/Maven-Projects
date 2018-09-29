package resources;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JiraBaseClass {
	
	
	public static Properties prop = new Properties();

	public static String jiraGetSessionKey() throws IOException {

		// get session key

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\kbas663\\Maven Projects-Sel\\RestAssuredProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		String payload = "{ \"username\": \"venkat1793\", \"password\": \"Kbas663_01\" }";

		RestAssured.baseURI = prop.getProperty("HOST");

		Response res = given().header("Content-Type", "application/json").body(payload).when()
				.post(prop.getProperty("SessionResources")).then().assertThat().statusCode(200).extract().response();

		String str = res.asString();
		JsonPath js = new JsonPath(str);
		String sessionName = js.getString("session.name");
		String sessionKey = js.get("session.value");

		String cookieAuth = sessionName + "=" + sessionKey;
		return cookieAuth;
	}

	public static String giveDefectId(Response res) {

		String str = res.asString();
		JsonPath js = new JsonPath(str);

		String issueId = js.get("id");
		return issueId;

	}

	
	public static String giveCommentId(Response res) {

		String str = res.asString();
		JsonPath js = new JsonPath(str);

		String commentId = js.get("id");
		return commentId;

	}

	
	

}
