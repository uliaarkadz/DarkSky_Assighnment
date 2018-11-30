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

    @When("^I expand todays timeline$")
    public void expandTodaysTimeline() throws InterruptedException {
        lp.expandTodaysTimeline();
    }
    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void verifyTodaysTemp() {
        lp.verifyTodaysTimelineTemp();
    }
    @When("^I click on Time Machine$")
    public void clickOnTimeMachine(){
        lp.clickOnTimeMachine();
    }

    @Then("^I verify date is selected to todays date$")
    public void verifyTodaysDate() throws InterruptedException {
        lp.verifyDateTimeMachine();

    }
}
