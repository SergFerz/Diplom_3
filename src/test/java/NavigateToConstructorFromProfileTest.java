import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NavigateToConstructorFromProfileTest extends BaseTest {
    @Before
    public void init() {
        registerUser();
    }

    @Test
    @DisplayName("Успешный переход в Конструктор из Личного кабинета для авторизованного пользователя")
    public void successfulGoConstructorFromProfileAuthorizedUserTest() {
        mainPage.openPage();                                                //открыть главную страницу
        mainPage.clickLogInAccountButton();                                 //переход на страницу входа в аккаунт
        authorizationPage.loginToUserAccount(user);                         //вход в аккаунт пользователя
        mainPage.clickPersonalAccountButton();                              //вход в "Личный кабинет"
        personalAccountPage.clickDesignerButton();                          //переход в Конструктор
        assertTrue("Соберите бургер", mainPage.waitAssembleBurgerField());
    }
}
