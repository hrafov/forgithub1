package com.epam.lab.core.util;

public class Constants {
    public static final String DRIVER = "webdriver.chrome.driver";
    public static final String DRIVER_PATH = "src/main/resources/chromedriver.exe";
    public static final String LOGIN_PAGE_URL = "https://scratch.mit.edu";
    public static final String HOME_PAGE_URL =  "https://scratch.mit.edu/";
    public static final String CREDENTIALS_CSV_PATH = "src/main/resources/user.csv";
    public static final String PROPERTIES_PATH = "src/test/java/com/epam/lab/config.properties";
    public static final String INVALID_LOGIN = "SteaveJobbs";
    public static final String INVALID_PASSWORD = "IamSteave666";    
    public static final int WAITING_TIME = 10;
//  public static final int NEXT_WINDOW_NUMBER = 1;
//  public static final int PREVIOUS_WINDOW_NUMBER = 0;    
    
    private Constants() {
    }
}