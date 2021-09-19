package restAssured.Base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restAssured.Util.ExtentManager;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class APIBase {

	public static RequestSpecification httpRequest;
	public static Response response;
	public static ExtentReports reports = ExtentManager.getExtentReport();
	public static ExtentTest test;
	public static String testName;
	public static JSONParser parser;

	@BeforeClass
	public void beforeClass() {
		//Specify URI
		RestAssured.baseURI = "https://reqres.in";
		//Create object which will send request
		httpRequest = RestAssured.given();
//		httpRequest = RestAssured.given().auth().preemptive().basic("", "");
	}
	@BeforeMethod
	public void startReport() {
		testName = this.getClass().getSimpleName();
		test = reports.startTest(testName);
	}
	
	@AfterMethod
	public void endReport() {
		reports.endTest(test);
		reports.flush();
	}

	@AfterClass
	public void afterClass() {

	}
}
