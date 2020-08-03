package YaTranslate.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends PageObject{

    By translateTextArea = By.id("textarea");
    By translationArea = By.id("translation");
    By clearButton = By.id("clearButton");
    By originalLanguage = By.id("srcLangButton");
    By translateLanguage = By.id("dstLangButton");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Ввод текста
     * @param some_text Текст для перевода
    */
    public void inputText(String some_text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(translateTextArea));
        driver.findElement(translateTextArea).sendKeys(some_text);
    }

    /**
     * Пролучение текста перевода
     * @return  Текст перевода
     */
    public String checkTranslate() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(translationArea));
        return driver.findElement(translationArea).getText();
    }

    /**
     * Нажать кнопку очистики поля
     */
    public void clickClearButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(clearButton));
        driver.findElement(clearButton).click();
    }

    /**
     * Получаем язык переводимого слова
     */
    public String srcLanguage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(originalLanguage));
        return driver.findElement(originalLanguage).getText();
    }

    /**
     * Получаем языка перевода
     */
    public String dstLanguage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(translateLanguage));
        return driver.findElement(translateLanguage).getText();
    }

}
