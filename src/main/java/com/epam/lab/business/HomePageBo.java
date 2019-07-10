package com.epam.lab.business;

//import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.MyLogger;
import com.epam.lab.page.HomePagePo;
import io.qameta.allure.Step;
import org.apache.log4j.Level;
//import org.openqa.selenium.interactions.Actions;

public class HomePageBo {

    private HomePagePo homePagePo;

    public HomePageBo() {
        homePagePo = new HomePagePo();
        MyLogger myLogger = new MyLogger();
        myLogger.setLevel(Level.INFO);
    }

    @Step("PageElementBO Step: logout...")
    public void logout() {    	
    	homePagePo.getDropDownMenu().click();
        homePagePo.getLogout().click();
    }
    
    @Step("PageElementBO Step: myStuff...")
    public void myStuff() {    	
    	homePagePo.getDropDownMenu().click();
        homePagePo.getMyStuff().click();
    }
    
    @Step("PageElementBO Step: Get UserName From profile button...")
    public String getNameFromProfileButton() {
        return homePagePo.getProfileButton().getText();
    }
    
    @Step("PageElementBO Step: Get Create button...")
    public void createButton(){
    	homePagePo.getCreateButton().click();    	
    }
}
