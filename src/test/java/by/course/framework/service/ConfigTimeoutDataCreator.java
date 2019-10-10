package by.course.framework.service;

public class ConfigTimeoutDataCreator {

    private static final String COMMON_TIMEOUT = "common.waitTimeout";
    private static final String EMAIL_TIMEOUT = "email.waitTimeout";

    public static int getCommonTimeoutData() {
        return Integer.parseInt(ConfigDataReader.getTestData(COMMON_TIMEOUT));
    }

    public static int getEmailTimeoutData() {
        return Integer.parseInt(ConfigDataReader.getTestData(EMAIL_TIMEOUT));
    }
}
