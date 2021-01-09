package com.deko.testing.robot.backoffice;

import com.deko.testing.robot.BaseRobot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BackofficeRobot extends BaseRobot {

    public BackofficeRobot(WebDriver driver) { super(driver);}

    @FindBy(name = "LoginForm")
    private WebElement loginForm;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/form/div[2]/input")
    private WebElement usernameField;

    @FindBy(xpath = "/html/body/div/div/div/div/div/form/div[3]/input")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@class = \"btn btn-link forgotten-link\"]")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//button[@class=\"btn btn-sm btn-primary\"]")
    private WebElement signInButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/form/div[1]/div/div/p")
    private WebElement signInError;

    // I added this two webelement to sign out

    @FindBy(xpath = "(//a[@class='dropdown-toggle btn btn-default'])[1]")
    private WebElement userIconButton;

    @FindBy(xpath = "//a[@data-ng-click='logout()']")
    private WebElement logOutButton;

    //todo: locate this webelement which will need to be used in later methods and tests.
    @FindBy(xpath = "//input[@type=\"text\"]")
    private WebElement resetPasswordField;

    //todo: locate this webelement which will need to be used in later methods and tests.
    @FindBy(xpath = "//button[@class=\"btn btn-sm btn-primary\"]")
    private WebElement resetButton;

    //todo: locate this webelement which will need to be used in later methods and tests.
    @FindBy(xpath = "//span[@data-ng-transclude]")
    private WebElement resetSignInButton;

    //todo: locate this webelement which will need to be used in later methods and tests.
    @FindBy(xpath = "//p[@data-ng-if=\"Response.Message\"]")
    private WebElement resetSuccessText;

    @FindBy(id = "top-bar")
    private WebElement backOfficeDashboardTopBar;

    //@FindBy(xpath = "//h4[@class=\"ng-binding\"]");
    //private WebElement pageTitle;

    private final String baseUrl = "https://release.dekopay.org/backoffice/v2/#/"; //insert provided test url here

    public BackofficeRobot openBackofficeLoginPage(){
        goTo(baseUrl);
        wait.until(ExpectedConditions.visibilityOf(this.loginForm));
        return this;
    }

    public BackofficeRobot fillLoginUsername(String username){
        type(usernameField, username);
        return this;
    }

    public BackofficeRobot fillLoginPassword(String password){
        type(passwordField, password);
        return this;
    }

    public BackofficeRobot submitLoginForm() {
        click(signInButton);
        //waitUntilNotVisible(signInButton);
        return this;
    }

    public BackofficeRobot clickForgottenPasswordLink(){
        click(forgotPasswordLink);
        waitUntilURLContains("reset");
        return this;
    }


    public BackofficeRobot fillResetPasswordUserName(String username){
        type(resetPasswordField, username);
        return this;
    }


    public BackofficeRobot resetPassword(){
        //todo: Complete this method
        click(resetSignInButton);
        return this;
    }

    public boolean verifySignInError(String text){
        //todo: Complete this method, so that tests can pass in expected error text

        return WebElementContains(signInError,text);
    }

    public boolean verifyBackofficeUrl(){
        if (verifyURLContains("backoffice")){
            return true;
        }
        return false;
    }

    public boolean verifySuccessfulLogin(){
        //todo: Complete this verify method, to be used by test class
        return WebElementContains(backOfficeDashboardTopBar, "Fatih");
    }

    public boolean verifyResetPasswordSuccess(){
        //todo: Complete this verify method, to be used by test class
        return WebElementContains(resetSuccessText, "If the username exists, a password reset email has been sent to the connected email address. Please contact your account manager if you need further assistance.");

    }
    // I added this log out method
    public BackofficeRobot logOut() throws InterruptedException {
        //todo: Complete this method
        Thread.sleep(500);
        click(userIconButton);
        Thread.sleep(500);
        click(logOutButton);
        return this;
    }
}
