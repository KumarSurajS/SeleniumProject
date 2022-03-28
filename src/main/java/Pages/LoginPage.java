package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(){
        PageFactory.initElements(driver, LoginPage.class);
    }


    By userName = By.xpath(".//*[@id='login1']");
    By password = By.name("passwd");
    By go = By.name("proceed");

    public WebElement emailId(){
        return driver.findElement(userName);
    }

    public WebElement passWord(){
        return driver.findElement(password);
    }
    public WebElement submit(){
        return driver.findElement(go);
    }


}
