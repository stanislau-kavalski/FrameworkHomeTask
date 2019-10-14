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
         * Давай так не делать. Получается две разные проверки в одну строчку. Определись, чего ты хочешь:
         * 1. Если ты хочешь, чтобы у тебя browser никогда не был null, то сделай проверку и кинь ошибку
         * типа if (null == browser) throw и описание ошибки, чтобы пользователь понял, что делать
         * 2. Если ты хочешь, чтобы в любом случае запускалось, сделай явно
         *   switch(System.getProperty("browser", "chrome")) // в этом случае, если будет null, то выберется chrome
         *   Но на мой взгляд это не явно. Лучше всегда задавать ограничения
         *
         *   И при сравнении лучше null ставить вперед null == System.getProperty("browser")
         *
         */

        if (driver == null && System.getProperty("browser") != null){
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
