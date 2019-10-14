package by.course.framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {
        throw new AssertionError("Cannot be instantiated directly.");
    }

    public static WebDriver getDriver() {
        /**
         * Плохо. Т.е. при определенном раскладе, если у тебя browser не задан, у тебя вернется браузер = null.
         * Притом ты два раза делаешь System.getProperty("browser"). Тоже плохо
         * Еще раз: чего ты хочешь добиться?  У нас есть всего 2 стратегии доступные:
         * 1. Либо мы останавливаем тесты, если не знаем, на каком браузере должен быть тест
         * 2. Либо мы используем дефолтный браузер
         *
         * Мне больше нравится 1 вариент.
         * Но если хочешь второй, просто вставь в свою предыдущую версию кода вот это
         * switch (System.getProperty("browser", "chrome")) - > все, если не будет задан браузер, он возмет хром
         * и тогда default - туда ошибку бросать, вместо хрома
         */
        if (null != driver) {
            return driver;
        }
        if (null != System.getProperty("browser")){
            switch (System.getProperty("browser")){
                case "firefox": {
                    driver = createFirefoxDriver();
                    break;
                }
                case "chrome": {
                    driver = createChromeDriver();
                    break;
                }
                default: {
                    driver = createChromeDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
