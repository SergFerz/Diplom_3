import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import user.User;

import static org.junit.Assert.*;

public class ClickProfileTest extends BaseTest {

    @Test
    @DisplayName("Успешный переход в Личный кабинет с Главной страницы для авторизованного пользователя")
    public void successfulNavigationToProfileFromMainPageForAuthorizedUserTest() {
        user = User.getRandomUser();                                    //создать пользователя
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickPersonalAccountButton();                          //вход в "Личный кабинет"
        authorizationPage.clickRegistrationButton();                    //переход по ссылке "Зарегистрироваться"
        registrationPage.userRegistration(user);                        //регистрация пользователя
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickLogInAccountButton();                             //переход на страницу входа в аккаунт
        authorizationPage.loginToUserAccount(user);                     //вход в аккаунт пользователя
        mainPage.clickPersonalAccountButton();                          //вход в "Личный кабинет"
        assertEquals("В этом разделе вы можете изменить свои персональные данные", personalAccountPage.getPersonalAccountInformation());
    }

    @Test
    @DisplayName("Успешный переход в Личный кабинет со страницы Лента Заказов для авторизованного пользователя")
    public void successfulNavigationToProfileFromFeedOrderPageForAuthorizedUserTest() {
        user = User.getRandomUser();                                    //создать пользователя
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickPersonalAccountButton();                          //вход в "Личный кабинет"
        authorizationPage.clickRegistrationButton();                    //переход по ссылке "Зарегистрироваться"
        registrationPage.userRegistration(user);                        //регистрация пользователя
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickLogInAccountButton();                             //переход на страницу входа в аккаунт
        authorizationPage.loginToUserAccount(user);                     //вход в аккаунт пользователя
        mainPage.clickOrderFeedButton();                                //переход на страницу "Лента заказов"
        mainPage.clickPersonalAccountButton();                          //вход в "Личный кабинет"
        assertEquals("В этом разделе вы можете изменить свои персональные данные", personalAccountPage.getPersonalAccountInformation());
    }

    @Test
    @DisplayName("Не успешный переход в Личный кабинет с Главной страницы для неавторизованного пользователя")
    public void notSuccessfulNavigationToProfileOnMainPageNoAuthorizedUserTest() {
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickPersonalAccountButton();                          //вход в "Личный кабинет"
        assertNotEquals(personalAccountPage.getProfileURL(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Не успешный переход в Личный кабинет со страницы Лента Заказов для авторизованного пользователя")
    public void notSuccessfulNavigationToProfileOnFeedOrderPageNoAuthorizedUserTest() {
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickOrderFeedButton();                                //переход на страницу "Лента заказов"
        mainPage.clickPersonalAccountButton();                          //вход в "Личный кабинет"
        assertNotEquals(personalAccountPage.getProfileURL(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Не успешный переход в Личный кабинет со страницы Авторизации для неавторизованного пользователя")
    public void notSuccessfulNavigationToProfileOnAuthorizationPageNoAuthorizedUserTest() {
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickLogInAccountButton();                             //переход на страницу входа в аккаунт
        authorizationPage.clickPersonalAccountButton();                 //вход в "Личный кабинет"
        assertNotEquals(personalAccountPage.getProfileURL(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Не успешный переход в Личный кабинет со страницы Регистрации для неавторизованного пользователя")
    public void notSuccessfulNavigationToProfileOnRegistrationPageNoAuthorizedUserTest() {
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickLogInAccountButton();                             //переход на страницу входа в аккаунт
        authorizationPage.clickRegistrationButton();                    //переход на страницу регистрации
        registrationPage.clickPersonalAccountButton();                  //вход в "Личный кабинет"
        assertNotEquals( personalAccountPage.getProfileURL(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Не успешный переход в Личный кабинет со страницы Возобновления пароля для неавторизованного пользователя")
    public void notSuccessfulNavigationToProfileOnRecoverPasswordPageNoAuthorizedUserTest() {
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickLogInAccountButton();                             //переход на страницу входа в аккаунт
        authorizationPage.clickRecoverPasswordButton();                 //переход на страницу восстановления пароля
        recoverPasswordPage.clickPersonalAccountButton();               //вход в "Личный кабинет"
        assertNotEquals(personalAccountPage.getProfileURL(), driver.getCurrentUrl());
    }
}
