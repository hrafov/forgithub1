package com.epam.lab.core.util;

import com.epam.lab.core.driver.DriverManager;

import java.util.ArrayList;

public class BrowserUtils {

    public static void switchToFrame(int frameNumber) {
        DriverManager.getDriver().switchTo().frame(frameNumber);
    }

    public static void switchToWindow(int windowNumber) {
//here i added <Object> to ArrayList    	
        ArrayList<Object> tabs = new ArrayList<Object>(DriverManager.getDriver().getWindowHandles());
        DriverManager.getDriver().switchTo().window(tabs.get(windowNumber).toString());
    }
}
