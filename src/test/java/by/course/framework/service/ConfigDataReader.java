package by.course.framework.service;

import java.util.ResourceBundle;

public class ConfigDataReader {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("configs");

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
