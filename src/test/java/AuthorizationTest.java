import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import user.User;

import static org.junit.Assert.assertTrue;

public class AuthorizationTest extends BaseTest {

    @Before //регистрация пользователя
    public void registrationUser() {
        user = User.getRandomUser();                                        //создать пользователя
        mainPage.openPage();                                                //открыть главную страницу
        mainPage.clickPersonalAccountButton();                              //вход в "Личный кабинет"
        authorizationPage.clickRegistrationButton();                        //переход по ссылке "Зарегистрироваться"
        registrationPage.userRegistration(user);                            //регистрация пользователя
    }

    @Test
    @DisplayName("Успешный вход пользователя по кнопке \"Войти в аккаунт\"")
    public void successfulUserLoginWithButtonLoginToAccountTest() {
        mainPage.openPage();                                                //открыть главную страницу
        mainPage.clickLogInAccountButton();                                 //переход на страницу входа в аккаунт
        authorizationPage.loginToUserAccount(user);                         //вход в аккаунт пользователя
        assertTrue("Оформить заказ", mainPage.waitOrderButton());
    }

    @Test
    @DisplayName("Успешный вход пользователя через кнопку \"Личный Кабинет\"")
    public void successfulUserLoginWithButtonPersonalAccountTest() {
        mainPage.openPage();                                                //открыть главную страницу
        mainPage.clickPersonalAccountButton();                              //вход в "Личный кабинет"
        authorizationPage.loginToUserAccount(user);                         //вход в аккаунт пользователя
        assertTrue("Оформить заказ", mainPage.waitOrderButton());
    }

    @Test
    @DisplayName("Успешный вход пользователя через кнопку в форме регистрации")
    public void successfulUserLoginViaTheButtonRegistrationForm() {
        mainPage.openPage();                                                //открыть главную страницу
        mainPage.clickPersonalAccountButton();                              //вход в "Личный кабинет"
        authorizationPage.clickRegistrationButton();                        //переход на страницу регистрации
        registrationPage.clickLoginButton();                                //переход по ссылке "Войти"
        authorizationPage.loginToUserAccount(user);                         //вход в аккаунт пользователя
        assertTrue("Оформить заказ", mainPage.waitOrderButton());
    }

    @Test
    @DisplayName("Успешный вход пользователя через кнопку в форме восстановления пароля")
    public void successfulUserLoginViaTheButtonPasswordRecoveryFormOnForgotPasswordPageTestOK() {
        mainPage.openPage();                                                //открыть главную страницу
        mainPage.clickPersonalAccountButton();                              //вход в "Личный кабинет"
        authorizationPage.clickRecoverPasswordButton();                     //переход на страницу восстановления пароля
        recoverPasswordPage.clickLoginButton();                             //переход по ссылке "Войти"
        authorizationPage.loginToUserAccount(user);                         //вход в аккаунт пользователя
        assertTrue("Оформить заказ", mainPage.waitOrderButton());
    }
}