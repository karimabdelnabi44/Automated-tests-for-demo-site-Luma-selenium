package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testcases.T02_Login;

public class P02_Login {
    public WebElement clickSignin(){
        return T02_Login.driver.findElement(By.linkText("Sign In")) ;
    }
    public WebElement enterEmail(){
        return T02_Login.driver.findElement(By.id("email"));
    }
    public WebElement enterPassward(){
        return T02_Login.driver.findElement(By.id("pass"));
    }
    public WebElement clickLogin(){
        return T02_Login.driver.findElement(By.id("send2"));
    }
    public WebElement welcomeMessageElement(){
        return T02_Login.driver.findElement(By.cssSelector(".greet.welcome span"));
    }
}
