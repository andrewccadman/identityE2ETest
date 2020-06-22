package bdd.steps;

import bdd.pages.ResponsePage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import helpers.ReadCarFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bdd.pages.IndexPage;

public class MyStepdefs {

    ReadCarFile rcf = new ReadCarFile();
    WebDriver driver = new ChromeDriver();
    List<String> parseResults = new ArrayList<String>();

    @After
    public void closeDriver() {
        driver.close();
    }

    @Given("^I have obtained a text file of car registrations (.*.txt)$")
    public void iHaveObtainedATextFileOfCarRegistrations(String FileName) {
    }

    @When("^the (.*.txt) file is parsed$")
    public void theFileIsParsed(String fileName) throws IOException {
        String filePath = "src/test/data/" + fileName;
        File file = new File(filePath);
        String absolutePath = file.getAbsolutePath();

        parseResults = rcf.readFileFromPath(absolutePath);
    }

    @Then("^I can obtain the list of registrations (.*)$")
    public void iCanObtainTheListOfRegistrations(String registrations) {
        List<String> expectedResults = Arrays.asList(registrations.split(","));
//        expectedResults.add("DN09HRM");
//        expectedResults.add("BW57BOW");
//        expectedResults.add("KT17DLX");
//        expectedResults.add("SG18HTN");
        assert (parseResults.equals(expectedResults));

    }

    @When("^I check the make and model of the car using the (.*) registration number$")
    public void iCheckTheMakeAndModelOfTheCar(String regNumber) {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.goToPage();
        indexPage.setRegistrationNumber(regNumber);
        indexPage.submitFreeCarCheck();
    }

    @Then("^the information for the (.*), (.*), (.*), (.*) and (.*) are as expected$")
    public void theInformationForTheMakeModelColourAndYearAreAsExpected(String expectedRegistrationNumber, String expectedMake,
                                                                        String expectedModel, String expectedColour, String expectedYear) {

        ResponsePage responsePage = new ResponsePage(driver);
        String resultRegistrationNumber = responsePage.getRegistrationNumber();
        assert(expectedRegistrationNumber.equals(resultRegistrationNumber));

        String resultMake = responsePage.getMake();
        assert(expectedMake.equals(resultMake));

        String resultModel = responsePage.getModel();
        assert(expectedModel.equals(resultModel));

        String resultColour = responsePage.getColour();
        assert(expectedColour.equals(resultColour));

        String resultYear = responsePage.getYear();
        assert(expectedYear.equals(resultYear));


    }
}

