package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

public class BaseClass {

    public WebDriver driver;
    public Logger logger;
    public ResourceBundle rb; //to read config.properties file

    @BeforeClass
    @Parameters({"browser"})
    public void setup(String br){

        logger= LogManager.getLogger(this.getClass());
        rb=ResourceBundle.getBundle("config");

        if(br.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(br.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }else if(br.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }

    }

    @AfterClass
    public void teardown(){
     driver.close();
    }

    public String randomeString(){
        String generateString= RandomStringUtils.randomAlphabetic(6);
        return (generateString);
    }

    public int randominteger(){
        String generateString2=RandomStringUtils.randomNumeric(4);
        return (Integer.parseInt(generateString2));
    }

   public void capturescreen(WebDriver driver,String tname) throws IOException {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        File target=new File(System.getProperty("user.dir")+"\\screenshots\\"+ tname + ".png");
        FileUtils.copyFile(source,target);
   }
}
