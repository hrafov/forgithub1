package com.epam.lab.business;

import org.apache.log4j.Level;

import com.epam.lab.core.util.MyLogger;
//import com.epam.lab.page.MyStaffPo;
import com.epam.lab.page.ProjectDrums2Po;

import io.qameta.allure.Step;

public class ProjectDrums2Bo {
	
	private ProjectDrums2Po projectDrums2Po;

	  public ProjectDrums2Bo() {
		  projectDrums2Po = new ProjectDrums2Po();
	      MyLogger myLogger = new MyLogger();
	      myLogger.setLevel(Level.INFO);
	  }

	  @Step("ProjectDrum2Bo Step: start project drums2...")
	  public void startWithGoButton() {  	
		  projectDrums2Po.getGoButton().click();
	  }
}
