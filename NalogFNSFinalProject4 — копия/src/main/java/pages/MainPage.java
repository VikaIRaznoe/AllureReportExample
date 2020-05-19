package pages;

import general.GeneralMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.IOException;

import static general.GeneralMethods.waitForElementPresentRefact;

public class MainPage {

    //Меню (слева,вверху)
    //Раздел "Оплата налогов"
    By elementMenu = By.xpath("//android.widget.Button[@content-desc=\"menu dark \"]");

    //Поиск задолженостей
    By elementSearchingZadoljenostey = By.xpath("//android.widget.Button[@content-desc=\"search Поиск задолженностей \"]");

    //Оплата по УИН или QR-коду
    By elementPaynigByUINOrQR = By.xpath("//android.widget.Button[@content-desc=\"uin qr Оплата по УИН или QR-коду \"]");

    //ИНН (главная страница)
    By elementINN = By.xpath("//*[contains(@text,'000000000000')]");

    //кнопка "Найти" (главная страница)
    By elementFindButton = By.xpath("//android.widget.Button[@content-desc=\"НАЙТИ \"]");
//    By elementFindButton = By.xpath("//android.widget.Button[@content-desc=\"ИСКАТЬ \"]");

    //кнопка "Оплатить по УИН"
    By elementPayByUINButton = By.xpath("//*[contains(@content-desc ,\"ОПЛАТИТЬ ПО\")]");

    //История операций
    By elementHistoryOfOperations = By.xpath("//android.widget.Button[@content-desc=\"history История операций \"]");

    //Профиль (ИНН)
    By elementProfileINN = By.xpath("//android.widget.Button[@content-desc=\"person Профиль (ИНН) \"]");

    //Банковская карта
    By elementBankCard = By.xpath("//android.widget.Button[@content-desc=\"card Банковская карта \"]");

    //Помощь
    By elementHelp = By.xpath("//android.widget.Button[@content-desc=\"support Помощь \"]");

    //Оценить приложение
    By elementRateApp = By.xpath("//android.widget.Button[@content-desc=\"star outline Оценить приложение \"]");

    //Поделиться
    By elementShare = By.xpath("//android.widget.Button[@content-desc=\"share Поделиться \"]");

    //Другие приложения
    By elementAnotherApp = By.xpath("//android.widget.Button[@content-desc=\"apps Другие приложения \"]");

    //Узнать ИНН по паспорту
//    By elementKnowINNByPasport = By.xpath("//android.widget.Button[@content-desc=\"УЗНАТЬ ИНН ПО ПАСПОРТУ \"]");
    By elementKnowINNByPasport = By.xpath("//*[contains(@content-desc ,\"УЗНАТЬ ИНН\")]");


    public void openMenu(){
        waitForElementPresentRefact(elementMenu,50).click();
    }

    public void clickSearchingZadoljenostey() {
        waitForElementPresentRefact(elementSearchingZadoljenostey,50).click();
    }

    public void clickPaynigByUINOrQR(){
        waitForElementPresentRefact(elementPaynigByUINOrQR,50).click();
    }

    public void inputINN(String innText) throws IOException, InterruptedException {
        waitForElementPresentRefact(elementINN,50).sendKeys(innText);
    }

    public void clickFindButton() throws InterruptedException, IOException {
        Thread.sleep(3000);
        waitForElementPresentRefact(elementFindButton,50).click();
        Thread.sleep(3000);
    }

    public void clickPayByUIN(){
        waitForElementPresentRefact(elementPayByUINButton,50).click();
    }

    public void clickHistoryOfOperations() throws InterruptedException {
        waitForElementPresentRefact(elementHistoryOfOperations,50).click();
        Thread.sleep(3000);
    }

    public void clickProfileINN() throws InterruptedException {
        waitForElementPresentRefact(elementProfileINN,50).click();
        Thread.sleep(3000);
    }

    public void clickBankCard() throws InterruptedException {
        waitForElementPresentRefact(elementBankCard,50).click();
        Thread.sleep(3000);
    }

    public void clickHelp() throws AWTException, InterruptedException {
        waitForElementPresentRefact(elementHelp,50).click();
        Thread.sleep(3000);
    }

    public void clickRateApp(){
        waitForElementPresentRefact(elementRateApp,50).click();
    }

    public void clickShareApp() throws InterruptedException {
        waitForElementPresentRefact(elementShare,50).click();
        Thread.sleep(3000);
    }

    public void clickAnotherApp() throws InterruptedException {
        waitForElementPresentRefact(elementAnotherApp,50).click();
        Thread.sleep(3000);
    }

    public void clickKnowINNByPasport() throws InterruptedException {
        waitForElementPresentRefact(elementKnowINNByPasport,50).click();
        Thread.sleep(3000);
    }
}
