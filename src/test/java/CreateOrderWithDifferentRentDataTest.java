import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.CreateOrderPage;
import ru.praktikum.MainPage;


import static ru.praktikum.CreateOrderPage.*;

@RunWith(Parameterized.class)
public class CreateOrderWithDifferentRentDataTest {
    private static WebDriver driver;
    private final String rentDate;
    private final String term;


    public CreateOrderWithDifferentRentDataTest(String rentDate, String term){
        this.rentDate = rentDate;
        this.term = term;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSumData() {
        return new Object[][] {
                { TODAY_DATE, "сутки" },
                { TOMORROW_DATE, "двое суток"},
                { YESTERDAY_DATE, "трое суток"},
        };
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void createOrderWithDifferentRentData(){
        MainPage page = new MainPage(driver);

        // Use for Safari browser
        //driver.manage().window().maximize();
        page.open();
        page.createOrderTop();

        CreateOrderPage order = new CreateOrderPage(driver);

        order.fillPersonData("Петр", "Васильев", "Москва", "Черкизовская", "89994568877");
        order.nextPage();
        order.fillRentDate(rentDate);
        order.fillRentTerm(term);
        order.submitOrderPopUp();
        order.submitOrderPopUpYes();
    }

    @After
    public void cleanUp(){
        driver.quit();
    }

}
