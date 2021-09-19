package restAssured.Tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import restAssured.Base.APIBase;

public class TC06_PostRequestWithBodyJsonFile extends APIBase{

	@Test(priority = 1)
	public void postRequest() throws FileNotFoundException, IOException, ParseException {

		//Preparing request body
		File jsonBody = new File(System.getProperty("user.dir")+"/TestData/PostCreateRequest.json");
		//Request header attached
		httpRequest.header("Content-Type","application/json");
		//request body attached
		httpRequest.body(jsonBody);
		//Send request & get response
		response = httpRequest.request(Method.POST,"/api/users");
	}

	@Test(priority =2)
	public void verifyStatusCode() {
		//get the status code
		int statusCode = response.getStatusCode();
		System.out.println("Status code : "+statusCode);
		Assert.assertEquals(statusCode, 201);
	}

	@Test(priority =3)
	public void verifyStatusLine() {
		//get the status line
		String statusLine = response.getStatusLine();
		System.out.println("Status line : "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
	}

	@Test(priority =4)
	public void getHeaders() {
		//get headers
		Headers headers = response.getHeaders();
		System.out.println("Headers are : ");
		for(Header header : headers) {
			System.out.println(header.getName()+" : "+header.getValue());
		}
	} 

	@Test(priority =5)
	public void getValueFromResponseBody() {
		//get value from response body
		String id = response.jsonPath().get("id");
		System.out.println("ID : "+id);
	}
} 

