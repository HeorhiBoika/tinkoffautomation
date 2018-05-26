package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSettings {

    public static WebDriver chrome() {
        //TODO: Use separate class for properties
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        return new ChromeDriver();
    }

    public static WebDriver firefox() {
        //TODO: Will be implemented letter
        return null;
    }

    public static WebDriver IE() {
        //TODO: Will be implemented letter
        return null;
    }
}
