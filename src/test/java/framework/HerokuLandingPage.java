package framework;

import org.openqa.selenium.By;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;

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

    public String getSearchText() {
        actions(autocomplete);

        return  getTextFromElement(autocomplete);
    }

    public int getTotalNumberOfGigs() {

        return getElementsCount(gigElements);
    }

    public int getPrice() {

        return getContainerElements(priceElement, "$").size();
    }

    public int getTitles() {

        return getContainerElements(postTitle, "").size();
    }

    public int getImages() {

        return getAttributeFromElement(postImage, "https://floating-anchorage-58495.herokuapp.com/img/copywrite.jpg").size();
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

    }

    public boolean verifyNewUserRegistration() {
        clickOn(userIcon);
        String buttonText = getTextFromElement(logOutButton);
        String text = "Logout";

        return buttonText.equals(text);
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

    public boolean verifyLogOuButton() throws InterruptedException {
        Thread.sleep(5000);
        clickOn(userIcon);
        String buttonText = getTextFromElement(logOutButton);
        System.out.println("text" + buttonText);
        String text = "Logout";

        return buttonText.equals(text);
    }
}
