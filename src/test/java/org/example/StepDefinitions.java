package org.example;

import io.cucumber.java.en.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitions {

    private WebDriver driver;

    @Given("an example scenario")
    public void anExampleScenario() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://multibags.1dt.com.br/shop/customer/customLogon.html");
    }

    @When("all step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
        WebElement email = driver.findElement(By.id("signin_userName"));
        WebElement password = driver.findElement(By.id("signin_password"));
        WebElement loginButton = driver.findElement(By.id("genericLogin-button"));

        email.sendKeys("test@email.com");
        password.sendKeys("1234");

        loginButton.click();
    }

    @Then("the scenario passes")
    public void theScenarioPasses() {
        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("loginError")).isDisplayed();
            }
        });
        driver.quit();
    }

}
