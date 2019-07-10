package com.epam.lab;

import com.epam.lab.business.HomePageBo;
import com.epam.lab.business.LoginPageBo;
import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.CsvParser;
import com.epam.lab.core.util.User;
import com.epam.lab.core.util.reportListeners.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
//import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestNGListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.lab.core.util.Constants.*;

@Listeners({TestListener.class})
public class LogInTest implements ITestNGListener {
    private LoginPageBo loginPageBo;
    private HomePageBo homePageBo;
    private User user;
    //private String currentURL;

    @BeforeTest
    @Description("Loading configurations before test")
    public void setup() {
        user = CsvParser.createObjectsFromCredCsv(CREDENTIALS_CSV_PATH);
        loginPageBo = new LoginPageBo();
        homePageBo = new HomePageBo();
    }

    @Test(/*priority = 8,*/ description = "LogInTest Scenario with valid username and valid password")
    @Description("LogInTest Description: Login test valid login and valid password")
    @Severity(SeverityLevel.NORMAL)
    public void logInTestWithValidLoginAndValidPassword() {   	
        loginPageBo.logIn(user.getLogin(), user.getPassword());
        Assert.assertEquals(user.getLogin(), homePageBo.getNameFromProfileButton());        
        homePageBo.logout();                
    }    

    @Test(/*priority = 1,*/ description = "LogInTest Scenario with blank username and blank password")
    @Description("LogInTest Description: blank login and password")
    @Severity(SeverityLevel.NORMAL)
    public void logInTestWithBlankLoginAndPassword() {
        loginPageBo.logIn("", "");          
        loginPageBo.clickSubmit();        
//        currentURL = DriverManager.getDriver().getCurrentUrl();
//        System.out.println("currentURL = " + currentURL);      
        loginPageBo = new LoginPageBo();        
    }

    @Test(/*priority = 5,*/ description = "LogInTest Scenario with invalid username and invalid password")
    @Description("LogInTest Description: invalid login and invalid password")
    @Severity(SeverityLevel.NORMAL)
    public void logInTestWithInvalidLoginAndInvalidPassword() {
        loginPageBo.logIn(INVALID_LOGIN, INVALID_PASSWORD);
        loginPageBo = new LoginPageBo();        
    }

    @Test(/*priority = 6,*/ description = "LogInTest Scenario with invalid username and valid password")
    @Description("LogInTest Description:invalid login and valid password")
    @Severity(SeverityLevel.NORMAL)
    public void logInTestWithInvalidLoginAndValidPassword() {
        loginPageBo.logIn(INVALID_LOGIN, user.getPassword());
        loginPageBo = new LoginPageBo();
    }

    @Test(/*priority = 7,*/ description = "LogInTest Scenario with valid username and invalid password")
    @Description("LogInTest Description:valid login and invalid password")
    @Severity(SeverityLevel.NORMAL)
    public void logInTestWithValidLoginAndInvalidPassword() {
        loginPageBo.logIn(user.getLogin(), INVALID_PASSWORD);
        loginPageBo = new LoginPageBo();
    }

    @AfterTest
    @Description("Exit from program")
    public void quit() {
        DriverManager.removeDriver();
    }

}