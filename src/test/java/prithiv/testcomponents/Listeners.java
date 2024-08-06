package prithiv.testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import TestComponents.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener {
	
	ExtentTest test;
	ExtentReports reportObject;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	
	@Override
	public  void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
		
		ExtentReportNG extent = new ExtentReportNG();
		 reportObject = extent.getReportObject();
		 test = reportObject.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
	
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		BaseTest base = new BaseTest();
		extentTest.get().fail(result.getThrowable());
		try {
			driver =(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String path = null;
		try {
			path = base.getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	}
@Override
public void onFinish(ITestContext context) {
	ITestListener.super.onFinish(context);
	reportObject.flush();
}
}
