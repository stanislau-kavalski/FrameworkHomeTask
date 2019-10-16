package by.course.framework.page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MinuteMailHomePage extends AbstractPage {

    private static final String EMAIL_TOTAL_PRICE_XPATH = "//*[@class='quote']//h3[contains(text(), 'USD')]";
    private static final String ONLY_DIGITS_REGEX = "[^0-9.,]+";

    @FindBy(id = "mailAddress")
    private WebElement email;

    public MinuteMailHomePage openMailHomePage() {
        openNewTab();
        switchToTab(1);
        openMinuteMailHomePage();
        return this;
    }

    public EmailForm getEmail() {
        return new EmailForm(email.getAttribute("value"));
    }

    public void OpenEmail() {
        waitUntilEmailComesAndOpenIt();
    }

    public String getTotalPrice() {
        return leaveOnlyDigitsInText(waitUntilVisibilityOfElementLocatedAndGetText(By.xpath(EMAIL_TOTAL_PRICE_XPATH)));
    }

    private String leaveOnlyDigitsInText(String text) {
        return text.replaceAll(ONLY_DIGITS_REGEX, StringUtils.EMPTY);
    }
}
