package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P02_Login;
import pages.P04_WishList;

import java.time.Duration;

public class T04_WishList {
    public static ChromeDriver driver ;
    public static WebDriverWait wait;
    P04_WishList P4Wish = new P04_WishList();

    @BeforeMethod
    void testSetUP() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    void TC1() throws InterruptedException {
        P4Wish.gooHotSellersSection();
        Actions Hoverproduct = new Actions(driver);
        Hoverproduct.moveToElement(P4Wish.hoverBreathEasyTank()).perform();
        WebDriverWait EX = new WebDriverWait(driver,Duration.ofSeconds(5));
        EX.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@title='Add to Wish List'])[2]")));
        P4Wish.addToWishList().click();
        boolean T = P4Wish.findSpan().isDisplayed();
        Assert.assertTrue(T);
    }
    @Test
    void TC2(){
        P4Wish.gooHotSellersSection();
        Actions Hoverproduct = new Actions(driver);
        WebElement productElement = P4Wish.hoverBreathEasyTank();
        String expectedProductName = productElement.getAttribute("title");
        Hoverproduct.moveToElement(productElement).perform();
        WebDriverWait EX = new WebDriverWait(driver,Duration.ofSeconds(5));
        EX.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@title='Add to Wish List'])[2]")));
        P4Wish.addToWishList().click();
        P4Wish.enterLoginEmail().sendKeys(T01_Register.Email);
        P4Wish.enterLoginPass().sendKeys(T01_Register.Passw);
        P4Wish.clickLog().click();
        wait.until(ExpectedConditions.titleContains("My Wish List"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("wishlist"));
        WebElement wishlistProduct = P4Wish.checkItem();
        String actualProductName = wishlistProduct.getText();
        Assert.assertEquals(actualProductName, expectedProductName);
    }
    @AfterMethod
    public void End() {
        driver.quit();
    }
}
