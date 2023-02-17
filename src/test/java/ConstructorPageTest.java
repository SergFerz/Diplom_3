import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorPageTest extends BaseTest {

    @Test
    @DisplayName("Успешный переход к разделу Булки блока Конструктор")
    public void successfulTransitionToTheBunsSectionConstructorTestOK() {
        mainPage.openPage();                                //открыть главную страницу
        mainPage.clickIngredientsButton();                  //переход к разделу "Начинки"
        Assert.assertTrue(mainPage.clickBunsButton().contains("current")); //переход к разделу "Булки" и проверка смены типа раздела на "current"
    }

    @Test
    @DisplayName("Успешный переход к разделу Начинки блока Конструктор")
    public void successfulTransitionToTheIngredientsSectionConstructorTestOK() {
        mainPage.openPage();                                //открыть главную страницу
        Assert.assertTrue(mainPage.clickIngredientsButton().contains("current")); //переход к разделу "Начинки" и проверка смены типа раздела на "current"
    }

    @Test
    @DisplayName("Успешный переход к разделу Соусы блока Конструктор")
    public void successfulTransitionToTheSaucesSectionConstructorTestOK() {
        mainPage.openPage();                                //открыть главную страницу
        Assert.assertTrue(mainPage.clickSaucesButton().contains("current")); //переход к разделу "Соусы" и проверка смены типа раздела на "current"
    }
}
