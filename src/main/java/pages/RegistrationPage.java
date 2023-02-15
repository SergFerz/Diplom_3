package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import user.User;

import java.time.Duration;

public class RegistrationPage {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final String registrationURL = "https://stellarburgers.nomoreparties.site/register";
    public By nameField = By.xpath(".//fieldset[1]/div/div/input"); //поле "Имя"
    public By emailField = By.xpath(".//fieldset[2]/div/div/input"); //поле "Email"
    public By passwordField = By.xpath(".//fieldset[3]/div/div/input"); //поле "Пароль"
    public By registerButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']"); //кнопка "Зарегистрироваться"
    public By loginButton = By.xpath(".//a[(@class='Auth_link__1fOlj') and (@href='/login')]"); //кнопка "Войти"
    public By invalidPasswordMessage = By.xpath(".//p[text()='Некорректный пароль']"); //сообщение "Некорректный пароль"
    private By personalAccountButton = By.xpath(".//a[(@class = 'AppHeader_header__link__3D_hX') and (@href='/account')]"); //кнопка "Личный Кабинет"

    //ожидание видимости элемента
    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    //получение url страницы регистрации Registration Page
    public String getRegistrationUrl() {
        return registrationURL;
    }

    //заполнения поля "Имя"
    public void putNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    //заполнения поля "Email"
    public void putEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    //заполнения поля "Пароль"
    public void putPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    //нажатие кнопки "Зарегистрироваться"
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    //переход по ссылке "Войти"
    public void clickLoginButton() {
        wait(loginButton);
        driver.findElement(loginButton).click();
    }

    //получение сообщения "Некорректный пароль"
    public String getInvalidPasswordMessage() {
        return driver.findElement(invalidPasswordMessage).getText();
    }

    //нажатие кнопки "Личный Кабинет"
    public void clickPersonalAccountButton() {
        wait(personalAccountButton);
        driver.findElement(personalAccountButton).click();
    }

    //регистрация пользователя
    public void userRegistration(User user) {
        wait(registerButton);                      //ожидание видимости кнопки "Зарегистрироваться" (ожидание загрузки страницы регистрации)
        putNameField(user.getName());         //ввод имени пользователя
        putEmailField(user.getEmail());       //ввод email пользователя
        putPasswordField(user.getPassword()); //ввод пароля пользователя
        clickRegisterButton();                     //нажатие кнопки "Зарегистрироваться"
    }
}