package com.epam.ex2.setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import com.epam.ex2.PageObjects.PageObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.epam.ex2.util.PropertyVariables.*;
import static java.lang.String.format;

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

    @Parameters({"platformName", "appType", "deviceName", "udid", "browserName", "app", "appPackage", "appActivity", "bundleId"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName, String appType, @Optional("") String deviceName, @Optional("") String udid,
                      @Optional("") String browserName, @Optional("") String app, @Optional("") String appPackage,
                      @Optional("") String appActivity, @Optional("") String bundleId) throws Exception {
        System.out.println("Before: app type - " + appType);
        setAppiumDriver(platformName, deviceName, udid, browserName, app, appPackage, appActivity, bundleId);
        setPageObject(appType, appiumDriver);
        if(platformName.equals("iOS")) appiumDriver.activateApp(bundleId);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("After");
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String platformName, String deviceName, String udid, String browserName, String app,
                                 String appPackage, String appActivity, String bundleId) {
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
            appiumDriver = new AppiumDriver(new URL(format("https://%s:%s@%s", PROJECT_NAME, TOKEN, APPIUM_HUB)), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Capabilities for test of Android native app on EPAM Mobile Cloud
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);

        // Capabilities for test of iOS native app on EPAM Mobile Cloud
        capabilities.setCapability("bundleId", bundleId);
        if(platformName.equals("iOS")) capabilities.setCapability("automationName","XCUITest");

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        pageObject = new PageObject(appType, appiumDriver);
    }

    public static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(appiumDriver, 10L);
    }
}
