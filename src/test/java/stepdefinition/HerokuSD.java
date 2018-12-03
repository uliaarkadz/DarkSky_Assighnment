package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HerokuLandingPage;
import org.testng.Assert;

public class HerokuSD {
    private HerokuLandingPage herokuLandingPage = new HerokuLandingPage();

    @Given("^I am on heroku home page$")

    @When("^I click on top search bar$")
    public void clickBarSearch() {
        herokuLandingPage.clickOnSearchBar();
    }

    @When("^I search on top search bar with text (.+)$")
    public void topBarSearch(String text){
        herokuLandingPage.enterTopSearchField(text);
    }

    @Then("^I verify (.+) displayed as result$")
    public void verifySearchText(String title) {
        herokuLandingPage.verifySearchText(title);
    }

    @Then("^I verify (.+) total post is displayed$")
    public void verifyTotalNumberOfPosts(int gigs) {
        herokuLandingPage.verifyTotalNumberOfGigs(gigs);
    }

    @Then("^I verify all post has price tag$")
    public void verifyPrice() {
        herokuLandingPage.verifyPriceForEachGig();
    }

    @Then("^I verify all post has title$")
    public void verifyPrices() {
        herokuLandingPage.verifyTitles();
    }

    @Then("^I verify all post has displayed image$")
    public void verifyImages() {
        herokuLandingPage.verifyImages();
    }

    @Given("^I am on Registration page$")
    public void goToRegistrationPage() {
        herokuLandingPage.clickOnJoinButton();
    }

    @When("^I enter name as (.+) email as random email password as (.+)$")
    public void registrationData(String name, String password) {
        herokuLandingPage.regNewUser(name, password);
    }

    @When("^I enter name as (.+) email as (.+) password as (.+) in the fields$")
    public void enterRegistration(String name, String email,  String password) {
        herokuLandingPage.registrationInvalidEmail(name, email, password);
    }

    @When("^I click 'submit' button$")
    public void clickSubmit() {
        herokuLandingPage.clickSubmitOnRegPage();
    }

    @Then("^I verify invalid email address$")
    public void verifyInvalidEmail() {
        herokuLandingPage.verifyInvalidEmail();
    }

    @Then("^I am signed-in as a new user$")
    public void verifyNewUserRegistration() {
        herokuLandingPage.verifyNewUserRegistration();
    }

    @Given("^User is on the Threely login page$")
    public void goToLoginPage() {
        herokuLandingPage.clickOnSighIn();
    }

    @When("^I enter username as (.+) and password as (.+)$")
    public void enterLoginData(String email, String password) {
        herokuLandingPage.enterLoginData(email, password);
    }

    @When("^I click on submit button$")
    public void clickOnSubmitButton() {
        herokuLandingPage.clickOnSubmitButton();
    }

    @Then("^I verify logout button is displayed$")
    public void verifyLogOutButton() throws InterruptedException {
        herokuLandingPage.verifyLogOuButton();
    }

}