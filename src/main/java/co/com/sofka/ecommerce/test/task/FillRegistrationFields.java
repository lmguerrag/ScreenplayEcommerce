package co.com.sofka.ecommerce.test.task;

import co.com.sofka.ecommerce.test.ui.CreateAccountPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class FillRegistrationFields implements Task {

    private String firstName;
    private String lastName;
    private String password;
    private int day;
    private int month;
    private int year;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String information;
    private String homePhone;
    private String mobilePhone;
    private String alias;

    public FillRegistrationFields(String firstName, String lastName, String password, int day, int month,
                                  int year, String company, String address1, String address2, String city,
                                  String state, String postalCode, String country, String information, String homePhone,
                                  String mobilePhone, String alias){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.day = day;
        this.month = month;
        this.year = year;
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.information = information;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.alias = alias;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CreateAccountPage.RADIO_MR_BTN),
                Enter.theValue(firstName).into(CreateAccountPage.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(CreateAccountPage.LAST_NAME_FIELD),
                Enter.theValue(password).into(CreateAccountPage.PASSWORD_FIELD),
                SelectFromOptions.byValue(String.valueOf(day)).from(CreateAccountPage.DAYS_DROPDOWN),
                SelectFromOptions.byValue(String.valueOf(month)).from(CreateAccountPage.MONTHS_DROPDOWN),
                SelectFromOptions.byValue(String.valueOf(year)).from(CreateAccountPage.YEARS_DROPDOWN),
                Enter.theValue(company).into(CreateAccountPage.COMPANY_FIELD),
                Enter.theValue(address1).into(CreateAccountPage.ADDRESS_1_FIELD),
                Enter.theValue(address2).into(CreateAccountPage.ADDRESS_2_FIELD),
                Enter.theValue(city).into(CreateAccountPage.CITY_FIELD),
                SelectFromOptions.byVisibleText(state).from(CreateAccountPage.STATE_DROPDOWN),
                Enter.theValue(postalCode).into(CreateAccountPage.POSTAL_CODE_FIELD),
                SelectFromOptions.byVisibleText(country).from(CreateAccountPage.COUNTRY_DROPDOWN),
                Enter.theValue(information).into(CreateAccountPage.INFORMATION_FIELD),
                Enter.theValue(homePhone).into(CreateAccountPage.HOME_PHONE_FIELD),
                Enter.theValue(mobilePhone).into(CreateAccountPage.MOBILE_PHONE_FIELD),
                Clear.field(CreateAccountPage.ALIAS_FIELD),
                Enter.theValue(alias).into(CreateAccountPage.ALIAS_FIELD),
                Click.on(CreateAccountPage.REGISTER_BTN)
        );

    }

    public static FillRegistrationFields with(String firstName, String lastName, String password, int day, int month,
                                              int year, String company, String address1, String address2, String city,
                                              String state, String postalCode, String country, String information,
                                              String homePhone, String mobilePhone, String alias){
        return Tasks.instrumented(FillRegistrationFields.class, firstName, lastName, password, day, month, year, company,
                address1, address2, city, state, postalCode, country, information, homePhone, mobilePhone, alias);
    }
}
