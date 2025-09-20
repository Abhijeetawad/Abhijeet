package test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.Screenshot;

public class Listeners extends BaseTest implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test started :-"+ result.getName());	
	}
    public void onTestSuccess(ITestResult result) {
    	System.out.println("Test success :-"+ result.getName());
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed :-"+ result.getName());	
		
		try {
			Screenshot.ClickScreenshot(driver,result.getName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped :-"+ result.getName());
	}
}
