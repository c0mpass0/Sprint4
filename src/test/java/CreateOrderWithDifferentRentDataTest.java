import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import ru.praktikum.CreateOrderPage;
import ru.praktikum.MainPage;

import static ru.praktikum.src.Dates.*;
import static ru.praktikum.src.RentTerms.*;
import static ru.praktikum.src.ScooterTypes.*;
@RunWith(Parameterized.class)
public class CreateOrderWithDifferentRentDataTest {
    private static WebDriver driver;
    private final String rentDate;
    private final String term;
    private final String scooterType;
    private final String comment;


    public CreateOrderWithDifferentRentDataTest(String rentDate, String term, String scooterType, String comment){
        this.rentDate = rentDate;
        this.term = term;
        this.scooterType = scooterType;
        this.comment = comment;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSumData() {
        return new Object[][] {
                { TODAY_DATE, ONE_DAY, BLACK_SCOOTER, "test commentary" },
        };
    }

    @Before
    public void setUp(){
        driver = new SafariDriver();
    }

    @Test
    public void createOrderWithDifferentRentData(){
        MainPage page = new MainPage(driver);

        // Use for Safari browser
        driver.manage().window().maximize();
        page.open();
        page.createOrderTop();

        CreateOrderPage order = new CreateOrderPage(driver);

        order.fillPersonData("Петр", "Васильев", "Москва", "Черкизовская", "89994568877");
        order.nextPage();
        order.fillRentDate(rentDate);
        order.fillRentTerm(term);
        order.setScooterType(scooterType);
        order.setComment(comment);
        order.submitOrderPopUp();
        order.submitOrderPopUpYes();

        WebElement orderFinalPopup = driver.findElement(By.cssSelector("div.Order_ModalHeader__3FDaJ"));

        Assert.assertTrue("Окно с номером заказа не появилось", orderFinalPopup.isDisplayed());
    }

    @After
    public void cleanUp(){
        driver.quit();
    }

}
