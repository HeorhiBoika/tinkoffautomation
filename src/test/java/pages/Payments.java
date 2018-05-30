package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Payments extends MainPage {

    private String xpathSearchRecipientBox = "//div[contains(@class, 'SearchAndPay')]//input[contains(@placeholder, 'Название или ИНН')]";
    private String xpathSearchListOfRecipients = "//div[contains(@class, 'SearchSuggested')]//div[contains(text(), '%s')]";
    private String xpathSelectRegion = "//div[contains(@class, 'PageTitle')]//div[contains(text(), 'ЖКХ')]//span[contains(@class, 'Link')]";
    private String xpathSelectRegionFromList = "//div[contains(@class, 'UiRegions__uiRegions')]//span[contains(text(),'%s')]/..";
    private String xpathSelectTypeOfRecipient = "//section[contains(@class, 'UILayoutSection__section')]//span[1]//a[contains(@title,'%s')]";
    private String xpathTypeOfActionGKY = "//div[contains(@class, 'Tabs__container')]//span[contains(text(), '%s')]/..";
    private String xpathFormOfPayment = "//div[contains(@class, 'Grid__root')]//span[contains(text(), '%s')]/ancestor::*[contains(@class,'input__column')]/input | //div[contains(@class, 'Grid__root')]//span[contains(text(), '%s')]/..//input";
    private String xpathButtonPaymentSubmit = "//div[contains(@class, 'Grid__root')]//div[contains(@class, 'ui-form')]//button";
    private String xpathWarningMessaage = "//div[contains(@class, 'Grid__root')]//span[contains(text(), '%s')]/ancestor::*[contains(@class,'ui-form__field')]/div[2]";

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

    public void makePayment(String typeOfAction, Map mapData) {
        driver.findElement(By.xpath(String.format(xpathTypeOfActionGKY, typeOfAction))).click();
        fillTab(mapData);
        submit();
    }

    private void fillTab(Map<String, String> map) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(Map.Entry<String, String> entry : map.entrySet()) {
            for(PaymentFormEnum.PaymnetForm fields :PaymentFormEnum.PaymnetForm.values()) {
              if(entry.getKey().contains(fields.get())) {
                  driver.findElement(By.xpath(String.format(xpathFormOfPayment, fields.get(), fields.get())))
                          .sendKeys(entry.getValue());
                  break;
              }
            }
        }
    }

    private void submit() {
        driver.findElement(By.xpath(xpathButtonPaymentSubmit)).click();
    }

    public boolean isWarningMessagePresent(String fieldName) {
        if(driver.findElement(By.xpath(String.format(xpathWarningMessaage, fieldName))).isDisplayed()) {
            return true;
        }
        return false;
    }

    public static class PaymentFormEnum {
        public enum PaymnetForm {
            CODE_PAYMENT_GKY("Код плательщика"),
            PERIOD_OF_PAYMENT("За какой период"),
            INSUARANCE_VALUE("Сумма добровольного страхования"),
            AMOUNT("Сумма платежа");

            String id;
            private PaymnetForm(String id) {
                this.id = id;
            }
            public String get() {
                return this.id;
            }

        }
    }

}
