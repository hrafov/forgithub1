package com.epam.lab.page;

import org.openqa.selenium.support.FindBy;
import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;

public class CreateProjectPagePo extends AbstractPage {
	
	@LogMessage("events Button")    
	@FindBy(xpath = "//div[contains(text(),'Events')]")
    private PageElement eventsButton;
	@LogMessage("motion Button")    
	@FindBy(xpath = "//div[contains(text(),'Motion')]")
    private PageElement motionButton;
	@LogMessage("dropDownMenu")
	@FindBy(xpath = "//html/body/div/div/div[2]/div[2]/div[2]")
	private PageElement dropDownMenu;
	@LogMessage("logout")
    @FindBy(xpath = "//span[contains(text(),'Sign out')]")
    private PageElement logout;
	@LogMessage("Go Button")
    @FindBy(css = "img[title=\"Go\"]")
    private PageElement goButton;
	
	public PageElement eventsButton() {
        return eventsButton;
    }
	
	public PageElement motionButton() {
        return motionButton;
    }
	
	public PageElement getDropDownMenu() {
        return dropDownMenu;
    }
	
	public PageElement getLogout() {
        return logout;
    }
	
	public PageElement getGoButton() {
        return goButton;
    }
	
}
