package CalculatorApp;

import lt.techin.CalculatorAppPage;
import lt.techin.IndexPage;
import lt.techin.RegisterPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorAppTest extends BaseTest{

    @Test
    void PositiveUserRegisterTest() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickRegisterPage();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterInputUsername("Testas2");
        registerPage.enterInputPassword("Test");
        registerPage.enterInputPasswordConfirm("Test");
        registerPage.clickButtonSubmit();

        assertTrue(registerPage.getUsername().equals("Testas2"));
    }

    @Test
    void NegativeUserRegisterTest() {

        String errorMessage = "Įvesti slaptažodžiai nesutampa";

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickRegisterPage();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterInputUsername("Testa");
        registerPage.enterInputPassword("Test");
        registerPage.enterInputPasswordConfirm("Tes");
        registerPage.clickButtonSubmit();

        assertTrue(registerPage.getPasswordConfirmTexts().contains(errorMessage));
    }

    @Test
    void PositiveUserLoginTest() {

        IndexPage indexPage = new IndexPage(driver);

        indexPage.enterUsername("Testas2");
        indexPage.enterPassword("Test");
        indexPage.clickButtonSubmit();

        assertTrue(indexPage.getUsername().equals("Logout, Testas2"));
    }

    @Test
    void NegativeUserLoginTest() {

        IndexPage indexPage = new IndexPage(driver);

        indexPage.enterUsername("Testas2");
        indexPage.enterPassword("Tes");
        indexPage.clickButtonSubmit();

        assertTrue(indexPage.getErrorMessage().contains("neteisingi"));
    }

    @Test
    void PositiveNewRecordInputTest() {

        IndexPage indexPage = new IndexPage(driver);

        indexPage.enterUsername("Testas2");
        indexPage.enterPassword("Test");
        indexPage.clickButtonSubmit();

        CalculatorAppPage calculatorAppPage = new CalculatorAppPage(driver);

        calculatorAppPage.setInputNumber1("5");
        calculatorAppPage.setInputNumber2("10");
        calculatorAppPage.setMinusFunction();
        calculatorAppPage.clickButtonSubmit();

        System.out.println(calculatorAppPage.getUrl());
        assertThat(calculatorAppPage.getUrl()).endsWith("/skaiciuoti");

//        assertTrue(calculatorAppPage.getUrl().equals("http://localhost:8080/skaiciuoti"));
    }

    @Test
    void NegativeNewRecordInputTest() {

        IndexPage indexPage = new IndexPage(driver);

        indexPage.enterUsername("Testas2");
        indexPage.enterPassword("Test");
        indexPage.clickButtonSubmit();

        CalculatorAppPage calculatorAppPage = new CalculatorAppPage(driver);

        calculatorAppPage.setInputNumber1("1");
        calculatorAppPage.setInputNumber2("-1");
        calculatorAppPage.setMinusFunction();
        calculatorAppPage.clickButtonSubmit();

        assertTrue(calculatorAppPage.getValidationText().contains("Validacijos klaida"));
    }

    @Test
    void PositiveUserLogOutTest() {

        String message = "Sėkmingai atsijungėte";
        IndexPage indexPage = new IndexPage(driver);

        indexPage.enterUsername("Testas2");
        indexPage.enterPassword("Test");
        indexPage.clickButtonSubmit();

        CalculatorAppPage calculatorAppPage = new CalculatorAppPage(driver);
        calculatorAppPage.clickButtonLogOut();

        assertTrue(calculatorAppPage.getLogOutMessage().equals(message));
    }

}
