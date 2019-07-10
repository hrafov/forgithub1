package com.epam.lab.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.lab.core.util.Constants.*;

public class DriverManager {
	
    /**
     * Initialize driver
     */
    private static ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        System.setProperty(DRIVER, DRIVER_PATH);
        return new ChromeDriver();
    });

    private DriverManager() {
    }

    /**
     * This method gets driver
     *
     * @return driver
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * This method close driver and quit
     */
    public static void removeDriver() {
        driver.get().quit();
        driver.remove();
    }

    public static WebDriverWait newWait() {
        return new WebDriverWait(getDriver(), WAITING_TIME);
    }
}
