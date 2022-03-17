package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

    @Test
    public void test_login(){
        logger.info("started TC_002_LoginTest Execution");

        try{

            driver.get(rb.getString("appurl"));
            logger.info("Home Page Displayed ");

            driver.manage().window().maximize();

            Homepage hp=new Homepage(driver);
            hp.setMyaccount();
            logger.info("Clicked on MyAccount ");
            hp.setLogin();
            logger.info("Clicked on Login");

            LoginPage lp=new LoginPage(driver);
            lp.setEmailtextbox(rb.getString("email"));
            logger.info("email address entered");
            lp.setPwdtextbox(rb.getString("pwd"));
            logger.info("password entered");
            lp.setLoginbtn();
            logger.info("clicked on Login button");

            boolean targetpage=lp.isMyAccountPageExists();
            if(targetpage){
                logger.info("Login Test Passed");
                Assert.assertTrue(true);
            }else {
                logger.info("Login Test failed");
                Assert.assertTrue(false);
            }

        }catch (Exception e){
            logger.info("Login Test failed");
            Assert.fail();
        }

        logger.info("Finished TC_002_LoginTest Execution");
    }
}
