package appium_class;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumIntro {

    @Test
    public void test1() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //information that server will use to identify and connect to mobile device
        desiredCapabilities.setCapability("deviceName", "MyPixel2");
        desiredCapabilities.setCapability("platformName", "android");

        //host where client code (Java code) is sent
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(serverURL,desiredCapabilities);


    }
}
