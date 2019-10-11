package by.course.framework.model;

import by.course.framework.service.ConfigHomePageDataCreator;

public class ConfigHomePageData {
    /**
     * Ненене так делать низзя.
     * В этом классе несколько проблем
     * 1. Он не нужен :) Смори, урл может изменяться в зависимости от инваермента. Значит, это проперти. Проперти
     * тебе нет необходимости сетать в объект. Ты можешь его напрямую получить. ConfigReader.get('homePageUrl')
     * Чтобы сделать гибче, можно сделать класс с константами и делать так: ConfigReader.get(Constants.HOME_PAGE_URL)
     * 2. Статические сеттеры/ геттеры на объекте - не делай так никогда     *
      */


    private static String googleCloudHomePageUrl;
    private static String minuteMailHomePageUrl;

    static {
        setGoogleCloudHomePageUrl(ConfigHomePageDataCreator.getGoogleCloudHomepageUrlData());
        setMinuteMailHomePageUrl(ConfigHomePageDataCreator.getMinuteMailHomepageUrlData());
    }

    public static String getGoogleCloudHomePageUrl() {
        return googleCloudHomePageUrl;
    }

    public static String getMinuteMailHomePageUrl() {
        return minuteMailHomePageUrl;
    }

    private static void setGoogleCloudHomePageUrl(String googleCloudHomePageUrl) {
        ConfigHomePageData.googleCloudHomePageUrl = googleCloudHomePageUrl;
    }

    private static void setMinuteMailHomePageUrl(String minuteMailHomePageUrl) {
        ConfigHomePageData.minuteMailHomePageUrl = minuteMailHomePageUrl;
    }
}
