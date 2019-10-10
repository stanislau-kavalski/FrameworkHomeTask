package by.course.framework.model;

import by.course.framework.service.ConfigHomePageDataCreator;

public class ConfigHomePageData {

    private static String googleCloudHomePageUrl;
    private static String minuteMailHomePageUrl;

    static {
        setGoogleCloudHomePageUrl(ConfigHomePageDataCreator.getGoogleCloudHomepageUrlData());
        setMinuteMailHomePageUrl(ConfigHomePageDataCreator.getMinuteMailHomepageUrlData());
    }

    public static String getGoogleCloudHomePageUrl() {
        return googleCloudHomePageUrl;
    }

    private static void setGoogleCloudHomePageUrl(String googleCloudHomePageUrl) {
        ConfigHomePageData.googleCloudHomePageUrl = googleCloudHomePageUrl;
    }

    public static String getMinuteMailHomePageUrl() {
        return minuteMailHomePageUrl;
    }

    private static void setMinuteMailHomePageUrl(String minuteMailHomePageUrl) {
        ConfigHomePageData.minuteMailHomePageUrl = minuteMailHomePageUrl;
    }
}
