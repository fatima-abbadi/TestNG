package automationFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FatimaTest {
    private WebDriver driver;
    
    @Test(priority = 1)
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
        System.out.println("Logo is  displayed on the homepage");
    }
    
    @Test(priority = 3)
    public void navigateToSignInPage() {
      
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
      WebElement signInLink = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"myAccount\"]/a")));
        //WebElement signInLink = driver.findElement(By.xpath("//*[@id='myAccount']/a"));
  signInLink.click();
         System.out.print("SignIn Link opend");
            // Verify navigation by checking if the Sign-In page is displayed
              WebElement signInPageElement = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("custom")));
           Assert.assertTrue(signInPageElement.isDisplayed(), "User is not navigated to the Sign-In page.");
        } 

   @Test(priority = 4)
   public void performLogin() {
      WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(100));

         WebElement emailField = driver.findElement(By.xpath("//*[@id=\"logonId\"]"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"logonPassword\"]"));
        WebElement loginButton = driver.findElement(By.id("logonButton"));

        emailField.sendKeys("fhani0899@gmail.com");
        passwordField.sendKeys("fatima2002214");
       loginButton.click();

////         // Verify the user is logged in correctly by checking if the "Sign In/Register" link is changed to "My Account"
         WebElement signInPageElement = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cbiBody\"]")));     }

    

    
    @Test(priority = 5)
    public void verifyUserName() {
    	  WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(100));
      WebElement welcomeMessage =driver.findElement(By.xpath("//*[@id=\"login\"]/a"));
      String welcomeText = welcomeMessage.getText();
    Assert.assertTrue(welcomeText.contains("fatima "), "Username verification failed.");
    }
   
    }
