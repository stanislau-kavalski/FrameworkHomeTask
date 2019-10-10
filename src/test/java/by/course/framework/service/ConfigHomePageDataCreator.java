package by.course.framework.service;

public class ConfigHomePageDataCreator {

    private static final String GOOGLE_CLOUD_HOMEPAGE_URL = "googleCloud.homePage.URL";
    private static final String MINUTE_MAIL_HOMEPAGE_URL = "minuteMail.HomePage.URL";

    public static String getGoogleCloudHomepageUrlData() {
        return ConfigDataReader.getTestData(GOOGLE_CLOUD_HOMEPAGE_URL);
    }

    public static String getMinuteMailHomepageUrlData() {
        return ConfigDataReader.getTestData(MINUTE_MAIL_HOMEPAGE_URL);
    }
}
