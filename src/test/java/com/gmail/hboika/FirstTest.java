package com.gmail.hboika;

import enums.NavigationEnum;
import org.testng.annotations.Test;
import pages.MainPage;

public class FirstTest extends BaseTest {

    @Test()
    public void test() {
        MainPage mainPage = open();
        mainPage.navigateMainSecondTab(NavigationEnum.AppMainTabs.PAYMENTS.get());
        payments.searchRecipientOfPayment("Коммунальные платежи");
        payments.selectRegion("Москве");
        payments.selectRecipient("ЖКУ-Москва");
    }
}
