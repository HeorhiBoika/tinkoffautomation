package com.gmail.hboika;

import enums.NavigationEnum;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.Payments;

import java.util.HashMap;
import java.util.Map;

public class FirstTest extends BaseTest {

    @Test()
    public void test() {
        MainPage mainPage = open();
        mainPage.navigateMainSecondTab(NavigationEnum.AppMainTabs.PAYMENTS.get());
        payments.searchRecipientOfPayment("Коммунальные платежи");
        payments.selectRegion("Москве");
        payments.selectRecipient("ЖКУ-Москва");

        Map<String, String> mapData = new HashMap<>();
        mapData.put(Payments.PaymentFormEnum.PaymnetForm.CODE_PAYMENT_GKY.get(), "111111");
        mapData.put(Payments.PaymentFormEnum.PaymnetForm.PERIOD_OF_PAYMENT.get(), "11.11.2011");
        mapData.put(Payments.PaymentFormEnum.PaymnetForm.INSUARANCE_VALUE.get(), "100");
        mapData.put(Payments.PaymentFormEnum.PaymnetForm.AMOUNT.get(), "100");
        payments.makePayment("Оплатить", mapData);

        Assert.assertEquals(payments.isWarningMessagePresent(Payments.PaymentFormEnum.PaymnetForm.CODE_PAYMENT_GKY.get()), true);
    }
}
