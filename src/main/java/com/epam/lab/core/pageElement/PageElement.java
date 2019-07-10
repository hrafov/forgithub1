package com.epam.lab.core.pageElement;

import com.epam.lab.core.util.MyLogger;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

import static com.epam.lab.core.driver.DriverManager.newWait;

public class PageElement implements WebElement {

    private final static Logger LOG = MyLogger.getLogger();

    private WebElement webElement;
    private String name;

    public PageElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Step("PageElement Step: Click on page element...")
    public void click() {
        webElement.click();
        LOG.info("Click on [" + name + "]");
    }

    @Step("PageElement Step: Submit form...")
    public void submit() {
        webElement.submit();
        LOG.info("Click on [" + name + "]");
    }

    @Step("PageElement Step: Send keys: {0}...")
    public void sendKeys(CharSequence... keysToSend) {
        LOG.info("Sending keys to [" + name + "] value [" + Arrays.toString(keysToSend) + "]");
        webElement.sendKeys(keysToSend);
    }

    @Step("PageElement Step: Clear input field...")
    public void clear() {
        LOG.info("Clear [" + name + "]");
        webElement.clear();
    }

    @Step("PageElement Step: Get tag name...")
    public String getTagName() {
        LOG.info("Getting name of tag [" + name + "]");
        return webElement.getTagName();
    }

    @Step("PageElement Step: Get attribute by name: {0}...")
    public String getAttribute(String name) {
        LOG.info("Getting attribute [" + name + "]");
        return webElement.getAttribute(name);
    }

    @Step("PageElement Step: Verifying selecting of element...")
    public boolean isSelected() {
        LOG.info("Checking if element is selected [" + name + "]");
        return webElement.isSelected();
    }

    @Step("PageElement Step: Verifying enabling of element...")
    public boolean isEnabled() {
        LOG.info("Checking if element is enabled [" + name + "]");
        return webElement.isEnabled();
    }

    @Step("PageElement Step: Get text from element...")
    public String getText() {
        return webElement.getText();
    }

    @Step("PageElement Step: Find elements by: {0}...")
    public List<WebElement> findElements(By by) {
        LOG.info("Finding elements [" + name + "]");
        return webElement.findElements(by);
    }

    @Step("PageElement Step: Find element by: {0}...")
    public WebElement findElement(By by) {
        LOG.info("Finding element [" + name + "]");
        return webElement.findElement(by);
    }

    @Step("PageElement Step: Verifying displaying of element...")
    public boolean isDisplayed() {
        LOG.info("Checking if element is displayed [" + name + "]");
        return webElement.isDisplayed();
    }

    @Step("PageElement Step: Get location of element...")
    public Point getLocation() {
        LOG.info("Getting element location [" + name + "]");
        return webElement.getLocation();
    }

    public Dimension getSize() {
        LOG.info("Getting size of element [" + name + "]");
        return webElement.getSize();
    }

    public Rectangle getRect() {
        LOG.info("Getting rect of element [" + name + "]");
        return webElement.getRect();
    }

    @Step("PageElement Step: Get css value of element: {0}...")
    public String getCssValue(String propertyName) {
        LOG.info("Getting css value [" + name + "]");
        return webElement.getCssValue(propertyName);
    }

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return webElement.getScreenshotAs(target);
    }

    public void tagShouldBeEqualTo(String tag) {
        if (!getText().contains(tag)) {
        }
    }

    @Step("PageElement Step: Wait until visible element ...")
    public PageElement waitUntilVisible() {
        LOG.info("Wait until visible element [" + this.name + "]");
        newWait().until(ExpectedConditions.visibilityOf(this));
        return this;
    }
}

