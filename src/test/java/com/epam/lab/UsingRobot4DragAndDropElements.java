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
import com.epam.lab.core.util.reportListeners.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.ITestNGListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//import static com.epam.lab.core.util.Constants.*;

@Listeners({ TestListener.class })
public class UsingRobot4DragAndDropElements implements ITestNGListener {
	@SuppressWarnings("unused")
	private LoginPageBo loginPageBo;
	private HomePageBo homePageBo;
	private CreateProjectPageBo createProjectPageBo;	
	private String currentURL;
	private int delay = 2000;

	@BeforeTest
	@Description("Loading configurations before test")
	public void setup() {		
		loginPageBo = new LoginPageBo();
		homePageBo = new HomePageBo();
		createProjectPageBo = new CreateProjectPageBo();
	}

	@Test(description = "Robot4DragAndDropElements test")
	@Description("Robot4DragAndDropTest Description: To test Java Robot class 4 dragAnddrop")
	@Severity(SeverityLevel.NORMAL)
	public void Robot4DragAndDropTest() throws AWTException {
		
		homePageBo.createButtonWithoutLogin();
		currentURL = DriverManager.getDriver().getCurrentUrl();
		Assert.assertEquals(currentURL, "https://scratch.mit.edu/projects/editor/?tutorial=getStarted");
		
            // 4future parameterization of different screen dimensions
			// Point p = MouseInfo.getPointerInfo().getLocation();
			// System.out.println("===== x = " + p.x + "  ===== y = " + p.y);
			//                     width and height of screen
			// Toolkit toolkit = Toolkit.getDefaultToolkit();
			// Dimension d = toolkit.getScreenSize();
			// System.out.println(" ===== d.width = " + d.width +
			// " ==== d.height = " + d.height);
		
			Robot robot = new Robot();
			createProjectPageBo.eventsButton();
			movingObject(robot, 100, 260, 500, 260,    delay);   // moving whenClicked object
			createProjectPageBo.motionButton();			
			movingObject(robot,  86, 260, 500, 260+38, delay); // moving move10steps object
			createProjectPageBo.soundButton();
			movingObject(robot, 100, 260, 500, 260+76, delay);// moving playSoundMeow object

			for (int i = 0; i < 5; i++) {
				createProjectPageBo.startWithGoButton();
			}
			
//TODO like assertion - robot.createScreenCapture(arg0);
			
	}
	
	// moving object from point x1,y1 to point x2,y2 with delay in milliseconds
	private void movingObject(Robot r, int x1, int y1, int x2, int y2, int delay){ 
		r.delay(delay);
		r.mouseMove(x1, y1);
		r.delay(delay);
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		r.delay(delay);
		r.mouseMove(x2, y2);
		r.delay(delay);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		r.delay(delay);
	}

	@AfterTest
	@Description("Exit from program")
	public void quit() {
		DriverManager.removeDriver();
	}

}
