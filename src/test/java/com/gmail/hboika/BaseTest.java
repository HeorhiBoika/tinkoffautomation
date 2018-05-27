package com.gmail.hboika;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import utils.ApplicationUtils;
import utils.DataManager;
import utils.DriverFactory;

public class BaseTest {
    protected DataManager dataManager = new DataManager();
    protected WebDriver driver = DriverFactory.getInstance();


    protected void open() {
           driver.get(ApplicationUtils.formatURL());
           driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    protected void afterMethod() {
        driver.quit();
        driver = null;
    }

}
