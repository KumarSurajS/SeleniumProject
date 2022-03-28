package BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class Base {
    public static WebDriver driver;
    public static String BrowserName;
    public static Properties prop;

    public static Logger logger =  LogManager.getLogger(Base.class.getName());
        public  Base() throws IOException {
            prop = new Properties();
            String fileDestination = System.getProperty("user.dir")+"//src//main//java//Config//config.properties";
            FileInputStream inputStream = new FileInputStream(fileDestination);
            prop.load(inputStream);
            BrowserName = prop.getProperty("browser");
        }


    public  WebDriver initialization()  {


        if (BrowserName.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);

        }
        else if (BrowserName.equalsIgnoreCase("ff")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
        }
        else{
            InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver(internetExplorerOptions);
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(prop.getProperty("url"));
        return driver;

    }

    public void failed(String methodName) throws IOException {
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String DestFile = System.getProperty("user.dir") + "//Screenshots//" + methodName + "1.png";
        FileUtils.copyFile(srcFile, new File(DestFile));


    }
}
