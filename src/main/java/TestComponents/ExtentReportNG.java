package TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports getReportObject() {
String path = System.getProperty("user.dir")+"\\reportsdocument\\index.html";
	
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation");
	reporter.config().setDocumentTitle("Test Results");
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester Name", "prithiv");
	
	return extent;
}
}
