package com.beyondsoft.cmbu.testCase;

import com.beyondsoft.cmbu.bean.myenum.BrowerName;
import com.beyondsoft.cmbu.businessflow.TaoBaoBusinessFlow;
import com.beyondsoft.cmbu.utils.WebDriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @ClassName BiliBili
 * @Description TODO
 * @Author Stray blind cat
 * @Date 2020/11/29 11:16
 */
public class TaoBaoTest {
    TaoBaoBusinessFlow taoBaoBusinessFlow;

    @BeforeMethod
    public void setupMethod() {
        WebDriverUtils.openBrowser(BrowerName.CHROME.toString());
        taoBaoBusinessFlow= new TaoBaoBusinessFlow(WebDriverUtils.getDriver());
        taoBaoBusinessFlow.taoBaoLogin();
    }

    @AfterMethod
    public void tearDownMethod() {
        WebDriverUtils.getDriver().quit();
    }

    @Test
    public void testCheckShoppingCart() {
        taoBaoBusinessFlow.checkTheShoppingCart();
    }
}
