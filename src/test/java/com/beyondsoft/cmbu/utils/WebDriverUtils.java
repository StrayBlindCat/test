package com.beyondsoft.cmbu.utils;

import com.beyondsoft.cmbu.bean.myenum.BrowerName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @ClassName WebDriverUtils
 * @Description TODO
 * @Author Stray blind cat
 * @Date 2020/11/14 22:24
 */
public class WebDriverUtils {
    private static WebDriver driver;
    static final Logger LOGGER = LogManager.getLogger(WebDriverUtils.class.getName());
    public static WebDriver getDriver() {
        return driver;
    }
    /**
     * @Author Stray blind cat
     * @Description TODO 
     * @Date 2020/11/14 22:42
     * @Param [BrowerName]
     * @return void
     */
    public static void openBrowser(String browserName) {
        if (BrowerName.CHROME.toString().equals(browserName)) {
            if(null==driver) {
                //让代码知道chromeDriver驱动是保存在哪里
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-gpu");
//                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments(" --ignore-certificate-errors");
                chromeOptions.addArguments("–no-sandbox");
                chromeOptions.addArguments("–lang=zh-CN");
                LOGGER.info("CHROME Browser set up");
                driver = new ChromeDriver(chromeOptions);
                LOGGER.info("CHROME Open  Browser");
            }
        } else if (BrowerName.EDGE.toString().equals(browserName)) {
            System.out.println("Please wait");
        } else if (BrowerName.FIREFOX.toString().equals(browserName)) {
            System.out.println("Please wait");
        }
    }
}
