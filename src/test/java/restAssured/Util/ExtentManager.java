package restAssured.Util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getExtentReport() {
		if(extent == null) {
			Date date = new Date();
			String fileExtention = date.toString().replace(":", "_").replace(" ", "_")+".html";
			String reportPath = System.getProperty("user.dir") + "//ExtentReports//"+"Report_"+fileExtention;
			extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportConfig.xml"));
			extent.addSystemInfo("Selenium Version", "3.4").addSystemInfo("Environment", "QA");
		}
		return extent;
	}

}
