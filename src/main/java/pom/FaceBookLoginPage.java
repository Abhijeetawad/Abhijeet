package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaceBookLoginPage {
    
    @FindBy(xpath = "//input[@id='email']") private WebElement email;
    @FindBy(xpath = "//input[@placeholder='Password']")private WebElement password;
    @FindBy(xpath = "//button[@data-testid='royal-login-button']")private WebElement login;
    @FindBy(xpath = "//a[text()='Forgotten password?']")private WebElement forgotPassword;
    @FindBy(xpath = "//a[@data-testid='open-registration-form-button']")private WebElement createNewAccount;
    @FindBy(xpath = "//a[text()='Create a Page']")private WebElement createAPage;
    @FindBy(xpath = "//input[@name='firstname']")private WebElement firstName;
    @FindBy(xpath = "//img[@class='fb_logo _8ilh img']")private WebElement logo;
  
    // Constructor to initialize elements
    public FaceBookLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
     // Enter email
    public void enterEmailId(String mailId) {
        email.sendKeys(mailId);
    }
    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }
    public void clickOnLogin() {
        login.click();
    }
    public void clickOnForgotPassword() {
    	forgotPassword.click();
    }
    public void clickOncreateNewAccount() {
    	createNewAccount.click();
    }
    public void clickOncreateAPage() {
    	createAPage.click();
    }
    public void EnterfirstName(String name,WebDriver driver) {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.visibilityOf(firstName));
    	firstName.sendKeys(name);
    }
    public boolean isLogoDisplayed() {
    	boolean a=logo.isDisplayed();
    	return a;
    }
    
}