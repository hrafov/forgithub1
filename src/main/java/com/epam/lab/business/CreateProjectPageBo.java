package com.epam.lab.business;

import org.apache.log4j.Level;
import com.epam.lab.core.util.MyLogger;
import com.epam.lab.page.CreateProjectPagePo;
import io.qameta.allure.Step;

public class CreateProjectPageBo {

	private CreateProjectPagePo createProjectPagePo;

	public CreateProjectPageBo() {
		createProjectPagePo = new CreateProjectPagePo();
		MyLogger myLogger = new MyLogger();
		myLogger.setLevel(Level.INFO);
	}

	@Step("CreateProjectPageBo Step: push Events button...")
	public void eventsButton() {
		createProjectPagePo.eventsButton().click();
	}

	@Step("CreateProjectPageBo Step: push Motion button...")
	public void motionButton() {
		createProjectPagePo.motionButton().click();
	}
	
	@Step("CreateProjectPageBo Step: push Sound button...")
	public void soundButton() {
		createProjectPagePo.soundButton().click();
	}

	@Step("CreateProjectPageBo Step: logout...")
	public void logout() {
		createProjectPagePo.getDropDownMenu().click();
		createProjectPagePo.getLogout().click();
	}

	@Step("CreateProjectPageBo Step: start project with GO button(green flag)...")
	public void startWithGoButton() {
		createProjectPagePo.getGoButton().click();
	}

}
