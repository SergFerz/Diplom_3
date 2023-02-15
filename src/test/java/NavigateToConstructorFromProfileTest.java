import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import user.User;

import static org.junit.Assert.*;

public class NavigateToConstructorFromProfileTest extends BaseTest {
    @Before //регистрация пользователя
    public void registrationUser() {
        user = User.getRandomUser();                                        //создать пользователя
        mainPage.openPage();                                                //открыть главную страницу
        mainPage.clickPersonalAccountButton();                              //вход в "Личный кабинет"
        authorizationPage.clickRegistrationButton();                        //переход по ссылке "Зарегистрироваться"
        registrationPage.userRegistration(user);                            //регистрация пользователя
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
