package general;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;


public class GeneralMethods extends general.DriverManager {


    private String screenshotPathExpected = "src/test/resources/App_Screenshots/expected/";
    private String screenshotPathActual = "src/test/resources/App_Screenshots/actual/";

    //Метод ожидания появления элемента
    public static WebElement waitForElementPresentRefact(By by, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(general.DriverManager.getDriver(),  timeoutInSeconds);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by) //ожидает элемент
        );
    }

    //Получаем скриншот страницы, обрезая строку состояния Android (время)
    //В качестве первого аргумента принимает имя,которое дадим файлу(скрину) который получится
    //В качестве второго аргумента: принимает имя локатора; сам локатор в файле locator.txt
    //По nameLocator получаем сам локатор элемента
    public File getScreenshot(String fileName) throws IOException, InterruptedException {
        Thread.sleep(5000);
        WebElement element = general.DriverManager.getDriver().findElementByXPath(ReadFileLineByLine.getLocatorRefact(fileName));
        //Получить весь скриншот страницы
        File screenshot = ((TakesScreenshot) general.DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);
        //Получить расположение элемента на странице
        Point point = element.getLocation();
        //Получить ширину и высоту элемента
        int eleWidth = element.getSize().getWidth();
        int eleHeight = element.getSize().getHeight();
        //Обрезать весь скриншот страницы, чтобы получить только скриншот элемента
        BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
                eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);
        File screenshotLocation = new File(screenshotPathActual+fileName+".png");
        FileUtils.copyFile(screenshot, screenshotLocation);
        return screenshot;
    }

    //Получаем скриншот страницы, обрезая строку состояния Android (время)
    //В качестве первого аргумента принимает имя,которое дадим файлу(скрину) который получится
    //В качестве второго аргумента: принимает имя локатора; сам локатор в файле locator.txt
    //По nameLocator получаем сам локатор элемента
    public String getScreenshotRefact(String fileName) throws IOException {
        WebElement element = general.DriverManager.getDriver().findElementByXPath(ReadFileLineByLine.getLocatorRefact(fileName));
        //Получить весь скриншот страницы
        File screenshot = ((TakesScreenshot) general.DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);
        //Получить расположение элемента на странице
        Point point = element.getLocation();
        //Получить ширину и высоту элемента
        int eleWidth = element.getSize().getWidth();
        int eleHeight = element.getSize().getHeight();
        //Обрезать весь скриншот страницы, чтобы получить только скриншот элемента
        BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
                eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);
        File screenshotLocation = new File(screenshotPathActual+fileName+".png");
        FileUtils.copyFile(screenshot, screenshotLocation);
        return fileName+".png";
    }

    //Сравниваем два файла,в данном случае два скриншота
    //сравниваю два файла
    public  boolean compareScreenshot(String filePNGNameActual, String filePNGNameExpected) throws Exception {
        File a = new File(screenshotPathActual+filePNGNameActual+".png");
        File b = new File(screenshotPathExpected+filePNGNameExpected+".png");
        // разумно сразу сравнить размеры файлов
        // если они не равны, содержимое тоже не совпадет
        if (a.length() != b.length()) {
            return false;
        }

        FileReader readerA = new FileReader(a);
        FileReader readerB = new FileReader(b);
        int byteA;
        int byteB;
        while ((byteA = readerA.read()) > 0) {
            byteB = readerB.read();
            if (byteA != byteB) {
                return false;
            }
        }

        return true;
    }

    public void resultCompare(boolean result){
        if (result == true){
            System.out.println("Скриншоты не различаются");
        } else System.out.println("Скриншоты различаются");
    }

    //SCROLL по всему экрану вниз
    protected void scrollDown(int swipeTime){
        //TouchAction - позволяет описать действие
        TouchAction action = new TouchAction(general.DriverManager.getDriver());
        //Получаем размер всего экрана
        Dimension size = general.DriverManager.getDriver().manage().window().getSize();
        //Определяем размер области,в котрой будет производиться scroll
        int x = size.width/2;
        //Задаем начальную и конечную точку по "x"
        int start_y = (int)(size.height*0.9);
        int finish_y = (int)(size.height*0.2);
        action
                //Имитируем нажатие
                .press(PointOption.point(x,finish_y))
                //Ждем какое-то время
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(swipeTime)))
                //определяем конечную точку движения
                .moveTo(PointOption.point(x,start_y))
                //отправляем все это драйверу
                .release()
                //исполняем
                .perform();
    }


    public String getFileOld(String fileName){
        File file = new File("./test-recordings/" + fileName +".avi");
//        System.out.println ("Имя файла: " + file .getName());
        String fileNameWithOutExt = FilenameUtils.removeExtension(file.getName());
        System.out.println(fileNameWithOutExt);
        return file.getName();
    }

    //Старт записи видео
    public void startRecordVideo() {
        general.DriverManager.getDriver().startRecordingScreen();
    }

    public byte[] stopRecordVideoRefact() throws IOException, InterruptedException {
        String base64String = DriverManager.getDriver().stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);
        System.out.println(base64String);
        String destinationPath="target/filename.mp4";
        Path path = Paths.get(destinationPath);
        Files.write(path, data);
        return data;
    }

    @Attachment(value = "FAILED STEP", type = "video/mp4")
    public byte[] makeVideo() throws IOException, InterruptedException {
        return stopRecordVideoRefact();
    }

    public Path stopRecordVideoRefact2() throws IOException, InterruptedException {
        String base64String = DriverManager.getDriver().stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);
        System.out.println(base64String);
        String destinationPath="target/filename.mp4";
        Path path = Paths.get(destinationPath);
        Files.write(path, data);
        return path;
    }
}