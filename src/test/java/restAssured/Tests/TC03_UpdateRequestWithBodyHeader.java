package restAssured.Tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import restAssured.Base.APIBase;

public class TC03_UpdateRequestWithBodyHeader extends APIBase{
	@SuppressWarnings("unchecked")
	@Test(priority=1)
	public void updateRequest() {

		JSONObject requestBody = new JSONObject();
		requestBody.put("name", "guddu");
		requestBody.put("job", "tester");
		httpRequest.body(requestBody.toJSONString());
		httpRequest.header("Content-Type","application/json");
		response =httpRequest.request(Method.PUT,"/api/users/2");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority=2)
	public void verifyStatusCode() {
		int statusCode = response.getStatusCode();
		System.out.println("Status code : "+statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test(priority=3)
	public void verifyStatusLine() {
		String statusLine = response.getStatusLine();
		System.out.println("Status line : "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
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
