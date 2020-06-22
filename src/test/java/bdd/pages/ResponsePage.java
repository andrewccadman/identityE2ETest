package bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResponsePage {

    private WebDriver driver;

    public ResponsePage(WebDriver driver) {

        this.driver = driver;
    }

    public String getRegistrationNumber() {
        String registrationNumberXPath = "//body/div/div/div/div[3]/div[1]/div/span/div[2]/dl[1]/dd";
        WebDriverWait wait = new WebDriverWait(driver, 2);

        WebElement registrationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(registrationNumberXPath)));
        return registrationField.getText();
    }

    public String getMake() {
        String registrationNumberXPath = "//body/div/div/div/div[3]/div[1]/div/span/div[2]/dl[2]/dd";
        WebDriverWait wait = new WebDriverWait(driver, 2);

        WebElement registrationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(registrationNumberXPath)));
        return registrationField.getText();
    }

    public String getModel() {
        String registrationNumberXPath = "//body/div/div/div/div[3]/div[1]/div/span/div[2]/dl[3]/dd";
        WebDriverWait wait = new WebDriverWait(driver, 2);

        WebElement registrationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(registrationNumberXPath)));
        return registrationField.getText();
    }

    public String getColour() {
        String registrationNumberXPath = "//body/div/div/div/div[3]/div[1]/div/span/div[2]/dl[4]/dd";
        WebDriverWait wait = new WebDriverWait(driver, 2);

        WebElement registrationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(registrationNumberXPath)));
        return registrationField.getText();
    }

    public String getYear() {
        String registrationNumberXPath = "//body/div/div/div/div[3]/div[1]/div/span/div[2]/dl[5]/dd";
        WebDriverWait wait = new WebDriverWait(driver, 2);

        WebElement registrationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(registrationNumberXPath)));
        return registrationField.getText();
    }


}
