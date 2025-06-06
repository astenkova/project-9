package com.nextBaseCRM.pages;


import com.nextBaseCRM.utilities.ConfigurationReader;
import com.nextBaseCRM.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.Utilities;
import java.time.Duration;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
    Actions actions = new Actions(Driver.getDriver());

    @FindBy(name="USER_LOGIN")
    public WebElement userName;

    @FindBy(name="USER_PASSWORD")
    public WebElement password;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    public WebElement login;

    @FindBy(xpath = "//span[.='CRM']")
    public WebElement crmText;

    @FindBy(xpath = "//div[@class='errortext']")
    public WebElement errorText;


    public void enterValidUserName () {
        wait.until(ExpectedConditions.elementToBeClickable(userName));
        userName.sendKeys(ConfigurationReader.getProperty("username"));
        // verification that we logged
    }

    public void enterInvalidUserName () {
        wait.until(ExpectedConditions.elementToBeClickable(userName));
        userName.sendKeys(("group9@cydeo.com"));
        // verification that we logged
    }



    public void enterValidPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys(ConfigurationReader.getProperty("password"));
    }

    public void enterInvalidPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys("user1");
    }

    public void clickLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(login));
        login.click();
    }

    public  String loginVerification() {
        wait.until(ExpectedConditions.visibilityOf(crmText));

        return crmText.getText();
    }

    public String getErrorText(){
        wait.until(ExpectedConditions.visibilityOf(errorText));
        return errorText.getText();
    }




}
