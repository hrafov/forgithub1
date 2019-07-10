package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

public class LoginPagePo extends AbstractPage {
	
	@LogMessage("SingIn")
    @FindBy(css = "a.ignore-react-onclickoutside")
    private PageElement signInButton;
    @LogMessage("Username")
    @FindBy(id = "frc-username-1088")
    private PageElement loginField;
    @LogMessage("Password")
    @FindBy(id = "frc-password-1088")
    private PageElement passwordField;
    @LogMessage("Submit")
    @FindBy(css = "button.button.submit-button.white")
    private PageElement submitButton;
    @LogMessage("JoinScratch")
    @FindBy(css = "ul>li:nth-child(7)")
    private PageElement joinScratchButton;
    @LogMessage("newLoginField")
    @FindBy(css = "input.username")
    private PageElement newLoginField;
    @LogMessage("newPasswordField")
    @FindBy(css = "input.password")
    private PageElement newPasswordField;
    @LogMessage("confirmNewPasswordField")
    @FindBy(css = "input.password-confirm")
    private PageElement confirmNewPasswordField;
    @LogMessage("nextButton")
    @FindBy(css = "input.registration-next.button.primary")
    private PageElement nextButton;
    @LogMessage("birthMonthsDropDownMenu")
    @FindBy(css = "select.birthmonth")
    private PageElement birthMonthsDropDownMenu;
    @LogMessage("birthYearsDropDownMenu")
    @FindBy(css = "select.birthyear")
    private PageElement birthYearsDropDownMenu;
    @LogMessage("maleRadioButton")
    @FindBy(xpath = "//input[@value=\"male\"]")
    private PageElement maleRadioButton;
    @LogMessage("countryDropDownMenu")
    @FindBy(css = "select.country")
    private PageElement country;
    @LogMessage("emailField")
    @FindBy(css = "input.email")
    private PageElement emailField;
    @LogMessage("emailConfirmField")
    @FindBy(css = "input.email-confirm")
    private PageElement emailConfirmField;
    @LogMessage("okLetsGoButton")
    @FindBy(css = "input.registration-done.hide.button.primary")
    private PageElement okLetsGoButton;

    public PageElement getSignInButton() {
        return signInButton;
    }
    public PageElement getLoginField() {
        return loginField;
    }

    public PageElement getPasswordField() {
        return passwordField;
    }

    public PageElement getSubmitButton() {
        return submitButton;
    }
    
    public PageElement getJoinScratchButton() {
        return joinScratchButton;
    }
    
    public PageElement getNewLoginField() {
        return newLoginField;
    }
    
    public PageElement getNewPasswordField() {
        return newPasswordField;
    }
    
    public PageElement getConfirmNewPasswordField() {
        return confirmNewPasswordField;
    }
    
    public PageElement getNextButton() {
        return nextButton;
    }
    
    public PageElement getBirthMonths() {
        return birthMonthsDropDownMenu;
    }
    
    public PageElement getBirthYears() {
        return birthYearsDropDownMenu;
    }
        
    public PageElement getMaleRadioButton() {
        return maleRadioButton;
    }
    
    public PageElement getCountry() {
        return country;
    }
    
    public PageElement getEmailField() {
        return emailField;
    }
    
    public PageElement getEmailConfirmField() {
        return emailConfirmField;
    }
    
    public PageElement getOKLetsGoButton() {
        return okLetsGoButton;
    }
}
