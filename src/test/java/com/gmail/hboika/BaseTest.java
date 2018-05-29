package com.gmail.hboika;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import pages.AbstractPage;
import pages.MainPage;
import pages.Payments;
import utils.ApplicationUtils;
import utils.DataManager;
import utils.DriverFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    DataManager dataManager = new DataManager();
    private WebDriver driver = DriverFactory.getInstance();
//    AbstractPage mainPage;
    protected Payments payments = new Payments(driver);


    protected MainPage open() {
        driver.get(ApplicationUtils.formatURL());
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return new MainPage(driver);
    }

    protected Payments payment() {
        return new Payments(driver);
    }

    @AfterMethod(alwaysRun = true)
    protected void afterMethod() {
        driver.quit();
        driver = null;
    }

}
