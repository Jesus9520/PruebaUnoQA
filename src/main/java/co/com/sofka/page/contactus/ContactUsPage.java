package co.com.sofka.page.contactus;

import co.com.sofka.model.ContactUsPageModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends CommonActionOnPages {
    private static final Logger LOGGER = Logger.getLogger(ContactUsPage.class);
    private ContactUsPageModel contactUsPageModel;

    public ContactUsPage(WebDriver driver, int seconds, boolean explicitTime, ContactUsPageModel contactUsPageModel) {
        super(driver, seconds, explicitTime);
        pageFactoryInitElement(driver, this);
        this.contactUsPageModel = contactUsPageModel;
    }

    @FindBy(linkText = "Contact Us")
    @CacheLookup
    private WebElement contactus;

    @FindBy(id = "name")
    @CacheLookup
    private WebElement name;

    @FindBy(id = "email")
    @CacheLookup
    private WebElement email;

    @FindBy(id = "phone")
    @CacheLookup
    private WebElement phone;

    @FindBy(id = "message")
    @CacheLookup
    private WebElement message;

    @FindBy(css = "td > .button")
    @CacheLookup
    private WebElement sendToCustomerCare;

    @FindBy(css = ".title")
    @CacheLookup
    private WebElement sendsuccessful;

    @FindBy(css="#rightPanel > p")
    @CacheLookup
    private WebElement sendsuccessfulvacio;



    public void fillCustomerUs() {

        clickOn(contactus);

        scrollOnWithExplicitWait(name);
        clearOnWithExplicitWait(name);
        clickOnWithExplicitWait(name);
        typeOnWithExplicitWait(name, contactUsPageModel.getName());

        scrollOnWithExplicitWait(email);
        clearOnWithExplicitWait(email);
        clickOnWithExplicitWait(email);
        typeOnWithExplicitWait(email, contactUsPageModel.getEmail());

        scrollOnWithExplicitWait(phone);
        clearOnWithExplicitWait(phone);
        clickOnWithExplicitWait(phone);
        typeOnWithExplicitWait(phone, contactUsPageModel.getPhone());

        scrollOnWithExplicitWait(message);
        clearOnWithExplicitWait(message);
        clickOnWithExplicitWait(message);
        typeOnWithExplicitWait(message, contactUsPageModel.getMessage());

        clickOnWithExplicitWait(sendToCustomerCare);
    }
    public String sendSuccess(){
        return getTextWithExplicitWait(sendsuccessful);
    }
    public String sendSuccessVacio(){
        return getTextWithExplicitWait(sendsuccessfulvacio);
    }
}
