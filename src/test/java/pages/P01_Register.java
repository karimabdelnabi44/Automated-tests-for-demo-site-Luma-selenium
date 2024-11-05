package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testcases.T01_Register;

import java.time.Duration;

import static testcases.T01_Register.driver;

public class P01_Register {

   public WebElement getCreateAccount()
   {

       return T01_Register.driver.findElement(By.linkText("Create an Account"));
    }
    public WebElement sendFirstname()
    {
        return T01_Register.driver.findElement(By.id("firstname"));
    }
    public WebElement sendLastname()
    {
        return T01_Register.driver.findElement(By.id("lastname"));
    }
    public WebElement sendEmail()
    {
        return T01_Register.driver.findElement(By.id("email_address"));
    }
    public WebElement sendPassward()
    {
        return T01_Register.driver.findElement(By.id("password"));
    }
    public WebElement sendPasswardConfirmation()
    {
        return T01_Register.driver.findElement(By.id("password-confirmation"));
    }
    public WebElement clickSubmit()
    {
        return T01_Register.driver.findElement(By.cssSelector("button[class=\"action submit primary\""));
    }
    public WebElement findErrorMessage()
    {
        return T01_Register.driver.findElement(By.id("password-confirmation-error"));
    }
    public WebElement getShownFname()
    {
        return T01_Register.driver.findElement(By.xpath("//div[@class='box-content']//parent::div[@class='box box-information']"));
    }
    public WebElement getShownLname()
    {
        return T01_Register.driver.findElement(By.xpath("//div[@class='box-content']//parent::div[@class='box box-information']"));
    }
    public WebElement getShownEmail()
    {
        return T01_Register.driver.findElement(By.xpath("//div[@class='box-content']//parent::div[@class='box box-information']"));
    }

}
