package by.course.framework.model;

import by.course.framework.service.ConfigTimeoutDataCreator;

public class ConfigTimeoutData {
    /**
     * Опять ненене. смотри класс ConfigHomePageData. Таймауты должны получаться из пропертей. И лучше напрямую
     * ConfigReader.get(Constants.PAGE_LOAD_TIMEOUT).
     * И не уверен, что тебе нужно два таймаута.
     *
     * И статические геттеры-сеттеры - нет
     */
    private static int commonTimeout;
    private static int emailTimeout;

    static {
        setCommonTimeout(ConfigTimeoutDataCreator.getCommonTimeoutData());
        setEmailTimeout(ConfigTimeoutDataCreator.getEmailTimeoutData());
    }

    public static int getCommonTimeout() {
        return commonTimeout;
    }

    public static int getEmailTimeout() {
        return emailTimeout;
    }

    private static void setCommonTimeout(int commonTimeout) {
        ConfigTimeoutData.commonTimeout = commonTimeout;
    }
    private static void setEmailTimeout(int emailTimeout) {
        ConfigTimeoutData.emailTimeout = emailTimeout;
    }
}
