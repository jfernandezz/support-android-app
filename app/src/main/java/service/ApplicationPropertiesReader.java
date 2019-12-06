package service;

import java.util.Properties;

public interface ApplicationPropertiesReader {
    String getProperty(String key);
    Properties getProperties();
    Properties readProperties();
}
