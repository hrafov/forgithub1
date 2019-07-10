package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

public class HomePagePo extends AbstractPage {

    @LogMessage("dropDownMenu")
    @FindBy(css = "a.ignore-react-onclickoutside.user-info")
    private PageElement dropDownMenu;
    @LogMessage("logout")
    @FindBy(css = "ul.dropdown.production.open>li:nth-child(4)>a>span")
    private PageElement logout;
    @LogMessage("myStuff")
    @FindBy(css = "ul.dropdown.production.open>li:nth-child(2)>a>span")
    private PageElement myStuff;
    @LogMessage("profileButton")
    @FindBy(css = "span.profile-name")
    private PageElement profileButton;
    @LogMessage("createButton")
    @FindBy(css = "a[href=\"/projects/editor/\"]")
    private PageElement createButton;

    public PageElement getDropDownMenu() {
        return dropDownMenu;
    }

    public PageElement getLogout() {
        return logout;
    }
    
    public PageElement getMyStuff() {
        return myStuff;
    }
    
    public PageElement getProfileButton() {
        return profileButton;
    }
    
    public PageElement getCreateButton() {
        return createButton;
    }

}
