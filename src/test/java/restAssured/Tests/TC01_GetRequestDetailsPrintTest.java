package restAssured.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import restAssured.Base.APIBase;

public class TC01_GetRequestDetailsPrintTest extends APIBase{
	
	@Test(priority =1)
	public void getResponseBody() {

		//Response object
		response = httpRequest.request(Method.GET, "/api/users?page=2");
		//Get the response body
		String responseBody = response.getBody().asString();
		System.out.println("Response body : " + responseBody);  
		test.log(LogStatus.INFO, responseBody);
	}

	@Test(priority =2)
	public void verifyStatusCode() {
		//get the status code
		int statusCode = response.getStatusCode();
		System.out.println("Status code : "+statusCode);
		test.log(LogStatus.INFO, "Status code : "+statusCode);
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority =3)
	public void verifyStatusLine() {
		//get the status line
		String statusLine = response.getStatusLine();
		System.out.println("Status line : "+statusLine);
		test.log(LogStatus.INFO, "Status line : "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

	@Test(priority =4)
	public void getHeaders() {
		//get headers
		Headers headers = response.getHeaders();
		System.out.println("Headers are : ");
		test.log(LogStatus.INFO,"Headers are : ");
		for(Header header : headers) {
			test.log(LogStatus.INFO,header.getName()+" : "+header.getValue());
			System.out.println(header.getName()+" : "+header.getValue());
		}
	} 
}
