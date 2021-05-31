package co.com.sofka.ecommerce.test.task;

import co.com.sofka.ecommerce.test.ui.AuthenticationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class EnterEmail implements Task {

    private String email;

    public EnterEmail(String email){
        this.email = email;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(AuthenticationPage.EMAIL_CREATE_FIELD),
                Click.on(AuthenticationPage.CREATE_ACCOUNT_BTN)
        );
    }

    public static EnterEmail execute(String email){
        return Tasks.instrumented(EnterEmail.class, email);
    }
}
