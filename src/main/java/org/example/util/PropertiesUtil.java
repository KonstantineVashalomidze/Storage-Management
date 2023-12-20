package org.example.util;

import java.io.*;
import java.util.Properties;

public class PropertiesUtil {
    private static PropertiesUtil instance;
    private Properties properties;
    private String filePath;

    private PropertiesUtil(String filePath) {
        this.filePath = filePath;
        loadProperties();
    }

    public static synchronized PropertiesUtil getInstance(String filePath) {
        if (instance == null) {
            instance = new PropertiesUtil(filePath);
        }
        return instance;
    }

    private void loadProperties() {
        properties = new Properties();
        try (InputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void setProperty(String key, String value) {
        properties.setProperty(key, value);
        saveProperties();
    }

    public synchronized String getProperty(String key) {
        return properties.getProperty(key);
    }

    public synchronized void saveProperties() {
        try (OutputStream output = new FileOutputStream(filePath)) {
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
