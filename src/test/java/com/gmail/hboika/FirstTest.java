package com.gmail.hboika;

import base.BaseTest;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test()
    public void test() {
        mainApp().open();
    }
}
