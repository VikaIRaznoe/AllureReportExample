package tests;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;

import general.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;

//@Listeners({ListenerTestClass.class})
@Listeners({ListenerTestClass.class})
//@Listeners(UniversalVideoListener.class)
public class FirstTest extends BaseTest {
    GeneralMethods generalMethods = new GeneralMethods();
    MainPage mainPage = new MainPage();
    AllureUtils allureUtils = new AllureUtils();

    @Test(enabled = true)
    @Description(value = "Итоговая работа")
    @Epic("Налоги ФНС")
    @Story("Проверка кнопки Найти в главном окне приложения")
    public void findDolgINNTest() throws Exception {
        generalMethods.startRecordVideo();
        mainPage.inputINN("733989664703");
        mainPage.clickFindButton();
//        generalMethods.stopRecordVideoRefact();
//        allureUtils.saveScreenshot(generalMethods.stopRecordVideoRefact());
//        allureUtils.makeVideo();
        generalMethods.makeVideo();
    }

}
