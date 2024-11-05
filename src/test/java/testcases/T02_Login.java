package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_Register;
import pages.P02_Login;

import java.time.Duration;

public class T02_Login {
    public static ChromeDriver driver ;
    public static WebDriverWait wait;
    P02_Login P02Log = new P02_Login();
    // Test data
    public static String Fname = "Karim";
    public static String Lname = "Saleh";
    public static String Email = "Kaaa121224@gmail.com";
    public static String Passw = "AEdr33445564";

    @BeforeMethod
    public void testSetUP() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void TC1() {
        P02Log.clickSignin().click();
        P02Log.enterEmail().sendKeys(T01_Register.Email);
        P02Log.enterPassward().sendKeys(T01_Register.Passw);
        P02Log.clickLogin().click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://magento.softwaretestingboard.com/");
        //Thread.sleep(3000);
        //WebElement welcomeMessageElement = driver.findElement(By.cssSelector(".greet.welcome span"));
        String actualWelcomeMessage = P02Log.welcomeMessageElement().getText();
        System.out.println("Actual Welcome Message: '" + actualWelcomeMessage + "'");
        //Thread.sleep(4000);
        String expectedWelcomeMessage = "Welcome, " + T01_Register.Fname + " " + T01_Register.Lname + "!";
        Assert.assertTrue(actualWelcomeMessage.contains(T01_Register.Fname + " " + T01_Register.Lname),
                "Welcome message does not contain the expected first and last name");
        Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
