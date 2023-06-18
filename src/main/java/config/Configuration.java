package config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private final Properties properties = new Properties();

    public Configuration() {
        try (InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("Environment.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("Environment.properties file not found!");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading Environment.properties file: " , e);
        }
    }

    public String getPropertyValue(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new IllegalArgumentException("Key not found: " + key);
        }
        return value;
    }
}
