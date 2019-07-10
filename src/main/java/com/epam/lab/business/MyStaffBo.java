package com.epam.lab.business;

//import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.MyLogger;
//import com.epam.lab.page.HomePagePo;
import com.epam.lab.page.MyStaffPo;

import io.qameta.allure.Step;
import org.apache.log4j.Level;
//import org.openqa.selenium.interactions.Actions;

public class MyStaffBo {

  private MyStaffPo myStaffPo;

  public MyStaffBo() {
      myStaffPo = new MyStaffPo();
      MyLogger myLogger = new MyLogger();
      myLogger.setLevel(Level.INFO);
  }

  @Step("PageElementBO Step: project drums2...")
  public void drums2() {  	
      myStaffPo.getDrums2().click();
  }

//  @Step("PageElementBO Step: Get UserName From profile button...")
//  public String getNameFromProfileButton() {
//      return homePagePo.getProfileButton().getText();
//  }  
}