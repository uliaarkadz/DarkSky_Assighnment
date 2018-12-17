package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HerokuLandingPage;
import framework.ScreenShot;
import org.testng.Assert;

import java.io.IOException;

public class HerokuSD {

    private HerokuLandingPage herokuLandingPage = new HerokuLandingPage();
    private ScreenShot screenShot = new ScreenShot();

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
        Assert.assertEquals(herokuLandingPage.getSearchText(), title, "The search text is wrong");
    }

    @Then("^I verify (.+) total post is displayed$")
    public void verifyTotalNumberOfPosts(int gigs) {
        Assert.assertEquals(herokuLandingPage.getTotalNumberOfGigs(), gigs);
    }

    @Then("^I verify all post has price tag$")
    public void verifyPrice() {
        Assert.assertNotEquals(herokuLandingPage.getPrice(), herokuLandingPage.getTotalNumberOfGigs(),"All gigs have price");
    }

    @Then("^I verify all post has title$")
    public void verifyPrices() {
        Assert.assertNotEquals(herokuLandingPage.getTitles(), herokuLandingPage.getTotalNumberOfGigs(), "All gigs have title");
    }

    @Then("^I verify all post has displayed image$")
    public void verifyImages() {
        Assert.assertNotEquals(herokuLandingPage.getImages(), herokuLandingPage.getTotalNumberOfGigs(), "All gig have image");
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
        try {
            ScreenShot.takeScreenShot();
        } catch (IOException e) {
            e.printStackTrace ( );
        }
    }

    @Then("^I am signed-in as a new user$")
    public void verifyNewUserRegistration() {
        Assert.assertTrue(herokuLandingPage.verifyNewUserRegistration(), "The new user is not sighed-in");
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
        Assert.assertTrue(herokuLandingPage.verifyLogOuButton(), "The logout button is not displayed");
    }

}