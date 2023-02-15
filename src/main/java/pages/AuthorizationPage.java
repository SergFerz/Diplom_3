package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import user.User;

import java.time.Duration;

public class AuthorizationPage {

    private WebDriver driver;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }


    private final String authorizationURL = "https://stellarburgers.nomoreparties.site/login";
    private final By emailField = By.xpath(".//input[(@name='name')]"); //поле "Email"
    private final By passwordField = By.xpath(".//input[(@name='Пароль')]");//поле "Пароль"
    private final By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']"); //кнопка "Войти"
    private final By registrationButton =  By.xpath(".//a[(@class='Auth_link__1fOlj') and (@href='/register')]"); //кнопка "Зарегистрироваться"
    private final By recoverPasswordButton =  By.xpath(".//a[(@class='Auth_link__1fOlj') and (@href='/forgot-password')]"); //кнопка "Восстановить пароль"
    private final By personalAccountButton = By.xpath(".//a[(@class='AppHeader_header__link__3D_hX') and (@href='/account')]"); //Кнопка "Личный Кабинет"

    //ожидание видимости элемента
    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    //получение url страницы входа в аккаунт
    public String getAuthorizationURL() {
        return authorizationURL;
    }

    //заполнить поле "Email"
    public void putEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    //заполнить поле "Пароль"
    public void putPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    //нажать кнопку "Вход"
    public void clickLoginButton() {
        wait(loginButton);
        driver.findElement(loginButton).click();
    }

    //Нажать "Зарегистрироваться"
    public void clickRegistrationButton() {
        wait(registrationButton);
        driver.findElement(registrationButton).click();
    }

    //Нажать "Восстановить пароль"
    public void clickRecoverPasswordButton() {
        wait(recoverPasswordButton);
        driver.findElement(recoverPasswordButton).click();
    }

    //нажать кнопку "Личный Кабинет"
    public void clickPersonalAccountButton() {
        wait(personalAccountButton);
        driver.findElement(personalAccountButton).click();
    }

    //ожидание загрузки страницы входа в аккаунт
    public void waitAuthorizationPageToLoad() {
        wait(recoverPasswordButton);
    }

    //вход в аккаунт
    public void loginToUserAccount(User user) {
        waitAuthorizationPageToLoad();           //ожидание загрузки страницы входа в аккаунт
        putEmailField(user.getEmail());         //ввод email пользователя
        putPasswordField(user.getPassword());   //ввод пароля пользователя
        clickLoginButton();                          //нажатие кнопки "Вход"
    }
}
