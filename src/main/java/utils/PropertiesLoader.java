package utils;

import exceptions.UnknownPropertyException;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;


/*
 * Class that helps to load properties from a properties file.
 *
 * @author Eduard Zaretski
 */
public class PropertiesLoader {

    private static final String PROP_FILE = "/test.properties";

    private PropertiesLoader() {
    }

    public static String loadProperty(String propertyName) {
        Properties properties = new Properties();
        try {
            properties.load(PropertiesLoader.class.getResourceAsStream(PROP_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<String> propertiesNames = properties.stringPropertyNames();
        if (propertyName.equals("")) {
            throw new UnknownPropertyException("Property name is absent!!!");
        } else if (!propertiesNames.contains(propertyName)) {
            throw new UnknownPropertyException("Unknown property!!! " + propertyName);
        }
        String propertyValue = properties.getProperty(propertyName);
        return propertyValue;
    }
}
