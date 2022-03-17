package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import testBase.BaseClass;

import java.time.Duration;

public class TC_001_AccountRegistration extends BaseClass {

    @Test
    public void test_account_Registration() throws InterruptedException {

        logger.info("Started TC_001_AccountRegistration Execution");
        try {
            driver.get(rb.getString("appurl"));
            logger.info("Launched the url");
            driver.manage().window().maximize();


            Homepage hp = new Homepage(driver);
            hp.setMyaccount();
            logger.info("Clicked on Myaccount");
            hp.setRegister();
            logger.info("Clicked on register");

            AccountRegistrationPage arp = new AccountRegistrationPage(driver);
            arp.setTxtFirstName("Delip");
            logger.info("provided first name");
            arp.setTxtLastName("Salapakshi");
            logger.info("provided last name");
            arp.setTxtEmail(randomeString() + "@gmail.com");
            logger.info("provided email id");
            arp.setTxtTelephone("6698839532");
            logger.info("provided telephone number");
            arp.setTxtPassword("Abc@123");
            logger.info("provided password");
            arp.setTxtConfirmPassword("Abc@123");
            logger.info("provided confirm password");
            arp.setChkdPolicy();
            logger.info("Set privacy policy");
            arp.setBtnContinue();
            logger.info("Clicked on Continue");
            Thread.sleep(2000);
            String cnfrmsg = arp.getMsgConfirmation();
            System.out.println(cnfrmsg);

            if (cnfrmsg.equals("Your Account Has Been Created!!")) {
                logger.info("Account Registration successful");
                Assert.assertTrue(true);
            } else {
                logger.error("Account Registration Failed");
                capturescreen(driver,"test_account_Registration");
                logger.info("screenshot captured");
                Assert.assertTrue(false);
            }

    }catch(Exception e){
            logger.error("Account Registration Failed");
        Assert.fail();
    }
        logger.info("Finished TC_001_AccountRegistration Execution");
    }

}
