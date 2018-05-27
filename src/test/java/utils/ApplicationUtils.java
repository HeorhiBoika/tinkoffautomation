package utils;

public class ApplicationUtils {

    private ApplicationUtils() {}

    public static String formatURL() {
        String result = "https://";
        String host = PropertyProvider.getProperty(CustomProperties.AppProperties.APP_HOST);
        return result + host;
    }
}