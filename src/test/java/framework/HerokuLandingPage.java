package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class HerokuLandingPage extends BasePage {

    private By topBar = By.xpath("//input[@id='aa-search-input']");
    private By autocomplete = By.xpath("//span[@id='algolia-autocomplete-listbox-0']");
    private By gigElements = By.xpath("//body/div[@class='container section']/div[@class='row']//div[@class='gig-card']");
    private By priceElement = By.xpath("//div[@class='gig-card']//h3");
    private By postTitle = By.xpath("//div[@class='gig-card']//h4");
    private By postImage = By.xpath("//div[@class='row']//img");


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

    public void verifyTotalNumberOfGigs(int gigs) {
        Assert.assertEquals(getElementsCount(gigElements), gigs);
    }

    public void verifyPriceForEachGig() {
        herokuActions.getContainerElements(priceElement, "$");
    }

    public void verifyTitles() {
        herokuActions.getContainerElements(postTitle, "");
    }

    public void verifyImages() {
        herokuActions.getAttributeFromElement(postImage, "copywrite.jpg");
    }


}
