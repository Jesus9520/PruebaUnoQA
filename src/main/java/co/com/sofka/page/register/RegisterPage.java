package co.com.sofka.page.register;

import co.com.sofka.model.RegisterPageModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends CommonActionOnPages {
    private static final Logger LOGGER = Logger.getLogger(RegisterPage.class);
    private RegisterPageModel registerPageModel;

    public RegisterPage(WebDriver driver, int seconds, boolean explicitTime, RegisterPageModel registerPageModel) {
        super(driver, seconds, explicitTime);
        pageFactoryInitElement(driver, this);
        this.registerPageModel = registerPageModel;
    }
    @FindBy(linkText="Register")
    @CacheLookup
    private WebElement register;


    @FindBy(id = "customer.firstName")
    @CacheLookup
    private WebElement firstName;

    @FindBy(id = "customer.lastName")
    @CacheLookup
    private WebElement lastName;

    @FindBy(id = "customer.address.street")
    @CacheLookup
    private WebElement address;

    @FindBy(id = "customer.address.city")
    @CacheLookup
    private WebElement city;

    @FindBy(id = "customer.address.state")
    @CacheLookup
    private WebElement state;

    @FindBy(id = "customer.address.zipCode")
    @CacheLookup
    private WebElement zipCode;

    @FindBy(id = "customer.phoneNumber")
    @CacheLookup
    private WebElement phone;

    @FindBy(id = "customer.ssn")
    @CacheLookup
    private WebElement ssn;

    @FindBy(id = "customer.username")
    @CacheLookup
    private WebElement username;

    @FindBy(id = "customer.password")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "repeatedPassword")
    @CacheLookup
    private WebElement confirm;

    @FindBy(css = "td > .button")
    @CacheLookup
    private WebElement buttonRegister;

    @FindBy(css="#rightPanel > p")
    @CacheLookup
    private WebElement title;

    @FindBy(css=".title")
    @CacheLookup
    private WebElement titleFailed;



    public void fillRegister() {

        clickOn(register);

        scrollOnWithExplicitWait(firstName);
        clearOnWithExplicitWait(firstName);
        clickOnWithExplicitWait(firstName);
        typeOnWithExplicitWait(firstName, registerPageModel.getFirstName());

        scrollOnWithExplicitWait(lastName);
        clearOnWithExplicitWait(lastName);
        clickOnWithExplicitWait(lastName);
        typeOnWithExplicitWait(lastName, registerPageModel.getLastName());

        scrollOnWithExplicitWait(address);
        clearOnWithExplicitWait(address);
        clickOnWithExplicitWait(address);
        typeOnWithExplicitWait(address, registerPageModel.getAddress());

        scrollOnWithExplicitWait(city);
        clearOnWithExplicitWait(city);
        clickOnWithExplicitWait(city);
        typeOnWithExplicitWait(city, registerPageModel.getCity());

        scrollOnWithExplicitWait(state);
        clearOnWithExplicitWait(state);
        clickOnWithExplicitWait(state);
        typeOnWithExplicitWait(state, registerPageModel.getState());

        scrollOnWithExplicitWait(zipCode);
        clearOnWithExplicitWait(zipCode);
        clickOnWithExplicitWait(zipCode);
        typeOnWithExplicitWait(zipCode, registerPageModel.getZipCode());

        scrollOnWithExplicitWait(phone);
        clearOnWithExplicitWait(phone);
        clickOnWithExplicitWait(phone);
        typeOnWithExplicitWait(phone, registerPageModel.getPhone());

        scrollOnWithExplicitWait(ssn);
        clearOnWithExplicitWait(ssn);
        clickOnWithExplicitWait(ssn);
        typeOnWithExplicitWait(ssn, registerPageModel.getSsn());

        scrollOnWithExplicitWait(username);
        clearOnWithExplicitWait(username);
        clickOnWithExplicitWait(username);
        typeOnWithExplicitWait(username, registerPageModel.getUsername());

        scrollOnWithExplicitWait(password);
        clearOnWithExplicitWait(password);
        clickOnWithExplicitWait(password);
        typeOnWithExplicitWait(password, registerPageModel.getPassword());

        scrollOnWithExplicitWait(confirm);
        clearOnWithExplicitWait(confirm);
        clickOnWithExplicitWait(confirm);
        typeOnWithExplicitWait(confirm, registerPageModel.getConfirm());


        clickOnWithExplicitWait(buttonRegister);

    }
    public String registerSuccess(){
        return getTextWithExplicitWait(title);
    }
    public String registerFailed(){ return getTextWithExplicitWait(titleFailed);}


}
