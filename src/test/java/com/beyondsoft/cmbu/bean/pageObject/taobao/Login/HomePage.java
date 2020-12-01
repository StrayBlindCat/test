package com.beyondsoft.cmbu.bean.pageObject.taobao.Login;

import com.beyondsoft.cmbu.bean.BasePage;
import com.beyondsoft.cmbu.common.YamlFileRead;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @ClassName HomePage
 * @Description TODO
 * @Author Stray blind cat
 * @Date 2020/11/29 11:01
 */
public class HomePage extends BasePage {
    YamlFileRead yamlFileRead = new YamlFileRead("src/test/resources/testPositioning/TaoBaoPositioning.yaml");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickShoppingCatLabel(){
        clickElement(yamlFileRead.getTargeting("ShoppingCartLabel"),yamlFileRead.getPositioningStatement("ShoppingCartLabel"));
    }
}
