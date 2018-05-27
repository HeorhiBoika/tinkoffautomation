package com.gmail.hboika;

import base.app.ApplicationFactory;
import base.app.MainApplication;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import utils.DataManager;
import utils.DriverFactory;

public class BaseTest {
    protected DataManager dataManager = new DataManager();
    protected WebDriver driver = DriverFactory.getInstance();

    protected MainApplication mainApp() {
        return ApplicationFactory.get().mainApp();
    }

    public void open() {

    }

    @AfterMethod(alwaysRun = true)
    protected void afterMethod() {
        driver.quit();
        driver = null;
    }

}
