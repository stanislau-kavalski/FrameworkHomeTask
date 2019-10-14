package by.course.framework.service;

public final class Constants {

    public static final String GOOGLE_CLOUD_HOMEPAGE_URL = "googleCloud.homePage.URL";
    public static final String MINUTE_MAIL_HOMEPAGE_URL = "minuteMail.HomePage.URL";
    public static final String COMMON_TIMEOUT = "common.waitTimeout";
    public static final String EMAIL_TIMEOUT = "email.waitTimeout";

    private Constants() {
        throw new AssertionError("Cannot be instantiated directly.");
    }
}
