package utils;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = getDriver();
        }
        return driver;
    }


    public static WebDriver getDriver() {
        String driverType = PropertyProvider.getProperty(CustomProperties.BrowserProperties.BROWSER_TYPE).toLowerCase();

        switch (driverType) {

            case "chrome": {
                driver = DriverSettings.chrome();
                break;
            }
            case "firefox": {
                driver = DriverSettings.firefox();
                break;
            }
            case "ie": {
                driver = DriverSettings.IE();
            }
            default: {
                driver = DriverSettings.chrome();
            }
        }
        return driver;
    }
}
