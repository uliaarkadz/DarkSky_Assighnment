package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class HerokuLandingPage extends BasePage {

    private By topBar = By.xpath("//input[@id='aa-search-input']");
    private By autocomplete = By.xpath("//span[@id='algolia-autocomplete-listbox-0']");


    HerokuActions herokuActions = new HerokuActions();
    @Step
    public void clickOnSearchBar() {
        clickOn(topBar);
    }

    public void enterTopSearchField(String text) throws InterruptedException {
        sendText(topBar, text);
        //Thread.sleep(5000);
    }

    public void verifySearchText(String title) {
        actions(autocomplete);
        String titleFromWeb = getTextFromElement(autocomplete);
        Assert.assertEquals(titleFromWeb, title,"The search text is wrong");
    }

}
