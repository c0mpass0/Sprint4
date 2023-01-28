import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import ru.praktikum.CreateOrderPage;
import ru.praktikum.MainPage;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class CreateOrderThroughDifferentButtonsTest {
    private static WebDriver driver;
    /* public static final WebElement TOP_ORDER_BUTTON = driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g']"));
    public static final WebElement BOTTOM_ORDER_BUTTON = driver.findElement(By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button"));
*/

    private final WebElement orderButton;

    public CreateOrderThroughDifferentButtonsTest(WebElement orderButton){
        this.orderButton = orderButton;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSumData() {
        return new Object[][] {
                { driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g']"))},
                { driver.findElement(By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button"))},
        };
    }

    @Before
    public void setUp(){
        driver = new SafariDriver();
    }

    @Test
    public void createOrderThroughBottomButton(){
        MainPage page = new MainPage(driver);

        // Use for Safari browser
        driver.manage().window().maximize();

        page.open();
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
