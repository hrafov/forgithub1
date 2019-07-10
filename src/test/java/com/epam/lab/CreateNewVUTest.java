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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

@Listeners({ TestListener.class })
public class CreateNewVUTest implements ITestNGListener {
	private LoginPageBo loginPageBo;
	private HomePageBo homePageBo;
	private User user;
	private int vuNumber = 0;
//    private String currentURL;

	@BeforeTest
	@Description("Loading configurations before test")
	public void setup() {
		user = CsvParser.createObjectsFromCredCsv(CREDENTIALS_CSV_PATH);
		loginPageBo = new LoginPageBo();
		homePageBo = new HomePageBo();
	}

	@Test(description = "Create New VU Scenario with new username and new password")
	@Description("CreateNewVU Description: test with new username and new password")
	@Severity(SeverityLevel.NORMAL)
	public void CreateNewVU() {
		
		try (InputStream input = new FileInputStream(PROPERTIES_PATH)) {
			Properties prop = new Properties();
			prop.load(input);
			vuNumber = Integer.parseInt(prop.getProperty("vuNumber"));
			//System.out.println("+++++ vunumber = " + vuNumber);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		loginPageBo.joinScratch(user.getLogin() + vuNumber, user.getPassword());
		Assert.assertEquals(user.getLogin() + vuNumber, homePageBo.getNameFromProfileButton());

		// ++vuNumber to config.properties
		try (OutputStream output = new FileOutputStream(PROPERTIES_PATH)) {
			Properties prop = new Properties();
			prop.setProperty("vuNumber", String.valueOf(++vuNumber));
			// save properties to project root folder
			prop.store(output, null);
		} catch (IOException io) {
			io.printStackTrace();
		}

		homePageBo.logout();
	}

	@AfterTest
	@Description("Exit from program")
	public void quit() {
		DriverManager.removeDriver();
	}

}
