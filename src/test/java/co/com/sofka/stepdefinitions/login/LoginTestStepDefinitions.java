package co.com.sofka.stepdefinitions.login;

import co.com.sofka.model.LoginPageModel;
import co.com.sofka.page.login.LoginPage;
import co.com.sofka.stepdefinitions.setup.WebUI;
import co.com.sofka.util.Seconds;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class LoginTestStepDefinitions extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(LoginTestStepDefinitions.class);
    private LoginPage loginPage;
    private LoginPageModel loginPageModel;


    @Given("que ingrese a la pagina")
    public void queIngreseALaPagina() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();
        } catch (Exception exception) {
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);

        }
    }


    @When("ingreso mis credenciales correctamente Username {string} y Password {string}")
    public void ingresoMisCredencialesCorrectamenteUsernameYPassword(String username, String password) {
        try {
            loginPageModel = new LoginPageModel();
            loginPageModel.setUsername(username);
            loginPageModel.setPassword(password);
            loginPage = new LoginPage(driver, Seconds.FIVE_SECONDS.getValue(),true,loginPageModel);
            loginPage.fillLogin();
        } catch (Exception exception) {
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }

    }

    @Then("Accedi de manera correcta al aplicativo")
    public void accediDeManeraCorrectaAlAplicativo() {
        Assertions.assertEquals("Accounts Overview", loginPage.isLoginDone());
    }
    // Segundo Escenario
    @Given("voy a iniciar sesion")
    public void voy_a_iniciar_sesion() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();
        } catch (Exception exception) {
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);

        }

    }
    @When("ingreso credenciales no validas Username {string} y Password {string}")
    public void ingreso_credenciales_no_validas_username_y_password(String username, String password) {
        try {
            loginPageModel = new LoginPageModel();
            loginPageModel.setUsername(username);
            loginPageModel.setPassword(password);
            loginPage = new LoginPage(driver, Seconds.FIVE_SECONDS.getValue(),true,loginPageModel);
            loginPage.fillLogin();
        } catch (Exception exception) {
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }
    @Then("no puedo ingresar al sistema")
    public void no_puedo_ingresar_al_sistema() {
        Assertions.assertEquals("The username and password could not be verified.", loginPage.isNotLogin());

    }



}
