package co.com.sofka.stepdefinitions.contactus;

import co.com.sofka.model.ContactUsPageModel;
import co.com.sofka.page.contactus.ContactUsPage;
import co.com.sofka.stepdefinitions.setup.WebUI;
import co.com.sofka.util.Seconds;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class ContactUsTestStepDefinitions extends WebUI {
    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(ContactUsTestStepDefinitions.class);
    private ContactUsPage contactUsPage;
    private ContactUsPageModel contactUsPageModel;

    @Given("me dirijo a Contact Us")
    public void me_dirijo_a_contact_us() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);

        }


    }
    @When("para generar un pqr")
    public void para_generar_un_pqr() {
        try{

            contactUsPageModel = new ContactUsPageModel();
            contactUsPageModel.setName("Jesus");
            contactUsPageModel.setEmail("j.cas@gmail.com");
            contactUsPageModel.setPhone("3214567890");
            contactUsPageModel.setMessage("Olvide usuario y contraseña");

            contactUsPage = new ContactUsPage(driver, Seconds.FIFTY_SECONDS.getValue(), true, contactUsPageModel);
            contactUsPage.fillCustomerUs();


        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }

    }
    @Then("mis respuestas de acuerdo a mi solicitud")
    public void mis_respuestas_de_acuerdo_a_mi_solicitud() {
        Assertions.assertEquals("Customer Care", contactUsPage.sendSuccess());

    }


    @Given("el cliente se dirije a Contact Us")
    public void el_cliente_se_dirije_a_contact_us() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);

        }

    }
    @When("no tiene los datos completos")
    public void no_tiene_los_datos_completos() {
        try{

            contactUsPageModel = new ContactUsPageModel();
            contactUsPageModel.setName("Jesus");
            contactUsPageModel.setEmail("");
            contactUsPageModel.setPhone("3214567890");
            contactUsPageModel.setMessage("Olvide usuario y contraseña");

            contactUsPage = new ContactUsPage(driver, Seconds.FIFTY_SECONDS.getValue(), true, contactUsPageModel);
            contactUsPage.fillCustomerUs();


        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }

    }
    @Then("no genero pqr")
    public void no_genero_pqr() {
        Assertions.assertEquals("Email support is available by filling out the following form.", contactUsPage.sendSuccessVacio());

    }


}
