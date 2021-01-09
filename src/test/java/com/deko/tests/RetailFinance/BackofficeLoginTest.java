package com.deko.tests.RetailFinance;

import com.deko.testing.robot.backoffice.BackofficeRobot;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BackofficeLoginTest {

    private WebDriver driver;
    String username="Fatih.Vursavas";
    String password="DekoQA2020";


    @BeforeTest
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @AfterTest
    public void testTearDown(){
        driver.close();
    }

    @AfterSuite
    public void suiteTearDown(){
        driver.quit();
    }

    @Test
    public void backOfficeLoginPageLoadSuccess(){
        BackofficeRobot robot = new BackofficeRobot(driver);
        robot
                .openBackofficeLoginPage()
                .verifyBackofficeUrl();

        Assert.assertTrue(robot.verifyBackofficeUrl());

    }

    //todo: Write the rest of the tests for the backoffice login page here.
    //todo: Chrome driver should spin up, pass all tests identified (unless you find a bug?) and quit.

    @Test
    public void navigateLoginPage(){

        BackofficeRobot robot=new BackofficeRobot(driver);
        robot.fillLoginUsername(username);
        robot.fillLoginPassword(password);
        robot.submitLoginForm();

    }

    @Test
    public void verifyLogin() throws InterruptedException {
        BackofficeRobot robot=new BackofficeRobot(driver);
        robot.verifySuccessfulLogin();

        Thread.sleep(2000);

        robot.logOut();

        Thread.sleep(2000);
    }


    @Test
    public void verifyResetPassword() throws InterruptedException {
        BackofficeRobot robot=new BackofficeRobot(driver);
        backOfficeLoginPageLoadSuccess();
        Thread.sleep(3000);
        robot.clickForgottenPasswordLink();
        robot.fillResetPasswordUserName(username);
        robot.resetPassword();
        robot.verifyResetPasswordSuccess();

        Assert.assertTrue(robot.verifyResetPasswordSuccess());


    }

    @Test
    public void verifySignInErrorMessage () throws InterruptedException {
        BackofficeRobot robot=new BackofficeRobot(driver);
        robot.openBackofficeLoginPage();
        Thread.sleep(3000);
        robot.fillLoginUsername("Fatih.Vursavas");
        robot.fillLoginPassword("11111");
        robot.submitLoginForm();
        String text="Sorry, the details you provided were incorrect.";
        robot.verifySignInError(text);


    }
}
