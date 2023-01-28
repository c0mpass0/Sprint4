import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.CreateOrderPage;
import ru.praktikum.MainPage;


@RunWith(Parameterized.class)
public class CreateOrderWithDifferentPersonalDataTest {
    private static WebDriver driver;
    private final String userName;
    private final String userSurname;
    private final String userAddress;
    private final String userSubway;
    private final String userPhone;


    public CreateOrderWithDifferentPersonalDataTest(String userName, String userSurname, String userAddress, String userSubway, String userPhone){
        this.userName = userName;
        this.userSurname = userSurname;
        this.userAddress = userAddress;
        this.userSubway = userSubway;
        this.userPhone = userPhone;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSumData() {
        return new Object[][] {
                { "Петр", "Васильев", "Москва", "Черкизовская", "89994568877"},
                { "Марья", "Васильева", "Хухры-мухры", "Славянский бульвар", "77886549998"},
        };
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void createOrderWithDifferentPersonalData(){
        MainPage page = new MainPage(driver);

        // Use for Safari browser
        //driver.manage().window().maximize();
        page.open();
        page.createOrderTop();

        CreateOrderPage order = new CreateOrderPage(driver);

        order.fillPersonData(userName, userSurname, userAddress, userSubway, userPhone);
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
