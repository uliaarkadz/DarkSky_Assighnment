package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HerokuLandingPage;

public class HerokuSD {
    private HerokuLandingPage herokuLandingPage = new HerokuLandingPage();

    @Given("^I am on heroku home page$")

    @When("^I click on top search bar$")
    public void clickBarSearch() {
        herokuLandingPage.clickOnSearchBar();
    }

    @When("^I search on top search bar with text (.+)$")
    public void topBarSearch(String text) throws InterruptedException {
        herokuLandingPage.enterTopSearchField(text);
    }

    @Then("^I verify (.+) displayed as result$")
    public void verifySearchText(String title) {
        herokuLandingPage.verifySearchText(title);
    }

}