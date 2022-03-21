package co.com.sofka.page.login;

import co.com.sofka.model.LoginPageModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends CommonActionOnPages {
    private static final Logger LOGGER = Logger.getLogger(LoginPage.class);
    private LoginPageModel loginPageModel;

    public LoginPage(WebDriver driver, int seconds, boolean explicitTime, LoginPageModel loginPageModel) {
        super(driver, seconds, explicitTime);
        pageFactoryInitElement(driver, this);
        this.loginPageModel = loginPageModel;

    }

    // Elementos para las pruebas login
    @FindBy(name = "username")
    @CacheLookup
    private WebElement username;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement password;

    @FindBy(css=".button:nth-child(1)")
    @CacheLookup
    private WebElement loginButton;

    @FindBy(css=".title")
    @CacheLookup
    private WebElement assertionLogionSuccess;

    @FindBy(css=".error")
    @CacheLookup
    private WebElement assertionLoginInsuccess;

    public void fillLogin (){

        scrollOnWithExplicitWait(username);
        clearOnWithExplicitWait(username );
        clickOnWithExplicitWait(username);
        typeOnWithExplicitWait(username, loginPageModel.getUsername());

        scrollOnWithExplicitWait(password);
        clearOnWithExplicitWait(password);
        clickOnWithExplicitWait(password);
        typeOnWithExplicitWait(password, loginPageModel.getPassword());

        clickOnWithExplicitWait(loginButton);
    }

    public String isLoginDone(){
        return getTextWithExplicitWait(assertionLogionSuccess);
    }
    public String isNotLogin() {return getTextWithExplicitWait(assertionLoginInsuccess);}
}
