package org.example.login;

import io.cucumber.java.en.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefinitions {

    private WebDriver driver;

    @Given("user input unregistered email in login page")
    public void anExampleScenario() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://multibags.1dt.com.br/shop/customer/customLogon.html");

        WebElement email = driver.findElement(By.id("signin_userName"));
        WebElement password = driver.findElement(By.id("signin_password"));

        email.sendKeys("test@email.com");
        password.sendKeys("1234");
    }

    @When("user clicks sign in button")
    public void allStepDefinitionsAreImplemented() {
        WebElement loginButton = driver.findElement(By.id("genericLogin-button"));
        loginButton.click();
    }

    @Then("login failed error message is displayed")
    public void theScenarioPasses() {
        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("loginError")).isDisplayed();
            }
        });
        driver.quit();
    }

    @Given("user input registered email in login page")
    public void validanExampleScenario() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://multibags.1dt.com.br/shop/customer/customLogon.html");

        WebElement email = driver.findElement(By.id("signin_userName"));
        WebElement password = driver.findElement(By.id("signin_password"));

        email.sendKeys("bancoguedes@gmail.com");
        password.sendKeys("Abd12345");
    }

    @When("user clicks sign in button ok")
    public void validallStepDefinitionsAreImplemented() {
        WebElement loginButton = driver.findElement(By.id("genericLogin-button"));
        loginButton.click();
    }

    @Then("login sucess")
    public void validtheScenarioPasses() {
        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("login")).isDisplayed();
            }
        });
        driver.quit();
    }
}
