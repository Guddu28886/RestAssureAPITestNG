package restAssured.Tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.hamcrest.Matchers;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import restAssured.Base.APIBase;

public class TC07_PostRequestWithBodyJsonFileMethodChaining extends APIBase{

	@Test(priority = 1)
	public void postRequest() throws FileNotFoundException, IOException, ParseException {

		//Preparing request body
		File jsonBody = new File(System.getProperty("user.dir")+"/TestData/PostCreateRequest.json");
		
		//Given
		RestAssured
	    .given()
			.baseUri("https://reqres.in/api/users")
			.contentType(ContentType.JSON)
			.body(jsonBody)
	// WHEN
		.when()
			.post()
			// THEN
		.then()
			.assertThat()
			.statusCode(201);
	}

} 

