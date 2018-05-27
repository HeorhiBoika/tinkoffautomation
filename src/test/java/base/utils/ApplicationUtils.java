package base.utils;

import utils.CustomProperties;
import utils.PropertyProvider;

public class ApplicationUtils {

    private ApplicationUtils() {}

    public static String formatURL() {
        String result = "https://";
        String host = PropertyProvider.getProperty(CustomProperties.BrowserProperties.HOST);
        return result + host;
    }
}