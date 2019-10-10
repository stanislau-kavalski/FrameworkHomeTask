package by.course.framework.model;

import by.course.framework.service.ConfigTimeoutDataCreator;

public class ConfigTimeoutData {

    private static int commonTimeout;
    private static int emailTimeout;

    static {
        setCommonTimeout(ConfigTimeoutDataCreator.getCommonTimeoutData());
        setEmailTimeout(ConfigTimeoutDataCreator.getEmailTimeoutData());
    }

    public static int getCommonTimeout() {
        return commonTimeout;
    }

    private static void setCommonTimeout(int commonTimeout) {
        ConfigTimeoutData.commonTimeout = commonTimeout;
    }

    public static int getEmailTimeout() {
        return emailTimeout;
    }

    private static void setEmailTimeout(int emailTimeout) {
        ConfigTimeoutData.emailTimeout = emailTimeout;
    }
}
