package base.app;

import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public abstract class Application {

    protected String url = "";
    protected boolean isApplicationOpened = false;
    private WebDriver webdriver = new DriverFactory().getInstance();

    public Application(String url) {
        this.url = url;
    }

    public void open() {
        if (!isApplicationOpened) {
            openSession();

        }
        setApplicationOpened(true);
    }


    public void close() {
        if (isApplicationOpened) {
            setApplicationOpened(false);
            closeSession();
        }
    }


    private void openSession() {
        webdriver.get(url);
        webdriver.manage().window().maximize();
        setApplicationOpened(true);

    }

    private void closeSession() {
        webdriver.quit();

    }


    private void setApplicationOpened(boolean status) {
        isApplicationOpened = status;
    }
}
