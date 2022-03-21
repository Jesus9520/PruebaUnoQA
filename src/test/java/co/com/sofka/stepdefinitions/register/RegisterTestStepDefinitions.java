package co.com.sofka.stepdefinitions.register;

import co.com.sofka.model.RegisterPageModel;
import co.com.sofka.page.register.RegisterPage;
import co.com.sofka.stepdefinitions.setup.WebUI;
import co.com.sofka.util.Seconds;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class RegisterTestStepDefinitions extends WebUI {

    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(RegisterTestStepDefinitions.class);
    private RegisterPage registerPage;
    private RegisterPageModel registerPageModel;


    @Given("la persona crea un usuario")
    public void la_persona_crea_un_usuario() {
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

    @When("diligencio el formulario de registro")
    public void diligencio_el_formulario_de_registro() {
        try{

            registerPageModel = new RegisterPageModel();
            registerPageModel.setFirstName("Jesus");
            registerPageModel.setLastName("perez");
            registerPageModel.setAddress("Calle 24 4a");
            registerPageModel.setCity("Bogota");
            registerPageModel.setState("Colombia");
            registerPageModel.setZipCode("54001");
            registerPageModel.setPhone("3243454345");
            registerPageModel.setSsn("345");
            registerPageModel.setUsername("Morado");
            registerPageModel.setPassword("60445905");
            registerPageModel.setConfirm("60445905");
            registerPage = new RegisterPage(driver, Seconds.THIRTY_SECONDS.getValue(), true, registerPageModel);

            registerPage.fillRegister();


        }  catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);

        }
    }

    @Then("debo quedar registrado")
    public void debo_quedar_registrado() {
        Assertions.assertEquals("Your account was created successfully. You are now logged in.", registerPage.registerSuccess());


    }


    @Given("la persona desea crear un usuario")
    public void la_persona_desea_crear_un_usuario() {
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

    @When("no diligencio el formulario de manera correcta")
    public void no_diligencio_el_formulario_de_manera_correcta() {
        try{

            registerPageModel = new RegisterPageModel();
            registerPageModel.setFirstName("");
            registerPageModel.setLastName("");
            registerPageModel.setAddress("");
            registerPageModel.setCity("");
            registerPageModel.setState("");
            registerPageModel.setZipCode("");
            registerPageModel.setPhone("");
            registerPageModel.setSsn("");
            registerPageModel.setUsername("");
            registerPageModel.setPassword("");
            registerPageModel.setConfirm("");
            registerPage = new RegisterPage(driver, Seconds.TEN_SECONDS.getValue(),true, registerPageModel);
            registerPage.fillRegister();


        }  catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);

        }
    }

    @Then("no se creo registro")
    public void no_se_creo_registro() {
        Assertions.assertEquals("Signing up is easy!", registerPage.registerFailed());

    }


}
