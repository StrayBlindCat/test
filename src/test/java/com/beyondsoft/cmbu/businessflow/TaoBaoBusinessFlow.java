package com.beyondsoft.cmbu.businessflow;

import com.beyondsoft.cmbu.bean.pageObject.HomePage;
import com.beyondsoft.cmbu.bean.pageObject.LoginPage;
import com.beyondsoft.cmbu.common.PropertiesFileRead;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName BiliBiliBusinessFlow
 * @Description TODO
 * @Author Stray blind cat
 * @Date 2020/11/25 23:38
 */
public class TaoBaoBusinessFlow {
    public WebDriver driver;
    PropertiesFileRead propertiesFileRead = new PropertiesFileRead("src/test/resources/testData/BaseData.properties");
    static final Logger LOGGER = LoggerFactory.getLogger(TaoBaoBusinessFlow.class.getName());
    String url = propertiesFileRead.getProperties("url");

    public TaoBaoBusinessFlow(WebDriver webDriver){
        driver=webDriver;
    }
    public void taoBaoLogin(){
        LoginPage loginPage =new LoginPage(driver);
        loginPage.accessUrl(url);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginPage.inputUserName();
        loginPage.inputPassword();
        loginPage.clickSubmit();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void checkTheShoppingCart(){
        HomePage homePage=new HomePage(driver);
        homePage.clickShoppingCatLabel();
    }

}
