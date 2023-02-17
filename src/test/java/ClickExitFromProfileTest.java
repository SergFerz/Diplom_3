import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ClickExitFromProfileTest extends BaseTest {
    @Before
    public void registrationUser() {
        registerUser();
    }

    @Test
    @DisplayName("Успешный Выход из Личного кабинета для авторизованного пользователя")
    public void successfulExitFromProfileForAuthorizedUserTest() {
        mainPage.openPage();                                                //открыть главную страницу
        mainPage.clickLogInAccountButton();                                 //переход на страницу входа в аккаунт
        authorizationPage.loginToUserAccount(user);                         //вход в аккаунт пользователя
        mainPage.clickPersonalAccountButton();                              //вход в "Личный кабинет"
        personalAccountPage.clickLogOutPersonalAccountButton();             //нажать "Выход"
        authorizationPage.waitAuthorizationPageToLoad();                    //ожидание загрузки страницы входа в аккаунт
        assertEquals(authorizationPage.getAuthorizationURL(), driver.getCurrentUrl());
    }
}
