package tests;

import general.DriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;



public class BaseTest {
    //"/Users/viktoria/IdeaProjects/Java/Allure-Temp/NalogFNSFinalProject2/src/test/resources/App/app-debug.apk"
    private File app = new File("src/test/resources/App/app-debug.apk");

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","8.1");
        caps.setCapability("deviceName","emulator-5554");
        caps.setCapability("appPackage","rs.oplatagosuslug.nalogi");
        caps.setCapability("appActivity","rs.oplatagosuslug.nalogi.MainActivity");
        caps.setCapability("app",app.getAbsolutePath());
        URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub");
        DriverManager.initializeDriver(appiumURL, caps);
    }

    @AfterClass
    public void  tearDown() {
        DriverManager.getDriver().quit();
    }

}