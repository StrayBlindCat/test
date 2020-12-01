package com.beyondsoft.cmbu.bean.pageObject.taobao.Login;

import com.beyondsoft.cmbu.bean.BasePage;
import com.beyondsoft.cmbu.common.PropertiesFileRead;
import com.beyondsoft.cmbu.common.YamlFileRead;
import org.openqa.selenium.WebDriver;

/**
 * @ClassName LoginPage
 * @Description TODO
 * @Author Stray blind cat
 * @Date 2020/11/28 23:46
 */
public class LoginPage extends BasePage {
    PropertiesFileRead propertiesFileRead = new PropertiesFileRead("src/test/resources/testData/BaseData.properties");
    YamlFileRead yamlFileRead = new YamlFileRead("src/test/resources/testPositioning/TaoBaoPositioning.yaml");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputUserName(){
        inputElement(yamlFileRead.getTargeting("usernameInput"),yamlFileRead.getPositioningStatement("usernameInput"),propertiesFileRead.getProperties("username"));
    }
    public void inputPassword(){
        inputElement(yamlFileRead.getTargeting("passwordInput"),yamlFileRead.getPositioningStatement("passwordInput"),propertiesFileRead.getProperties("password"));
    }
    public void clickSubmit(){
        clickElement(yamlFileRead.getTargeting("submitButton"),yamlFileRead.getPositioningStatement("submitButton"));
    }
}
