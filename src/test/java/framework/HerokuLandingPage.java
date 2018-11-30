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
    private By joinButton = By.xpath("//a[@class='btn btn-success']");
    private By nameFieldReg = By.xpath("//input[@name='username']");
    private By emailFieldReg = By.xpath("//input[@name='email']");
    private By passwordFieldReg = By.xpath("//input[@name='password']");
    private By submitButtonReg = By.xpath("//button[@type='submit']");
    private By alert = By.xpath("//div[@class='alert alert-success alert-dismissible']");



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
    public void clickOnJoinButton() {
        clickOn(joinButton);
    }

    public void registration(String name, String email, String password) {
        sendText(nameFieldReg, name);
        sendText(emailFieldReg, email);
        sendText(passwordFieldReg, password);
    }

    public void clickSubmitOnRegPage() {
        clickOn(submitButtonReg);
    }

    public void verifyInvalidEmail() {
        herokuActions.verifyInvalidEmail();
    }

    public void verifyNewUserRegistration() {
        try {
            Thread.sleep(5000);
            String text = getTextFromElement(alert);
            String newUser = "New User is Registered";
            Assert.assertEquals(text, newUser, "The registration is not complete, as Account with that email address already exists.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
