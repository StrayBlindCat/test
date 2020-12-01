package com.beyondsoft.cmbu.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
/**
 * @ClassName PropertiesFileRead
 * @Description TODO
 * @Author Stray blind cat
 * @Date 2020/11/15 14:06
 */
public class PropertiesFileRead {
    Properties properties = new Properties();
    public PropertiesFileRead(String path){

        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            properties.load(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperties(String keyWord) {
        return properties.getProperty(keyWord);
    }

}
