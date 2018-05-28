package com.gmail.hboika;

import org.testng.annotations.Test;
import pages.MainPage;
import utils.DataType;
import utils.SimpleData;

public class CustomTest extends BaseTest {
    SimpleData simpleData = dataManager.get(DataType.SIMPLE, "Data");

    @Test
    public void test(){
        MainPage mainPage = open();

        int c = 0;
    }
}
