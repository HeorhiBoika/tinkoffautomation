package base.app;

public class ApplicationFactory {

    static ApplicationFactory appFactory = null;
    private MainApplication mainApplication = new MainApplication();

    public static ApplicationFactory get() {
        if (appFactory == null) {
            appFactory = new ApplicationFactory();
        }
        return appFactory;
    }


    public MainApplication mainApp() {
        return mainApplication;
    }

}
