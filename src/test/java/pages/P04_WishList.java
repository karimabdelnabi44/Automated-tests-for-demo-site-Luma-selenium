package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testcases.T03_LandingPage;
import testcases.T04_WishList;

public class P04_WishList {
    public  void gooHotSellersSection() {
        T04_WishList.driver.findElement(By.xpath("//h2[contains(text(),'Hot Sellers')]"));
    }
    public WebElement hoverBreathEasyTank(){
      return T04_WishList.driver.findElement(By.xpath("//a[contains(@title,'Breathe-Easy Tank')]"));
    }
    public WebElement addToWishList(){
        return T04_WishList.driver.findElement(By.xpath("(//a[@title='Add to Wish List'])[2]"));
    }
    public WebElement findSpan(){
        return T04_WishList.driver.findElement(By.xpath("//span[@class='base']"));
    }
    public WebElement enterLoginEmail(){
        return T04_WishList.driver.findElement(By.xpath("//input[@id='email']"));
    }
    public WebElement enterLoginPass(){
        return T04_WishList.driver.findElement(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']"));
    }
    public WebElement clickLog(){
        return T04_WishList.driver.findElement(By.cssSelector("fieldset[class='fieldset login'] div[class='primary'] span"));
    }
    public WebElement checkItem(){
        return T04_WishList.driver.findElement(By.xpath("//strong[@class='product-item-name']/a"));
    }



}
