package com.epam.lab.page;

import com.epam.lab.core.decorator.CustomFieldDecorator;
import com.epam.lab.core.driver.DriverManager;

import io.qameta.allure.Step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

public abstract class AbstractPage {
    private WebDriver driver;

    public AbstractPage() {
        driver = DriverManager.getDriver();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().window().maximize();
        PageFactory.initElements(new CustomFieldDecorator(new DefaultElementLocatorFactory(driver)), this);
    }

    @Step("AbstractPage Step: Wait for element: {0} (Fluent Wait)...")
    public void waitElement(WebElement webElement) {
        @SuppressWarnings({ "rawtypes", "unchecked" })
		Wait<WebDriver> wait = new FluentWait(driver).withTimeout(ofSeconds(20)).pollingEvery(ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }


}
