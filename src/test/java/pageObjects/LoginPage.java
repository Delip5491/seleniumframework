package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailtextbox;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement pwdtextbox;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginbtn;

    @FindBy(xpath="//h2[text()='My Account']")
    WebElement msgHeading;


    public void setEmailtextbox(String email){
        emailtextbox.sendKeys(email);
    }

    public void setPwdtextbox(String pwd){
        pwdtextbox.sendKeys(pwd);
    }

    public void setLoginbtn(){
        loginbtn.click();
    }

    public boolean isMyAccountPageExists(){
        try{
            return (msgHeading.isDisplayed());
        }catch (Exception e){
            return(false);
        }
    }

}
