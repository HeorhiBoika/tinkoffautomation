package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class PropertyProvider {
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("src/test/resources/project.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Impossible to load property file", e);
        }
    }

    public static String getProperty(String key) {
        return Optional.ofNullable(properties.getProperty(key)).orElseThrow(() ->
                new RuntimeException(String.format("Property %s does not exist", key)));
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
