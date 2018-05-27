package base.app;

import base.utils.ApplicationUtils;
import utils.PropertyProvider;

public class MainApplication extends Application {

    public MainApplication() {
        super(ApplicationUtils.formatURL());
    }
}
