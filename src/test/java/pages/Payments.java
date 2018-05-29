package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Payments extends MainPage {

    private String xpathSearchRecipientBox = "//div[contains(@class, 'SearchAndPay')]//input[contains(@placeholder, 'Название или ИНН')]";
    private String xpathSearchListOfRecipients = "//div[contains(@class, 'SearchSuggested')]//div[contains(text(), '%s')]";
    private String xpathSelectRegion = "//div[contains(@class, 'PageTitle')]//div[contains(text(), 'ЖКХ')]//span[contains(@class, 'Link')]";
    private String xpathSelectRegionFromList = "//div[contains(@class, 'UiRegions__uiRegions')]//span[contains(text(),'%s')]/..";
    private String xpathSelectTypeOfRecipient = "//section[contains(@class, 'UILayoutSection__section')]//span[1]//a[contains(@title,'%s')]";

    public Payments(WebDriver driver) {
        super(driver);
    }

    public void searchRecipientOfPayment(String recipientType) {
        driver.findElement(By.xpath(xpathSearchRecipientBox)).sendKeys(recipientType);
        driver.findElement(By.xpath(String.format(xpathSearchListOfRecipients, recipientType))).click();
    }

    public void selectRegion(String regionName) {
        String actualRegion = driver.findElement(By.xpath(xpathSelectRegion)).getText();
        if(!actualRegion.equals(regionName)) {
            driver.findElement(By.xpath(xpathSelectRegion)).click();
            driver.findElement(By.xpath(String.format(xpathSelectRegionFromList, regionName.substring(0,regionName.length() - 1)))).click();
        }
    }

    public void selectRecipient(String recipientName) {
        driver.findElement(By.xpath(String.format(xpathSelectTypeOfRecipient, recipientName))).click();
    }

}
