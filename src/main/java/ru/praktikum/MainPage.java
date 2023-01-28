package ru.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru";
    public static final String TOP_ORDER_BUTTON = ".//button[@class='Button_Button__ra12g']";
    public static final String BOTTOM_ORDER_BUTTON = ".//div[@class='Home_FinishButton__1_cWm']/button";

    private final WebDriver driver;


    public MainPage(WebDriver driver){
        this.driver = driver;
    }


    public void open(){
        driver.get(PAGE_URL);
    }

    public void createOrderTop() {
        driver.findElement(By.xpath(TOP_ORDER_BUTTON)).click();
    }

    //Метод на всякий случай
    public void createOrderBottom(){
        driver.findElement(By.xpath(BOTTOM_ORDER_BUTTON)).click();
    }

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
