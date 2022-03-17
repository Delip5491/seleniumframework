package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage {

    WebDriver driver;

    public AccountRegistrationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "input-firstname")
    WebElement txtFirstName;

    @FindBy(id="input-lastname")
    WebElement txtLastName;

    @FindBy(id="input-email")
    WebElement txtEmail;

    @FindBy(id="input-telephone")
    WebElement txtTelephone;

    @FindBy(id="input-password")
    WebElement txtPassword;

    @FindBy(id="input-confirm")
    WebElement txtConfirmPassword;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkdPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;


    public void setTxtFirstName(String fname){
        txtFirstName.sendKeys(fname);
    }

    public void setTxtLastName(String lname){
        txtLastName.sendKeys(lname);
    }

    public void setTxtEmail(String email){
        txtEmail.sendKeys(email);
    }

    public void setTxtTelephone(String tel){
        txtTelephone.sendKeys(tel);
    }

    public void setTxtPassword(String pwd){
        txtPassword.sendKeys(pwd);
    }

    public void setTxtConfirmPassword(String cnfmpwd){
        txtConfirmPassword.sendKeys(cnfmpwd);
    }

    public void setChkdPolicy(){
        chkdPolicy.click();
    }

    public void setBtnContinue(){
        btnContinue.click();
    }

    public String getMsgConfirmation(){

        try {
            return (msgConfirmation.getText());
        }catch (Exception e){
            return(e.getMessage());
        }
    }

}
