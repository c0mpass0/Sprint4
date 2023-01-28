import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import ru.praktikum.CreateOrderPage;
import ru.praktikum.MainPage;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static ru.praktikum.MainPage.BOTTOM_ORDER_BUTTON;
import static ru.praktikum.MainPage.TOP_ORDER_BUTTON;

@RunWith(Parameterized.class)
public class CreateOrderThroughDifferentButtonsTest {
    private static WebDriver driver;
    private final String orderButtonXpath;

    public CreateOrderThroughDifferentButtonsTest(String orderButtonXpath){
        this.orderButtonXpath = orderButtonXpath;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSumData() {
        return new Object[][] {
                { TOP_ORDER_BUTTON},
                { BOTTOM_ORDER_BUTTON},
        };
    }

    @Before
    public void setUp(){
        driver = new SafariDriver();
    }

    @Test
    public void createOrderThroughDifferentButtons(){
        MainPage page = new MainPage(driver);

        // Use for Safari browser
        driver.manage().window().maximize();
        page.open();

        WebElement orderButton = driver.findElement(By.xpath(orderButtonXpath));
        page.scrollToElement(orderButton);
        orderButton.click();

        CreateOrderPage order = new CreateOrderPage(driver);

        order.fillPersonData("Тест", "Тестовый", "Тыры-Пыры", "Черкизовская", "12345678900");
        order.nextPage();
        order.fillRentDateByToday();
        order.fillRentTerm();
        order.submitOrderPopUp();
        order.submitOrderPopUpYes();
    }

    @After
    public void cleanUp(){
        driver.quit();
    }

}
