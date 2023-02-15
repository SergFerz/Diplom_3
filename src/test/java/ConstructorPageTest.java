import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstructorPageTest extends BaseTest {

    @Test
    @DisplayName("Успешный переход к разделу Булки блока Конструктор")
    public void successfulTransitionToTheBunsSectionConstructorTestOK() {
        mainPage.openPage();                                //открыть главную страницу
        mainPage.clickIngredientsButton();                  //переход к разделу "Начинки"
        mainPage.clickBunsButton();                         //переход к разделу "Булки"
        mainPage.clickCraterBurger();                       //выбрать "Краторный бургер"
        assertEquals("Детали ингредиента", mainPage.getWindowDetailIngredients());
        assertEquals("Детали ингредиента\n" +
                "Краторная булка N-200i\n" +
                "Калории,ккал\n" +
                "420\n" +
                "Белки, г\n" +
                "53\n" +
                "Жиры, г\n" +
                "24\n" +
                "Углеводы, г\n" +
                "80", mainPage.getTextWindowCraterBurger());
    }

    @Test
    @DisplayName("Успешный переход к разделу Начинки блока Конструктор")
    public void successfulTransitionToTheIngredientsSectionConstructorTestOK() {
        mainPage.openPage();                                //открыть главную страницу
        mainPage.clickIngredientsButton();                  //переход к разделу "Начинки"
        mainPage.clickIngredientsBeef();                    //выбрать "Говяжий метеорит (отбивная)"
        assertEquals("Детали ингредиента", mainPage.getWindowDetailIngredients());
        assertEquals("Детали ингредиента\n" +
                "Говяжий метеорит (отбивная)\n" +
                "Калории,ккал\n" +
                "2674\n" +
                "Белки, г\n" +
                "300\n" +
                "Жиры, г\n" +
                "800\n" +
                "Углеводы, г\n" +
                "800", mainPage.getTextWindowIngredientsBeef());
    }

    @Test
    @DisplayName("Успешный переход к разделу Соусы блока Конструктор")
    public void successfulTransitionToTheSaucesSectionConstructorTestOK() {
        mainPage.openPage();                                //открыть главную страницу
        mainPage.clickSaucesButton();                       //переход к разделу "Соусы"
        mainPage.clickSauceTradition();                     //выбрать "Соус традиционный галактический"
        assertEquals("Детали ингредиента", mainPage.getWindowDetailIngredients());
        assertEquals("Детали ингредиента\n" +
                "Соус традиционный галактический\n" +
                "Калории,ккал\n" +
                "99\n" +
                "Белки, г\n" +
                "42\n" +
                "Жиры, г\n" +
                "24\n" +
                "Углеводы, г\n" +
                "42", mainPage.getTextWindowSauceTradition());
    }
}
