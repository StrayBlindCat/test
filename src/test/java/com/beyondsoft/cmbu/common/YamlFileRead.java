package com.beyondsoft.cmbu.common;

import com.beyondsoft.cmbu.bean.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * @ClassName YamlFileRead
 * @Description TODO
 * @Author Stray blind cat
 * @Date 2020/11/29 16:06
 */
public class YamlFileRead {
    final Logger LOGGER = LogManager.getLogger(YamlFileRead.class.getName());
    FileInputStream fileInputStream = null;
    Yaml yaml = new Yaml();
    Map map;
    public YamlFileRead(String filePath) {

        try {
            File file = new File(filePath);
            fileInputStream = new FileInputStream(file);
            map = yaml.loadAs(fileInputStream, Map.class);
            System.out.println(map.get("usernameInput"));
        } catch (FileNotFoundException e) {
            LOGGER.error("文件地址错误");
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public String[] getSplitString(String key){
        String string= (String) map.get(key);
        return string.split("==");
    }
    public String getTargeting(String key){
        return getSplitString(key)[0];
    }
    public String getPositioningStatement(String key){
        return getSplitString(key)[1];
    }
}
