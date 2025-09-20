package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports generateReports() {
		
		ExtentSparkReporter htmlReporter= new ExtentSparkReporter("ExtentReports.html");    //to create report
		ExtentReports extentReports =new ExtentReports();                                         //to get data
		extentReports.attachReporter(htmlReporter);                                               //to attach or send data to ExtentSparkReporter
		extentReports.setSystemInfo("version", "1.10");
		extentReports.setSystemInfo("create by", "Abhijeet Awad");
		extentReports.setSystemInfo("Testing Type", "Regression");
		
		return extentReports;
	}

}
