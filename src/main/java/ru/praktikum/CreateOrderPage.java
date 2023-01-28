package ru.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateOrderPage {

    private final WebDriver driver;
    static Date todayDateRaw = new Date();
    static Date tomorrowDateRaw = new Date(todayDateRaw.getTime() + (1000 * 60 * 60 * 24));
    static Date yesterdayDateRaw = new Date(todayDateRaw.getTime() - (1000 * 60 * 60 * 24));
    static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
    public static final String TODAY_DATE = formatter.format(todayDateRaw);
    public static final String TOMORROW_DATE = formatter.format(tomorrowDateRaw);
    public static final String YESTERDAY_DATE = formatter.format(yesterdayDateRaw);

    public CreateOrderPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillPersonData(String name, String surname, String address, String subway, String phone){

        //Отчищаем и заполняем имя
        driver.findElement(By.xpath(".//input[@placeholder='* Имя']")).clear();
        driver.findElement(By.xpath(".//input[@placeholder='* Имя']")).sendKeys(name);

        //Отчищаем и заполняем фамилию
        driver.findElement(By.xpath(".//input[@placeholder='* Фамилия']")).clear();
        driver.findElement(By.xpath(".//input[@placeholder='* Фамилия']")).sendKeys(surname);

        //Отчищаем и заполняем адрес
        driver.findElement(By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']")).clear();
        driver.findElement(By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']")).sendKeys(address);

        //Отчищаем и заполняем метро
        driver.findElement(By.xpath(".//input[@placeholder='* Станция метро']")).clear();
        driver.findElement(By.xpath(".//input[@placeholder='* Станция метро']")).sendKeys(subway);
        driver.findElement(By.xpath(".//div[text()='"+ subway +"']")).click();

        //Отчищаем и заполняем телефон
        driver.findElement(By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']")).clear();
        driver.findElement(By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']")).sendKeys(phone);
    }

    public void nextPage(){
        driver.findElement(By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM")).click();
    }

    public void fillRentDate(String rentDate){
        driver.findElement(By.xpath(".//input[@placeholder='* Когда привезти самокат']")).clear();
        driver.findElement(By.xpath(".//input[@placeholder='* Когда привезти самокат']")).sendKeys(rentDate);
        driver.findElement(By.cssSelector("div.react-datepicker__day--selected")).click();
    }

    public void fillRentDateByToday(){
        driver.findElement(By.xpath(".//input[@placeholder='* Когда привезти самокат']")).clear();
        driver.findElement(By.xpath(".//input[@placeholder='* Когда привезти самокат']")).sendKeys(TODAY_DATE);
        driver.findElement(By.cssSelector("div.react-datepicker__day--selected")).click();
    }

    public void fillRentTerm(){
        driver.findElement(By.cssSelector("div.Dropdown-placeholder")).click();
        driver.findElement(By.xpath(".//div[text()='сутки']")).click();
    }

    public void fillRentTerm(String term){
        driver.findElement(By.cssSelector("div.Dropdown-placeholder")).click();
        driver.findElement(By.xpath(".//div[text()='"+ term +"']")).click();
    }

    public void submitOrderPopUp(){
        driver.findElement(By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']")).click();
    }

    public void submitOrderPopUpYes(){
        driver.findElement(By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']")).click();
    }

}
