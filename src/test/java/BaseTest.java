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
        //driver = new ChromeDriver(new ChromeOptions().setBinary("C:\\Users\\KiLaTiV\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"));
        //driver.manage().window().maximize();

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
}
