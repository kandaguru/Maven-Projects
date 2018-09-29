package com.RestAssured.app;

import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import jiraAPI.CommentPayload;
import resources.BaseClassJira;


public class RestAssuredCommentsTC2 extends BaseClassJira {

	
	// Add Comment to JIRA defect
	@Test
	public static void addComments() throws IOException {

		RestAssured.baseURI = prop.getProperty("HOST");

	
		Response res = given().given().header("cookie", cookieAuth).header("Content-Type", "application/json")
				.body(CommentPayload.getAddCommentPayload()).log().all().when()
				.post(prop.getProperty("commentresourcesPart1") + issueId + prop.getProperty("commentresourcesPart2"))
				.then().assertThat().statusCode(201).log().all().extract().response();

		commentId = BaseClassJira.giveCommentId(res);
		System.out.println(commentId);
		
	}
	
	
	// update the existing comment 

	@Test
	public static void updateComments() throws IOException {

		
		RestAssured.baseURI = prop.getProperty("HOST");
		
		

		given().given().header("cookie", cookieAuth).header("Content-Type", "application/json")
				.body(CommentPayload.getUpdaeCommentPayload()).when().put("/rest/api/2/issue/" + issueId + "/comment/" + commentId).then()
				.log().all();

	}

}
