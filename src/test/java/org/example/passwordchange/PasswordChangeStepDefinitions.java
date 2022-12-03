package org.example.passwordchange;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordChangeStepDefinitions {

    private WebDriver driver;

    @Given("user fill form with new password")
    public void fillChangePasswordForm() {
        driver.get("http://multibags.1dt.com.br/shop/customer/password.html");

        WebElement currentPassword = driver.findElement(By.id("currentPassword"));
        WebElement newPassword = driver.findElement(By.id("password"));
        WebElement repeatPassword = driver.findElement(By.id("checkPassword"));

        currentPassword.sendKeys("123456");
        newPassword.sendKeys("098765");
        repeatPassword.sendKeys("098765");
    }

    @Given("user log in")
    public void logIn() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://multibags.1dt.com.br/shop/customer/customLogon.html");

        WebElement email = driver.findElement(By.id("signin_userName"));
        WebElement password = driver.findElement(By.id("signin_password"));

        email.sendKeys("change@password.com");
        password.sendKeys("123456");

        WebElement loginButton = driver.findElement(By.id("genericLogin-button"));
        loginButton.click();

        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().startsWith("http://multibags.1dt.com.br/shop/customer/dashboard.html");
            }
        });
    }

    @When("user clicks change password")
    public void clickChangePassword() {
        WebElement loginButton = driver.findElement(By.id("submitChangePassword"));
        loginButton.click();
    }

    @When("user changes password back to old")
    public void changePasswordBackToOld() {
        WebElement currentPassword = driver.findElement(By.id("currentPassword"));
        WebElement newPassword = driver.findElement(By.id("password"));
        WebElement repeatPassword = driver.findElement(By.id("checkPassword"));

        currentPassword.sendKeys("098765");
        newPassword.sendKeys("123456");
        repeatPassword.sendKeys("123456");

        WebElement loginButton = driver.findElement(By.id("submitChangePassword"));
        loginButton.click();
    }

    @Then("change password success message is displayed")
    public void successMessage() {
        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("store.success")).isDisplayed();
            }
        });
        driver.quit();
    }
}
