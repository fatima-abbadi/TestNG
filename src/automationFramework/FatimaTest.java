package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FatimaTest {
    private WebDriver driver;
    
    @Test
    public void setUp() {
        // Set up the WebDriver (ensure the path to your ChromeDriver is correct)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ProBook\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ballarddesigns.com/");
        System.out.println("Website Opend");
    }
    @Test(priority = 2)
    public void verifyLogoDisplayed() {
        // Verify the logo1 is displayed
        WebElement logo = driver.findElement(By.className("logo-anchor"));
        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed on the homepage.");
    }
    
    @Test(priority = 3)
    public void navigateToSignInPage() {
        // Click on "Sign In/Register" link
       WebElement signInLink = driver.findElement(By.id("myAccount"));
        signInLink.click();
        Assert.assertTrue(signInLink.isDisplayed(), "User is not navigated to the Sign-In page.");
    }
    
    @Test(priority = 4)
    public void performLogin() {
        // Enter valid email and password
        WebElement emailField = driver.findElement(By.id("logonId"));
        WebElement passwordField = driver.findElement(By.id("logonPassword"));
        WebElement loginButton = driver.findElement(By.id("logonButton"));

        emailField.sendKeys("fhani0899@gmail.com");
        passwordField.sendKeys("fatima2002214");
        loginButton.click();

        // Verify the user is logged in correctly by checking if the "Sign In/Register" link is changed to "My Account"
        WebElement myAccountLink =driver.findElement(By.id("myAccount"));
        Assert.assertTrue(myAccountLink.isDisplayed(), "Login failed, 'My Account' link is not displayed.");
    }
    
    @Test(priority = 5)
    public void verifyUserName() {
     
        WebElement welcomeMessage =driver.findElement(By.id("welcomeMessage"));
        String welcomeText = welcomeMessage.getText();
        Assert.assertTrue(welcomeText.contains("fatima "), "Username verification failed.");
    }
   
    
    }
