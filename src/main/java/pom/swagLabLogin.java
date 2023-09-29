package pom;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class swagLabLogin {
    @FindBy(xpath = "//input[@id='user-name']") private WebElement username;
    @FindBy(xpath = "//input[@id='password']") private WebElement pass;
    @FindBy(xpath = "//input[@id='login-button']") private WebElement login;
    @FindBy(xpath = "//div[@class='login_logo']") private WebElement swaglablogo;


    public swagLabLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public Boolean swagLabLogo(){
        swaglablogo.isDisplayed();
        return true;
    }

    public void userName(String userName) {
        username.sendKeys(userName);
    }
    public void passWord(String password) {
        pass.sendKeys(password);
    }
    public void Login() {
        login.click();
    }


}
