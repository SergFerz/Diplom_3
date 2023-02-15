import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import user.User;

import static org.junit.Assert.assertEquals;

public class RegistrationPageTest extends BaseTest {

    @Test
    @DisplayName("Тест успешной регистрации пользователя")
    public void successfulUserRegistrationTest() {
        user = User.getRandomUser();                                //создать пользователя
        mainPage.openPage();                                        //открыть главную страницу
        mainPage.clickPersonalAccountButton();                      //вход в "Личный кабинет"
        authorizationPage.clickRegistrationButton();                //переход по ссылке "Зарегистрироваться"
        registrationPage.userRegistration(user);                    //регистрация пользователя
        registrationPage.clickRegisterButton();                     //Нажать кнопку "зарегистрироваться"
        authorizationPage.waitAuthorizationPageToLoad();            //ожидание загрузки страницы входа в аккаунт пользователя
        authorizationPage.loginToUserAccount(user);                 //войти под созданным клиентом
        mainPage.clickPersonalAccountButton();                      //вход в "Личный кабинет"
        personalAccountPage.waitPersonalAccountToLoad();            //ожидание загрузки "Личного кабинета" с надписью
        assertEquals("В этом разделе вы можете изменить свои персональные данные", personalAccountPage.getPersonalAccountInformation());
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля. Минимальный пароль — шесть символов.")
    public void nonSuccessfulUserRegistrationTest() {
        user = User.getRandomUserWithNonCorrectPassword();          //создать пользователя
        mainPage.openPage();                                        //открыть главную страницу
        mainPage.clickPersonalAccountButton();                      //вход в "Личный кабинет"
        authorizationPage.clickRegistrationButton();                //переход по ссылке "Зарегистрироваться"
        registrationPage.userRegistration(user);                    //регистрация пользователя
        assertEquals("Некорректный пароль", registrationPage.getInvalidPasswordMessage());
    }
}
