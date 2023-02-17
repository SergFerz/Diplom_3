package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecoverPasswordPage {

    private WebDriver driver;

    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginButton = By.xpath(".//a[(@class='Auth_link__1fOlj') and (@href='/login')]"); //кнопка "Войти"
    private final By personalAccountButton = By.xpath(".//a[(@class='AppHeader_header__link__3D_hX') and (@href='/account')]"); //Кнопка "Личный Кабинет"

    //ожидание видимости элемента
    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    //нажать кнопку "Войти"
    public void clickLoginButton() {
        wait(loginButton);
        driver.findElement(loginButton).click();
    }

    //нажать кнопку "Личный Кабинет"
    public void clickPersonalAccountButton() {
        wait(personalAccountButton);
        driver.findElement(personalAccountButton).click();
    }
}