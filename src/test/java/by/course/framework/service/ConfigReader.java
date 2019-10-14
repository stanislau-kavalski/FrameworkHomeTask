package by.course.framework.service;

import java.util.ResourceBundle;

public class ConfigReader {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("configs");

    public static String get(String key) {
        return resourceBundle.getString(key);
    }
}
