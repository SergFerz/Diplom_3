import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import user.User;

public class BaseTest {

    protected WebDriver driver;
    protected MainPage mainPage;
    protected AuthorizationPage authorizationPage;
    protected RegistrationPage registrationPage;
    protected RecoverPasswordPage recoverPasswordPage;
    protected MainPage personalAccountButton;
    protected ProfilePage personalAccountPage;
    protected User user;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        authorizationPage = new AuthorizationPage(driver);
        registrationPage = new RegistrationPage(driver);
        personalAccountPage = new ProfilePage(driver);
        personalAccountButton = new MainPage(driver);
        recoverPasswordPage = new RecoverPasswordPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void registerUser() {    //регистрация пользователя
        user = User.getRandomUser();                                        //создать пользователя
        mainPage.openPage();                                                //открыть главную страницу
        mainPage.clickPersonalAccountButton();                              //вход в "Личный кабинет"
        authorizationPage.clickRegistrationButton();                        //переход по ссылке "Зарегистрироваться"
        registrationPage.userRegistration(user);                            //регистрация пользователя
    }
}
