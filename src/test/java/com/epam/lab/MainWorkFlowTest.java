package com.epam.lab;

import com.epam.lab.business.HomePageBo;
import com.epam.lab.business.LoginPageBo;
import com.epam.lab.business.MyStaffBo;
import com.epam.lab.business.ProjectDrums2Bo;
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
public class MainWorkFlowTest implements ITestNGListener {
	private LoginPageBo loginPageBo;
    private HomePageBo homePageBo;
    private MyStaffBo myStaffBo;
    private ProjectDrums2Bo projectDrums2Bo;
    private User user;
    private String currentURL;
    
    @BeforeTest
    @Description("Loading configurations before test")
    public void setup() {
        user = CsvParser.createObjectsFromCredCsv(CREDENTIALS_CSV_PATH);
        loginPageBo = new LoginPageBo();
        homePageBo = new HomePageBo();
        myStaffBo = new MyStaffBo();
        projectDrums2Bo = new ProjectDrums2Bo();
    }
	
    @Test(description = "Main WorkFlow test")
    @Description("MainWorkFlowTest Description: To test Main Workflow")
    @Severity(SeverityLevel.NORMAL)
    public void mainWorkFlowTest() {    	
        loginPageBo.logIn(user.getLogin(), user.getPassword());
        Assert.assertEquals(user.getLogin(), homePageBo.getNameFromProfileButton());     
        homePageBo.myStuff();
        currentURL = DriverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(currentURL,"https://scratch.mit.edu/mystuff/");        
        myStaffBo.drums2();        
     // for visibility only   
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
     
        currentURL = DriverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(currentURL,"https://scratch.mit.edu/projects/287351264/");      
        
        projectDrums2Bo.startWithGoButton();        
     // for visibility only        
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}        
//TODO add assertion (i didn't find any clue 4 this)        
        homePageBo.logout();        
    }
    
    @AfterTest
    @Description("Exit from program")
    public void quit() {
        DriverManager.removeDriver();
    }
    
}
