package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_Register;
import pages.P02_Login;
import pages.P03_LandingPage;

import java.time.Duration;

public class T03_LandingPage{
    public static ChromeDriver driver ;
    public static WebDriverWait wait;
    P03_LandingPage P0Land = new P03_LandingPage();

    @BeforeMethod
    void testSetUP(){
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    void TC1() throws InterruptedException {
        P0Land.goHotSellersSection();
        for (int i=0 ; i<6 ; i++) {
            boolean x = driver.findElements(By.className("price")).get(i).getText().contains("$");
            Assert.assertTrue(x);
        }
        for (int x=0 ; x<6 ; x++ ){
            String price = P0Land.getProductPrices().get(x).getText();
            String priceValue = price.replace("$", "").trim();
            Assert.assertTrue(priceValue.matches("\\d+\\.\\d{2}"));
        }
    }
    @Test
    void TC2(){
            P0Land.goHotSellersSection();
            int Products = P0Land.getProductCount();
            for (int y = 0 ; y < Products; y ++) {
            Actions Hoverproduct = new Actions(driver);
            WebElement productItem = P0Land.getProductItems().get(y);
            Hoverproduct.moveToElement(productItem).perform();
            WebElement addToCartButton = P0Land.getAddToCartButton(productItem);;
            Assert.assertTrue(addToCartButton.isDisplayed());
            System.out.println("Product " + (y + 1) + " has an 'Add to Cart' button that is clickable.");
            }
        }
    @Test ()
    void TC3 (){
        P0Land.goHotSellersSection();
        P0Land.findBreatheEasyTank();
        P0Land.clickBreatheEasyTankSize().click();
        P0Land.clickBreatheEasyTankColor().click();
        P0Land.clickAddtoCart().click();
        WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-success")));
        String successMessage = successMessageElement.getText();
        Assert.assertTrue(successMessage.contains("You added Breathe-Easy Tank to your shopping cart."));
        WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".counter-number")));
        Assert.assertEquals(cartIcon.getText(), "1");
    }
    @AfterMethod
    public void End() {
        driver.quit();
    }
}
