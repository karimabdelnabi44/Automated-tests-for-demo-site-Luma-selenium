package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_Register;

import java.time.Duration;

public class T01_Register {
   public static ChromeDriver driver ;
   public static WebDriverWait wait;
   P01_Register P01Rigster = new P01_Register();
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
        P01Rigster.getCreateAccount().click();
        P01Rigster.sendFirstname().sendKeys("Karim");
        P01Rigster.sendLastname().sendKeys("Saleh");
        P01Rigster.sendEmail().sendKeys("kgggg@gmail.com");
        P01Rigster.sendPassward().sendKeys("12345678");
        P01Rigster.sendPasswardConfirmation().clear();
        P01Rigster.clickSubmit().click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://magento.softwaretestingboard.com/customer/account/create/");
        String errorMessage = P01Rigster.findErrorMessage().getText();;
        Assert.assertEquals(errorMessage, "This is a required field.");
    }
    @Test
    public void TC2() {
        P01Rigster.getCreateAccount().click();
        P01Rigster.sendFirstname().sendKeys("Karim");
        P01Rigster.sendLastname().sendKeys("Saleh");
        P01Rigster.sendEmail().sendKeys("kgggg@gmail.com");
        P01Rigster.sendPassward().sendKeys("12345678");
        P01Rigster.sendPasswardConfirmation().sendKeys("123338883");
        P01Rigster.clickSubmit().click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://magento.softwaretestingboard.com/customer/account/create/");
        String errorMessage = P01Rigster.findErrorMessage().getText();;
        Assert.assertEquals(errorMessage, "Please enter the same value again.");
    }
    @Test
    public void TC3() {
        P01Rigster.getCreateAccount().click();
        P01Rigster.sendFirstname().sendKeys(Fname);
        P01Rigster.sendLastname().sendKeys(Lname);
        P01Rigster.sendEmail().sendKeys(Email);
        P01Rigster.sendPassward().sendKeys(Passw);
        P01Rigster.sendPasswardConfirmation().sendKeys(Passw);
        P01Rigster.clickSubmit().click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://magento.softwaretestingboard.com/customer/account/");
        String shownfname = P01Rigster.getShownFname().getText();
        String shownlname = P01Rigster.getShownLname().getText();
        String shownemail = P01Rigster.getShownEmail().getText();
        Assert.assertTrue(shownfname.contains(Fname));
        Assert.assertTrue(shownlname.contains(Fname));
        Assert.assertTrue(shownemail.contains(Fname));
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
