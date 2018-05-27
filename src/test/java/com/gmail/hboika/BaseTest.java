package com.gmail.hboika;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import utils.CustomProperties;
import utils.DataManager;
import utils.DriverFactory;
import utils.PropertyProvider;

public class BaseTest {
    protected DataManager dataManager = new DataManager();
    protected static WebDriver driver;

    protected void open(){
        driver = DriverFactory.getInstance();
        driver.get(PropertyProvider.getProperty(CustomProperties.AppProperties.APP_URL));
    }

    @AfterMethod
    protected void close() {

    }

}
