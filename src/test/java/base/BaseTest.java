package base;

import base.app.ApplicationFactory;
import base.app.MainApplication;
import org.testng.annotations.AfterMethod;
import utils.DataManager;

public class BaseTest {
    protected DataManager dataManager = new DataManager();

    protected MainApplication mainApp(){
        return ApplicationFactory.get().mainApp();
    }

    @AfterMethod(alwaysRun = true)
    protected void afterMethod() {
        mainApp().close();
    }

}
