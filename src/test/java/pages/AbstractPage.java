package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    private String xpathMainTab = "//div[@id='x48761']/div[contains(@class, 'SecondMenu')]//span[contains(text(),'%s')]/..";

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateMainSecondTab(String nameTab) {
        driver.findElement(By.xpath(String.format(xpathMainTab, nameTab))).click();
    }

    protected WebElement expectedWait(By element) {
       return  new WebDriverWait(driver, 5, 5000).until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }

}
