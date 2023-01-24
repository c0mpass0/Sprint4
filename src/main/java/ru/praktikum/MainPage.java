package ru.praktikum;

import org.openqa.selenium.WebDriver;

public class MainPage {

    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru";
    private final WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(PAGE_URL);
    }
}
