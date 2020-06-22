package bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IndexPage {

    private WebDriver driver;
    private String pageUrl = "https://cartaxcheck.co.uk";

    public IndexPage(WebDriver driver) {

        this.driver = driver;
    }

    public void goToPage() {

        driver.get(pageUrl);

    }

    public void setRegistrationNumber (String RegistrationNumber) {
        String inputXPath = "//*[@id=\"vrm-input\"]";
        WebElement registrationField = driver.findElement(By.xpath(inputXPath));
        registrationField.sendKeys(RegistrationNumber);
    }

    public void submitFreeCarCheck() {

        String submitFreeCheckXPath = "//*/form/button";
        WebElement submitFreeCheck = driver.findElement(By.xpath(submitFreeCheckXPath));
        submitFreeCheck.click();
    }
}
