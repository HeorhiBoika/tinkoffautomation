package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSettings {

    public static WebDriver chrome() {
        //TODO: Use separate class for properties
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        return new ChromeDriver(options);
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
