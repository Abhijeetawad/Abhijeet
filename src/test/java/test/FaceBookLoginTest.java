package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.FaceBookLoginPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class FaceBookLoginTest extends BaseTest {
	WebDriver driver;
	ExtentReports extentReports;
	ExtentTest test;
	
	@BeforeTest
	public void ConfigureReports()
	{
		extentReports =Reports.generateReports();
	}
	
	@BeforeMethod
	public void LaunchBrowser()
	{
		driver=Browser.openChrome("https://www.facebook.com/");
	}
	
	@Test
	public void createNewAccountTest()
	{
		test=extentReports.createTest("createNewAccountTest");
		FaceBookLoginPage faceBookLoginPage=new FaceBookLoginPage(driver);
		faceBookLoginPage.clickOncreateNewAccount();
		faceBookLoginPage.EnterfirstName("Abhijeet",driver);
	}
	@Test
	public void verifyIfFacebookLoginPageDisplayedonloginPage()
	{
		test=extentReports.createTest("verifyIfFacebookLoginPageDisplayedonloginPage");
		FaceBookLoginPage faceBookLoginPage=new FaceBookLoginPage(driver);
		boolean result = faceBookLoginPage.isLogoDisplayed();
		SoftAssert softAssert =new SoftAssert();
		softAssert.assertFalse(result);
		faceBookLoginPage.enterEmailId("Abhijeetawadd4@gmail.com");
		faceBookLoginPage.enterPassword("Abhi123");
		faceBookLoginPage.clickOnLogin();
		System.out.println("Thank you");
		softAssert.assertAll();
	}
	@Test
	public void verifyLoginPageTitle()
	{
		test=extentReports.createTest("verifyLoginPageTitle");
		FaceBookLoginPage faceBookLoginPage=new FaceBookLoginPage(driver);
		String expectedTitle="Facebook – log in or sign up";
		String actualTitle= driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);;
	}
	
	@AfterMethod
    public void addTestStatus(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getName() + " PASSED");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, result.getName() + " FAILED");
            test.log(Status.FAIL, result.getThrowable()); // log exception
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, result.getName() + " SKIPPED");
        }
    }

    @AfterTest
    public void publishReports() {
        extentReports.flush();
    }
}


