package by.course.framework.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CalculatorTestDataReader {

    private static final String CALCULATOR_DATA_PATH = "src/test/resources/data/";
    private static final String CALCULATOR_DATA_FILE_EXTENSION = ".data.properties";
    private static Properties calculatorData = new Properties();
    private static InputStream input = createInputStream();

    static {
        try {
            calculatorData.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTestData(String key) {
        return calculatorData.getProperty(key);
    }

    private static FileInputStream createInputStream() {
        try {
            return new FileInputStream(CALCULATOR_DATA_PATH + System.getProperty("environment") + CALCULATOR_DATA_FILE_EXTENSION);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
