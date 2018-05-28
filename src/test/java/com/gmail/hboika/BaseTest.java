package com.gmail.hboika;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import pages.AbstractPage;
import pages.MainPage;
import utils.ApplicationUtils;
import utils.DataManager;
import utils.DriverFactory;

public class BaseTest {
    DataManager dataManager = new DataManager();
    private WebDriver driver = DriverFactory.getInstance();
//    AbstractPage mainPage;


    protected MainPage open() {
        driver.get(ApplicationUtils.formatURL());
        driver.manage().window().maximize();
        return new MainPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    protected void afterMethod() {
        driver.quit();
        driver = null;
    }

}
