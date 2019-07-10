package com.epam.lab.page;

import org.openqa.selenium.support.FindBy;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;

public class ProjectDrums2Po extends AbstractPage {
	
	@LogMessage("Go Button")
    @FindBy(css = "img[title=\"Go\"]")
    private PageElement goButton;
	
	public PageElement getGoButton() {
        return goButton;
    }
	
}
