package com.epam.ex2.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ResourceBundle;

public class PropertyVariables {
    static ResourceBundle resourceBundle = ResourceBundle.getBundle("ex2/test");
    public static String TOKEN;
    public static final String APPIUM_HUB = resourceBundle.getString("appiumHub");
    public static final String PROJECT_NAME = resourceBundle.getString("projectName");

    static {
        try {
            TOKEN = URLEncoder.encode(resourceBundle.getString("token"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
