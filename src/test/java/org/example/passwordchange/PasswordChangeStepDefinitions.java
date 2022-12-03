package org.example.passwordchange;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class PasswordChangeStepDefinitions {

    private WebDriver driver;

    @When("user fill password change form")
    public void fillChangePasswordForm() {
        WebElement currentPassword = driver.findElement(By.id("currentPassword"));
        WebElement newPassword = driver.findElement(By.id("password"));
        WebElement repeatPassword = driver.findElement(By.id("checkPassword"));

        currentPassword.sendKeys("123456");
        newPassword.sendKeys("098765");
        repeatPassword.sendKeys("098765");
    }

    @When("user go to change password page")
    public void goToChangePassword() {
        driver.get("http://multibags.1dt.com.br/shop/customer/password.html");
        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("formError")).isDisplayed();
            }
        });
    }

    @When("user clicks change password")
    public void clickChangePassword() {
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

    @When("user fill password change form with new password different than repeat password")
    public void fillChangePasswordFormMismatch() {
        WebElement currentPassword = driver.findElement(By.id("currentPassword"));
        WebElement newPassword = driver.findElement(By.id("password"));
        WebElement repeatPassword = driver.findElement(By.id("checkPassword"));

        currentPassword.sendKeys("123456");
        newPassword.sendKeys("098765");
        repeatPassword.sendKeys("bfdihfiudhf");
    }

    @Then("both password must match message must be displayed")
    public void passwordMismatchMessage() {
        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return Objects.equals(d.findElement(By.id("formError")).getText(), "Both password must match");
            }
        });
        driver.quit();
    }
}
