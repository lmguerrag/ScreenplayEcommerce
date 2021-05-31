package screenplay.steps;

import co.com.sofka.ecommerce.test.questions.CompletedSignUp;
import co.com.sofka.ecommerce.test.task.EnterEmail;
import co.com.sofka.ecommerce.test.task.FillRegistrationFields;
import co.com.sofka.ecommerce.test.task.GoToAuthPage;
import co.com.sofka.ecommerce.test.task.OpenTheBrowser;
import co.com.sofka.ecommerce.test.ui.HomePage;
import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class SignUpStep {

    private Actor actor;
    private HomePage homePage;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("Usuario");
    }

    @Given("un usuario quiere registrarse")
    public void unUsuarioQuiereRegistrarse() {
        actor.wasAbleTo(OpenTheBrowser.on(homePage));
    }

    @When("se registra exitosamente")
    public void seRegistraExitosamente() {
        Faker faker = new Faker();

        actor.attemptsTo(GoToAuthPage.go());
        actor.attemptsTo(EnterEmail.execute(faker.internet().emailAddress()));
        actor.attemptsTo(
                FillRegistrationFields.with(faker.name().firstName(), faker.name().lastName(),
                        faker.pokemon().name(), faker.number().numberBetween(1, 28), faker.number().numberBetween(1, 12),
                        faker.number().numberBetween(1900, 2021), faker.company().name(), faker.address().fullAddress(),
                        faker.address().secondaryAddress(), faker.address().city(), faker.address().state(),
                        faker.number().digits(5), "United States", faker.zelda().character(),
                        faker.number().digits(10), faker.number().digits(7), faker.address().cityName())
        );
    }

    @Then("podra visualizar un mensaje de bienvenida")
    public void podraVisualizarUnMensajeDeBienvenida() {
        actor.should(
                seeThat(
                        CompletedSignUp.ok(),
                        is(Matchers.equalTo("Welcome to your account. Here you can manage all of your personal information and orders."))
                )
        );
    }
}
