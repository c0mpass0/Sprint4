import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.CreateOrderPage;
import ru.praktikum.MainPage;

public class CreateOrderTests {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void createOrderThroughTopButton(){
        MainPage page = new MainPage(driver);

        page.open();
        page.createOrderTop();

        CreateOrderPage order = new CreateOrderPage(driver);

        order.fillPersonData("Тест", "Тестовый", "Тыры-Пыры", "Черкизовская", "12345678900");
        order.nextPage();
        order.fillRentDate("26.02.2022");
        order.fillRentTerm();
        order.submitOrderPopUp();
        order.submitOrderPopUpYes();
    }

    @Test
    public void createOrderThroughBottomButton(){
        MainPage page = new MainPage(driver);

        page.open();

        WebElement bottomOrderButton = driver.findElement(By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button"));

        page.scrollToElement(bottomOrderButton);
        page.createOrderBottom();

        CreateOrderPage order = new CreateOrderPage(driver);

        order.fillPersonData("Тест", "Тестовый", "Тыры-Пыры", "Черкизовская", "12345678900");
        order.nextPage();
        order.fillRentDate("26.02.2022");
        order.fillRentTerm();
        order.submitOrderPopUp();
        order.submitOrderPopUpYes();
    }

    @After
    public void cleanUp(){
        driver.quit();
    }

}
