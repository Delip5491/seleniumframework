package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    WebDriver driver;
    public Homepage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myaccount;

    @FindBy(linkText = "Register")
    WebElement register;

    @FindBy(linkText = "Login")
    WebElement login;

    public void setMyaccount(){
        myaccount.click();
    }

    public void setRegister(){
        register.click();
    }

    public void setLogin(){
        login.click();
    }
}
