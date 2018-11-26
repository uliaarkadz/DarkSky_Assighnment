package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DarkSkyLandingPage;

public class DarkSkySD {
    private DarkSkyLandingPage lp = new DarkSkyLandingPage();


    @Given("^I am on darksky home page$")

    @When("^Clear search text field$")
    public void clearSearch() {
        lp.clickOnSearchField();
        lp.clearSearchField();
    }

    @When("^Enter zip code into the search field as (.+)$")
    public void enterZipCode(String zip) {
        lp.enterZipCode(zip);
    }

    @When("^Click on search magnifying glass$")
    public void clickOnMagnifyingGlass() {
        lp.clickOnMagnifyingGlass();
    }

    @Then("^Verify current temperature is between low and high value$")
    public void verifyCurrentTemperature() {
        lp.verifyCurrentTemperature();
    }

    @Then("^I verify timeline is displayed with (.+) hours incremented$")
    public void verifyTimeline(int hour) {
        lp.verifyTimeline(hour);
    }
}



