package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final String mainPageUrl = "https://stellarburgers.nomoreparties.site/";

    private final By designerButton = By.xpath(".//a[(@class = 'AppHeader_header__link__3D_hX AppHeader_header__link_active__1IkJo') and (@href='/')]"); //кнопка "Конструктор"
    private final By orderFeedButton = By.xpath(".//a[(@class = 'AppHeader_header__link__3D_hX') and (@href='/feed')]"); //кнопка "Лента заказов"
    private final By personalAccountButton = By.xpath(".//a[(@class = 'AppHeader_header__link__3D_hX') and (@href='/account')]"); //кнопка "Личный Кабинет"
    private final By assembleBurgerField = By.xpath(".//h1[@class = 'text text_type_main-large mb-5 mt-10']"); //поле "Соберите бургер"
    private final By logInAccountButton = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']"); //кнопка "Войти в аккаунт"
    private final By bunsButton = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Булки']/parent::div"); //кнопка "Булки"
    private final By saucesButton = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Соусы']/parent::div"); //кнопка ""Соусы"
    private final By ingredientsButton = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Начинки']/parent::div"); //кнопка "Начинки"
    private final By orderButton = By.xpath(".//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button");//кнопка "Оформить заказ"
    private final By windowDetailIngredients = By.xpath(".//h2[@class='Modal_modal__title_modified__3Hjkd Modal_modal__title__2L34m text text_type_main-large pl-10' and text()='Детали ингредиента']"); //Окно и надпись "Детали ингредиента"
    private final By craterBurger = By.xpath(".//p[@class = 'BurgerIngredient_ingredient__text__yp3dH' and text()='Краторная булка N-200i']/..");//выбрать "Краторный бургер"
    private final By textWindowCraterBurger = By.xpath(".//p[@class = 'text text_type_main-medium mb-8' and text()='Краторная булка N-200i']/..");//Текст в окне "Краторный бургер"
    private final By sauceTradition = By.xpath(".//p[@class = 'BurgerIngredient_ingredient__text__yp3dH' and text()='Соус традиционный галактический']/..");//выбрать "Соус традиционный галактический"
    private final By textWindowSauceTradition = By.xpath(".//p[@class = 'text text_type_main-medium mb-8' and text()='Соус традиционный галактический']/..");//Текст в окне "Соус традиционный галактический"
    private final By ingredientsBeef = By.xpath(".//p[@class = 'BurgerIngredient_ingredient__text__yp3dH' and text()='Говяжий метеорит (отбивная)']/..");//выбрать "Говяжий метеорит (отбивная)"
    private final By textWindowIngredientsBeef = By.xpath(".//p[@class = 'text text_type_main-medium mb-8' and text()='Говяжий метеорит (отбивная)']/..");//Текст в окне "Говяжий метеорит (отбивная)"

    //открытие страницы тестирования
    public void openPage() {
        driver.get(mainPageUrl);
    }

    //ожидание видимости элемента
    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    //нажать кнопку "Конструктор"
    public void clickDesignerButton() {
        driver.findElement(designerButton).click();
    }

    //нажать кнопку "Лента заказов"
    public void clickOrderFeedButton() {
        driver.findElement(orderFeedButton).click();
    }

    //нажать кнопку "Личный Кабинет"
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    //ожидание загрузки поля "Соберите бургер"
    public boolean waitAssembleBurgerField() {
        String text = driver.findElement(assembleBurgerField).getText();
        return (text.equals("Соберите бургер"));
    }

    //нажать кнопку  "Войти в аккаунт"
    public void clickLogInAccountButton() {
        driver.findElement(logInAccountButton).click();
    }

    //выбрать раздел "Булки"
    public String clickBunsButton() {
        driver.findElement(bunsButton).click();
        return driver.findElement(bunsButton).getAttribute("class");
    }

    //выбрать раздел "Соусы"
    public String clickSaucesButton() {
        driver.findElement(saucesButton).click();
        return driver.findElement(saucesButton).getAttribute("class");
    }

    //выбрать раздел "Начинки"
    public String  clickIngredientsButton() {
        driver.findElement(ingredientsButton).click();
        return driver.findElement(ingredientsButton).getAttribute("class");
    }

    //ожидание появления кнопки "Оформить заказ"
    public boolean waitOrderButton() {
        wait(orderButton);
        String text = driver.findElement(orderButton).getText();
        return (text.equals("Оформить заказ"));
    }

    //Получение текста "Детали ингредиента"
    public String getWindowDetailIngredients() {
        String detail = driver.findElement(windowDetailIngredients).getText();
        return detail;
    }

    //нажать на Краторный бургер
    public void clickCraterBurger() {
        driver.findElement(craterBurger).click();
    }

    //Получение текста в окне "Краторный бургер"
    public String getTextWindowCraterBurger() {
        String burger = driver.findElement(textWindowCraterBurger).getText();
        return burger;
    }

    //нажать на соус "Соус традиционный галактический"
    public void clickSauceTradition() {
        driver.findElement(sauceTradition).click();
    }

    //Получение текста в окне "Соус традиционный галактический"
    public String getTextWindowSauceTradition() {
        String sauce = driver.findElement(textWindowSauceTradition).getText();
        return sauce;
    }

    //нажать на начинку "Говяжий метеорит (отбивная)"
    public void clickIngredientsBeef() {
        driver.findElement(ingredientsBeef).click();
    }

    //Получение текста в окне "Говяжий метеорит (отбивная)"
    public String getTextWindowIngredientsBeef() {
        String ingredient = driver.findElement(textWindowIngredientsBeef).getText();
        return ingredient;
    }
}