import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.MainPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class WebTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void checkImportantQuestionsText(){

        MainPage page = new MainPage(driver);

        page.open();
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.id("accordion__heading-0")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-0")));
        String listText = driver.findElement(By.id("accordion__panel-0")).getText();
        assertEquals("Текст не совпадает","Сутки — 400 рублей. Оплата курьеру — наличными или картой.", listText);

    }

    @After
    public void cleanUp(){
        driver.quit();
    }
}
