package general;

import com.google.common.io.Files;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.events.TestCaseEvent;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


import static com.sun.xml.internal.messaging.saaj.packaging.mime.util.ASCIIUtility.getBytes;
import static ru.yandex.qatools.allure.model.DescriptionType.MARKDOWN;

public class ListenerTestClass  implements ITestListener {

    GeneralMethods generalMethods = new GeneralMethods();
    AllureUtils allureUtils = new AllureUtils();

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test class started:  " + result.getName() + " " + "Thread Current ID : " + Thread.currentThread().getId());
//        AllureUtils.attachVideo();
//        generalMethods.startRecordVideo();
    }

    protected final String PATH = "./target/screenshots/";

    @Override
    public void onTestSuccess(ITestResult result) {
         System.out.println("Test SUCCESS: " + result.getName() + " " + "Thread Current ID : " + Thread.currentThread().getId());
    }

    @Override
    public void onTestFailure(ITestResult result) {
       //Вроде работает
        Allure.addAttachment("TESTSCR", new ByteArrayInputStream(((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES)));
        System.out.println(result.getTestClass() + " " + result.getMethod() + " " + result.getName());
    }

    //не проверяла работу
    @Attachment(value = "{0}", type = "text/plain")
    public String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
//        try {
//            AllureUtils.getBytes(generalMethods.stopRecordVideo());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}
