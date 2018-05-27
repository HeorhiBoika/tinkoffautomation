package com.gmail.hboika;

import base.BaseTest;
import org.testng.annotations.Test;
import utils.DataType;
import utils.SimpleData;

public class CustomTest extends BaseTest {

    @Test
    public void test(){
        SimpleData simpleData = dataManager.get(DataType.SIMPLE, "Data");
        int c = 0;
    }
}
