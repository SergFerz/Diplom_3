package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private static String profileURL = "https://stellarburgers.nomoreparties.site/account/profile";
    private final By logOutPersonalAccountButton = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']"); //Кнопка "Выход"
    private final By designerButton = By.xpath(".//a[(@class='AppHeader_header__link__3D_hX') and (@href='/')]"); //кнопка "Конструктор"
    private final By nameField = By.xpath(".//input[(@class='text input__textfield text_type_main-default input__textfield-disabled') and (@name='Name') and (@type='text')]"); //поле "Имя"
    private final By emailField = By.xpath(".//input[(@class='text input__textfield text_type_main-default input__textfield-disabled') and (@name='name') and (@type='text')]"); //поле "Email"
    private final By passwordField = By.xpath(".//input[(@name='name') and (@type='password')]"); //поле "Password"
    private final By personalAccountInformation = By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']"); //сообщение "В этом разделе вы можете изменить свои персональные данные"

    //ожидание видимости элемента
    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    //получить url страницы личного кабинета
    public String getProfileURL() {
        return profileURL;
    }

    //получить значение поля "Имя"
    public String getValueNameField() {
        String text = driver.findElement(nameField).getAttribute("disabled value");
        return text;
    }

    //получить значение поля "Логин"
    public String getValueEmailField() {
        String text = driver.findElement(emailField).getAttribute("disabled value");
        return text;
    }

    //получить значение поля "Пароль"
    public String getValuePasswordField() {
        String text = driver.findElement(passwordField).getAttribute("disabled value");
        return text;
    }

    //ожидание загрузки "Личного кабинета" с текстом "В этом разделе вы можете изменить свои персональные данные"
    public void waitPersonalAccountToLoad() {
        wait(personalAccountInformation);
    }

    //получить уведомление "В этом разделе вы можете изменить свои персональные данные"
    public String getPersonalAccountInformation() {
        wait(personalAccountInformation);
        return driver.findElement(personalAccountInformation).getText();
    }

    //нажатие кнопки "Выход"
    public void clickLogOutPersonalAccountButton() {
        wait(logOutPersonalAccountButton);
        driver.findElement(logOutPersonalAccountButton).click();
    }

    //нажатие кнопки "Конструктор"
    public void clickDesignerButton() {
        wait(designerButton);
        driver.findElement(designerButton).click();
    }
}