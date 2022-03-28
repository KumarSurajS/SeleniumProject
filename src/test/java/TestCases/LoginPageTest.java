package TestCases;
import BasePage.Base;
import Pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends Base {
    LoginPage loginPage;

    public LoginPageTest() throws IOException {
        super();
    }


    @BeforeMethod
    public void setUp()  {
        driver = initialization();
        loginPage = new LoginPage();
        logger.info("Inialization" + prop.getProperty("browser") + "browser");
    }

    @Test
    public void Login(){
        loginPage.emailId().sendKeys("Hello");
        loginPage.passWord().sendKeys("hello");
        loginPage.submit().click();
        logger.info("Login to the Application");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
