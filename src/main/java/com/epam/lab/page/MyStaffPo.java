package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

public class MyStaffPo extends AbstractPage {

    @LogMessage("projectDrums2")
    @FindBy(xpath = "//a[contains(text(),'Drums2')]")
    private PageElement drums2Button;

    public PageElement getDrums2() {
        return drums2Button;
    }

}
