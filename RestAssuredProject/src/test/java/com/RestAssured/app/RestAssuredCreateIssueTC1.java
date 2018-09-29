package com.RestAssured.app;

import java.io.IOException;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import jiraAPI.PayLoad;
import resources.BaseClassJira;

public class RestAssuredCreateIssueTC1 extends BaseClassJira {

	// Bug Creation Verification
	
	@Test 
	public static void createIssue() throws IOException {

		RestAssured.baseURI = prop.getProperty("HOST");
		cookieAuth = BaseClassJira.jiraGetSessionKey();
		System.out.println(cookieAuth);

		Response res = given().header("cookie", cookieAuth).header("Content-Type", "application/json").log().all()
				.body(PayLoad.getPayLoad()).when().post(prop.getProperty("CreateIssueResources")).then().assertThat()
				.log().all().extract().response();

		issueId = BaseClassJira.giveDefectId(res);

	}
}
