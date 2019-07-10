package com.epam.lab.business;

import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.MyLogger;
import com.epam.lab.page.LoginPagePo;
import io.qameta.allure.Step;
import org.apache.log4j.Level;
import static com.epam.lab.core.util.Constants.LOGIN_PAGE_URL;
import org.openqa.selenium.support.ui.Select;

public class LoginPageBo {

    private LoginPagePo loginPagePo;

    public LoginPageBo() {
        loginPagePo = new LoginPagePo();
        DriverManager.getDriver().get(LOGIN_PAGE_URL);
        MyLogger myLogger = new MyLogger();
        myLogger.setLevel(Level.INFO);
    }

    @Step("LoginPageBO with login: {0}, password: {1} for method: {logIn} step...")
    public void logIn(String login, String password) {
    	clickSignIn();
        enterLogin(login);
        enterPassword(password);
        clickSubmit();
    }

    @Step("PageElementBO Step: Submit login form in login page in method: {clickSubmit}...")
    public void clickSignIn() {
        loginPagePo.getSignInButton().click();
    }
    
    @Step("PageElementBO Step: Enter login: {0} in login input field in method: {enterLogin}...")
    public void enterLogin(String login) {
        loginPagePo.getLoginField().clear();
        loginPagePo.getLoginField().sendKeys(login);
    }

    @Step("PageElementBO Step: Enter password: {0} in password input field in method: {enterPassword}...")
    public void enterPassword(String password) {
        loginPagePo.getPasswordField().clear();
        loginPagePo.getPasswordField().sendKeys(password);
    }

    @Step("PageElementBO Step: Submit login form in login page in method: {clickSubmit}...")
    public void clickSubmit() {
        loginPagePo.getSubmitButton().click();
    }    

    @Step("PageElementBO Step: Click JoinScratch button in login page in method: {clickJoinScratch}...")
    public void joinScratch(String newLogin, String newPassword) {
    	clickJoinScratch();
        // there is a frame number 0 - first step of registration 	
    	DriverManager.getDriver().switchTo().frame(0);    	
    	enterNewLogin(newLogin);
    	enterNewPassword(newPassword);
    	confirmNewPassword(newPassword);
    	clickNext(); 
        // end of first step of registration
    	selectAndClickBirthMonth(1);    	    	
    	selectAndClickBirthYear(1);    	    	
    	clickRadioButtonGenderMale();
    	selectAndClickCountry(1);    	   	
    	clickNext();
        // end of second step of registration
    	inputEmail("hrafov@gmail.com");
    	inputEmailConfirm("hrafov@gmail.com");
    	clickNext();
        // end of third step of registration
    	okLetsGoButton();
    }
    
    @Step("PageElementBO Step: Click on JoinScratch in login page in method: {clickJoinScratch}...")
    public void clickJoinScratch() {
        loginPagePo.getJoinScratchButton().click();
    }
    
    @Step("PageElementBO Step: Enter login: {0} in login input field in method: {enterNewLogin}...")
    public void enterNewLogin(String login) {
        loginPagePo.getNewLoginField().clear();
        loginPagePo.getNewLoginField().sendKeys(login);
    }
    
    @Step("PageElementBO Step: Enter password: {0} in password input field in method: {enterNewPassword}...")
    public void enterNewPassword(String password) {
        loginPagePo.getNewPasswordField().clear();
        loginPagePo.getNewPasswordField().sendKeys(password);
    }
    
    @Step("PageElementBO Step: Enter password: {0} in password input field in method: {confirmNewPassword}...")
    public void confirmNewPassword(String password) {
        loginPagePo.getConfirmNewPasswordField().clear();
        loginPagePo.getConfirmNewPasswordField().sendKeys(password);
    }
    
    @Step("PageElementBO Step: Next in login page in method: {clickNext}...")
    public void clickNext() {
        loginPagePo.getNextButton().click();
    } 
    
    @Step("PageElementBO Step: Click on JoinScratch in login page in method: {clickJoinScratch}...")
    public void selectAndClickBirthMonth(Integer i) {        
        Select birthMonths = new Select(loginPagePo.getBirthMonths());		
        birthMonths.selectByIndex(i);
    }
    
    @Step("PageElementBO Step: Click on JoinScratch in login page in method: {clickJoinScratch}...")
    public void selectAndClickBirthYear(Integer i) {        
        Select birthYears = new Select(loginPagePo.getBirthYears());		
        birthYears.selectByIndex(i);
    }
    
    @Step("PageElementBO Step: RadioButtonMale page in method: {clickRadioButtonGenderMale}...")
    public void clickRadioButtonGenderMale() {
        loginPagePo.getMaleRadioButton().click();
    }
    
    @Step("PageElementBO Step: Click on JoinScratch in login page in method: {clickJoinScratch}...")
    public void selectAndClickCountry(Integer i) {        
        Select countries = new Select(loginPagePo.getCountry());		
        countries.selectByIndex(i);
    }
    
    @Step("PageElementBO Step: Enter login: {0} in login input field in method: {enterNewLogin}...")
    public void inputEmail(String email) {
        loginPagePo.getEmailField().clear();
        loginPagePo.getEmailField().sendKeys(email);
    }
    
    @Step("PageElementBO Step: Enter login: {0} in login input field in method: {enterNewLogin}...")
    public void inputEmailConfirm(String email) {
        loginPagePo.getEmailConfirmField().clear();
        loginPagePo.getEmailConfirmField().sendKeys(email);
    }
    
    @Step("PageElementBO Step: Next in login page in method: {clickNext}...")
    public void okLetsGoButton() {
        loginPagePo.getOKLetsGoButton().waitUntilVisible().click();
    } 
}
