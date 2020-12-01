package com.beyondsoft.cmbu.common;

import com.beyondsoft.cmbu.bean.BasePage;
import com.beyondsoft.cmbu.utils.WebDriverUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName SeleniumTakeScreenshot
 * @Description TODO
 * @Author Stray blind cat
 * @Date 2020/11/28 0:34
 */
public class SeleniumTakeScreenshot {
    public void screenshotFullScreen(WebDriver driver) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
