package com.epam.lab;

import java.awt.AWTException;
//import java.awt.Dimension;
//import java.awt.MouseInfo;
//import java.awt.Point;
import java.awt.Robot;
//import java.awt.Toolkit;
import java.awt.event.InputEvent;
import com.epam.lab.business.HomePageBo;
import com.epam.lab.business.LoginPageBo;
import com.epam.lab.business.CreateProjectPageBo;
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

@Listeners({ TestListener.class })
public class UsingRobot4DragAndDropElements implements ITestNGListener {

	private LoginPageBo loginPageBo;
	private HomePageBo homePageBo;
	private CreateProjectPageBo createProjectPageBo;
	private User user;
	private String currentURL;
	private int delayInSeconds = 5000;

	@BeforeTest
	@Description("Loading configurations before test")
	public void setup() {
		user = CsvParser.createObjectsFromCredCsv(CREDENTIALS_CSV_PATH);
		loginPageBo = new LoginPageBo();
		homePageBo = new HomePageBo();
		createProjectPageBo = new CreateProjectPageBo();
	}

	@Test(description = "Robot4DragAndDropElements test")
	@Description("Robot4DragAndDropTest Description: To test Java Robot class 4 dragAnddrop")
	@Severity(SeverityLevel.NORMAL)
	public void Robot4DragAndDropTest() {
		loginPageBo.logIn(user.getLogin(), user.getPassword());
		Assert.assertEquals(user.getLogin(),
				homePageBo.getNameFromProfileButton());

		homePageBo.createButton();
		currentURL = DriverManager.getDriver().getCurrentUrl();
		Assert.assertEquals(currentURL,
				"https://scratch.mit.edu/projects/editor/");

		createProjectPageBo.eventsButton();

		try {
			// 4fun Point p = MouseInfo.getPointerInfo().getLocation();
			// System.out.println("===== x = " + p.x + "  ===== y = " + p.y);
			//                     width and height of screen
			// Toolkit toolkit = Toolkit.getDefaultToolkit();
			// Dimension d = toolkit.getScreenSize();
			// System.out.println(" ===== d.width = " + d.width +
			// " ==== d.height = " + d.height);
			Robot robot = new Robot();

			// moving when clicked object
			robot.mouseMove(100, 260);
			robot.delay(delayInSeconds);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.delay(delayInSeconds);
			robot.mouseMove(500, 260);
			robot.delay(delayInSeconds);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			robot.delay(delayInSeconds);

			createProjectPageBo.motionButton();

			// moving move10steps object
			robot.delay(delayInSeconds);
			robot.mouseMove(86, 260);
			robot.delay(delayInSeconds);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.delay(delayInSeconds);
			robot.mouseMove(500, 260 + 38);
			robot.delay(delayInSeconds);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			robot.delay(delayInSeconds);

			for (int i = 0; i < 10; i++) {
				createProjectPageBo.startWithGoButton();
			}

			//TODO like assertion - robot.createScreenCapture(arg0);
		} catch (AWTException e1) {
			e1.printStackTrace();
		}

		createProjectPageBo.logout();
	}

	@AfterTest
	@Description("Exit from program")
	public void quit() {
		DriverManager.removeDriver();
	}

}
