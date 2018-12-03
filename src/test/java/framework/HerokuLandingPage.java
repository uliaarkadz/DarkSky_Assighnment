package framework;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

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
    private By userName = By.xpath("//li[@class='dropdown open']//ul[@class='dropdown-menu']//li[1]");
    private By signInButton = By.xpath("//ul[@class='nav navbar-nav navbar-right']//li[1]");
    private By emailFieldLogIn = By.xpath("//input[@id='email']");
    private By passwordFieldLogIn = By.xpath("//input[@id='password']");
    private By submitButtonLogIn = By.xpath("//button[@type='submit']");
    private By userIcon = By.xpath("//body/nav[@class='navbar navbar-default navbar-static-top']/div[@class='container']/div[@id='bs-example-navbar-collapse-1']/ul[@class='nav navbar-nav navbar-right']/li[3]/a[1]");
    private By logOutButton = By.xpath("//ul[@class='dropdown-menu']//li[3]");


    @Step
    public void clickOnSearchBar() {
        clickOn(topBar);
    }

    public void enterTopSearchField(String text) {
        sendText(topBar, text);
    }

    public void verifySearchText(String title) {
        actions(autocomplete);
        String titleFromWeb = getTextFromElement(autocomplete);
        Assert.assertEquals(titleFromWeb, title, "The search text is wrong");
    }

    public void verifyTotalNumberOfGigs(int gigs) {
        Assert.assertEquals(getElementsCount(gigElements), gigs);
    }

    public void verifyPriceForEachGig() {
        List<String> price = getContainerElements(priceElement, "$");
        Assert.assertNotEquals(price.size(), getElementsCount(gigElements), "All gigs have price");
    }

    public void verifyTitles() {
        List<String> title = getContainerElements(postTitle, "");
        Assert.assertNotEquals(title.size(), getElementsCount(gigElements), "All gigs have title");
    }

    public void verifyImages() {
        List<String> images = getAttributeFromElement(postImage, "copywrite.jpg");
        Assert.assertNotEquals(images.size(), getElementsCount(gigElements), "All post have image");
    }

    public void clickOnJoinButton() {
        clickOn(joinButton);
    }

    public void registrationInvalidEmail(String name, String email, String password) {
        sendText(nameFieldReg, name);
        sendText(emailFieldReg, email);
        sendText(passwordFieldReg, password);
    }

    public void regNewUser(String name, String password) {
        String email = generateRandomName();
        sendText(nameFieldReg, name);
        sendText(emailFieldReg, email);
        sendText(passwordFieldReg, password);
    }

    public void clickSubmitOnRegPage() {
        clickOn(submitButtonReg);
    }

    public void verifyInvalidEmail() {
        clickOn(By.xpath("//h1[@class='space-top text-center']"));
        //herokuActions.verifyInvalidEmail();
        actionsMove(emailFieldReg);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        verifyInvalidEmail();
        //System.out.println("Text" + verifyInvalidEmail());
    }

    public void verifyNewUserRegistration() {
        clickOn(userIcon);
        String buttonText = getTextFromElement(userName);
        String text = "testuser";
        Assert.assertEquals(buttonText, text, "The new user is not sighed-in");
    }

    public void clickOnSighIn() {
        clickOn(signInButton);
    }

    public void enterLoginData(String email, String password) {
        sendText(emailFieldLogIn, email);
        sendText(passwordFieldLogIn, password);
    }

    public void clickOnSubmitButton() {
        clickOn(submitButtonLogIn);
    }

    public void verifyLogOuButton() throws InterruptedException {
        Thread.sleep(5000);
        clickOn(userIcon);
        String buttonText = getTextFromElement(logOutButton);
        String text = "Logout";
        Assert.assertEquals(buttonText, text, "The logout button is not displayed");
    }
}
