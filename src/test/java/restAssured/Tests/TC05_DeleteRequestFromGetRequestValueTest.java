package restAssured.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import restAssured.Base.APIBase;

public class TC05_DeleteRequestFromGetRequestValueTest extends APIBase{
	@Test(priority=1)
	public void deleteRquest() {

		response = httpRequest.request(Method.GET,"/api/users?page");
		int ids= response.jsonPath().get("data[0].id");
		System.out.println("First ID : "+ids);
//		response = httpRequest.request(Method.DELETE,"/api/users/2");
		response = httpRequest.request(Method.DELETE,"/api/users/"+ids);
	}

	@Test(priority=2)
	public void verifyStatusCode() {
		int statusCode = response.getStatusCode();
		System.out.println("Status code : "+statusCode);
		Assert.assertEquals(statusCode, 204);
	}

	@Test(priority=3)
	public void verifyStatusLine() {
		String statusLine = response.getStatusLine();
		System.out.println("Status line : "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 204 No Content");
	}

	@Test(priority=4)
	public void getHeaders() {
		Headers headers = response.getHeaders();
		System.out.println("Headers are : ");
		for(Header header:headers) {
			System.out.println(header.getName() +" : "+header.getValue());
		}
	}

	@Test(priority=5)
	public void verifyResponseBody() {
		String responseBody = response.getBody().asString();
		System.out.println("Response Body : \n"+responseBody);
	}
}
