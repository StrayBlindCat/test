package com.beyondsoft.cmbu.bean;

import com.beyondsoft.cmbu.utils.WebDriverUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * @ClassName BasePage
 * @Description TODO
 * @Author Stray blind cat
 * @Date 2020/11/14 22:34
 */
public class BasePage {
    public WebDriver driver;
    public BasePage(WebDriver webDriver){
        driver =webDriver;
    }

    final Logger LOGGER = LogManager.getLogger(BasePage.class.getName());

    /**
     * @return org.openqa.selenium.WebElement
     * @Author Stray blind cat
     * @Description TODO
     * @Date 2020/11/26 21:07
     * @Param [targeting, positioningStatement]
     */

    public WebElement waitElementVisible(String targeting, String positioningStatement) {
        switch (targeting.toUpperCase()) {
            case "XPATH":
                return new WebDriverWait(driver, 5).until(driver -> driver.findElement(By.xpath(positioningStatement)));
            case "CSS":
                return new WebDriverWait(driver, 5).until(driver -> driver.findElement(By.cssSelector(positioningStatement)));
            case "ID":
                return new WebDriverWait(driver, 5).until(driver -> driver.findElement(By.id(positioningStatement)));
            case "linkText":
                return new WebDriverWait(driver, 5).until(driver -> driver.findElement(By.linkText(positioningStatement)));
            default:
                LOGGER.error("The input positioning method is wrong, please check");
                return null;
        }
    }
    public List<WebElement> waitElementsVisible(String targeting, String positioningStatement) {
        switch (targeting.toUpperCase()) {
            case "XPATH":
                return new WebDriverWait(driver, 5).until(driver -> driver.findElements(By.xpath(positioningStatement)));
            case "CSS":
                return new WebDriverWait(driver, 5).until(driver -> driver.findElements(By.cssSelector(positioningStatement)));
            case "ID":
                return new WebDriverWait(driver, 5).until(driver -> driver.findElements(By.id(positioningStatement)));
            case "linkText":
                return new WebDriverWait(driver, 5).until(driver -> driver.findElements(By.linkText(positioningStatement)));
            default:
                LOGGER.error("The input positioning method is wrong, please check");
                return null;
        }
    }

    /**
     * @return org.openqa.selenium.WebElement
     * @Author Stray blind cat
     * @Description TODO
     * @Date 2020/11/26 21:07
     * @Param [targeting, positioningStatement]
     */
    public WebElement waitElementClickable(String targeting, String positioningStatement) {
        switch (targeting.toUpperCase()) {
            case "XPATH":
                return new WebDriverWait(driver, 5).until(driver -> driver.findElement(By.xpath(positioningStatement)));
            case "CSS":
                return new WebDriverWait(driver, 5).until(driver -> driver.findElement(By.cssSelector(positioningStatement)));
            case "ID":
                return new WebDriverWait(driver, 5).until(driver -> driver.findElement(By.id(positioningStatement)));
            case "linkText":
                return new WebDriverWait(driver, 5).until(driver -> driver.findElement(By.linkText(positioningStatement)));
            default:
                LOGGER.error("The input positioning method is wrong, please check");
                return null;
        }
    }
    /**
     * @Author Stray blind cat
     * @Description TODO
     * @Date 2020/11/28 23:32
     * @Param [targeting, positioningStatement]
     * @return void
     */
    public void clickElement(String targeting, String positioningStatement) {
        LOGGER.info("click {} element", positioningStatement);
        waitElementClickable(targeting, positioningStatement).click();
    }

    public void inputElement(String targeting, String positioningStatement, String inputString) {
        LOGGER.info("input {}", inputString);
        waitElementVisible(targeting, positioningStatement).click();
        waitElementVisible(targeting, positioningStatement).sendKeys(inputString);
    }

    public void refreshBrowser() {
        LOGGER.info("refresh Browser ");
        driver.navigate().refresh();
    }

    public String getUrl() {
        LOGGER.info("Get the current page url");
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        LOGGER.info("Get the current page getTitle");
        return driver.getTitle();
    }

    public void quitBrowser() {
        LOGGER.info("Close the browser");
        driver.quit();
    }

    public void switchToFrame(String name) {
        LOGGER.info("select {} frame", name);
        driver.switchTo().frame(name);
    }

    public void switchToDefaultContent() {
        LOGGER.info("Return to the outermost frame");
        driver.switchTo().defaultContent();
    }
    public void accessUrl(String url){
        LOGGER.info(" access {}",url);
        driver.get(url);
    }
}
