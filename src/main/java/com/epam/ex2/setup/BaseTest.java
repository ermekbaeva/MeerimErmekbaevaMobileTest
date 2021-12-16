package com.epam.ex2.setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import com.epam.ex2.PageObjects.PageObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver; // singleton
    static IPageObject pageObject;

    @Override
    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    public static IPageObject getPageObject() {
        return pageObject;
    }

    @Parameters({"platformName", "appType", "deviceName", "udid", "browserName", "app"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName, String appType, String deviceName, @Optional("") String udid,
                      @Optional("") String browserName, @Optional("") String app) throws Exception {
        System.out.println("Before: app type - " + appType);
        String token = "3TPIDN0MCoyayKM14X1d110S90Ycfy8nMDOQYU+UYrFAKivjNIdbHwhQotqz6fFLHGxIDUCAGIH3weWcv02dDrJZ23ZItu+I0H7u5l/w2qTKVQ1TI2XVtlnEf9Y5PDncBrQ0bgq7QOYj7Ig+W3hw1u9ikEZ2VHtBM7uG10l1YE5tMe9xfrt+3IPVs79soL+9cxkJjZpVPGDUdB66nggHVVwyjD+6zTl8hb9pNNoyL5lOqDn0w2OLeJXoeCIo1RLgXzUc7BXfL2Azim05mA/L2jnPveSweA2ZWd/IdIE90cAWvUYiNQdg8/8ztF/twmlEEKOcOqegXNIt2WSMqduqh0VL6YUyO1GXT17O73TAXrMgT+G5mieNO7ZQ9xTezNzGG4a+CVZDtypJXntgRiQ3E7NP2eyXV7jL8Sq27JOw8kp/NcCJmaYuPJLcKJeaobLUmpc9TWOyFHaBLZ08bjeVDmn7/2etjCIh9Ubc/4ANhborbO4wa/BqFcKwsmLhjhiXBQqM8cC2wxZuiU7FI0ERQ9HxGcLztlfEf7X9geMRbaL9uMwixiUbv5xxnws0opcY3Jy+1kFQReo8mF8T5/akRBJCwwdgYOrc9BozStHH0Jg3R0kF3pX0oaEO4VrNnFdr8/stN0zg3Pk5cmPGHRro5KTAd3gc/oTtl3aJjPl7QkKyTYc1iwGGTv706deIkFT13hLZbGaiD6XDpnArgTkemq2/RDqeTxf9lFjatPLhZQrlPFtfgm0Rc0hwnI/pG90XKxeu2EeLv/8eYO2VXfgiiEfIlPJUW0aw1FIcwjRJR68mGmyybb3qtFmKqkFtx/vgP72tG4pzSDugWqa79SQIlDUnQdjt1ZBpTNLmSgMJToUEJXimpTBCcNkJI4dLejoYG0Q51+ahZgfJv02IBRN7KzQ";
        System.out.println(URLEncoder.encode(token, "UTF-8"));
        setAppiumDriver(platformName, deviceName,udid, browserName, app);
        setPageObject(appType, appiumDriver);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("After");
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String platformName, String deviceName, String udid, String browserName, String app) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udid);

        if (app.endsWith(".apk")) {
            capabilities.setCapability("app", (new File(app)).getAbsolutePath());
        }

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck", "true");

        try {
            appiumDriver = new AppiumDriver(new URL(System.getProperty("ts.appium")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        pageObject = new PageObject(appType, appiumDriver);
    }
}
