package company.name.page;

import company.name.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends AbstractPage{

    @FindBy(css = ".heading")                       // Проверка открытия сайта
    private WebElement checkOpen;

    @FindBy(css = "[href=\"/frames\"]")             // Кнопка открытия вкладки "Frames"
    private WebElement framesButton;

    @FindBy(css = "h3")                             // Проверка открытия вкладки "Frames"
    private WebElement checkFrames;

    @FindBy(css = "li:First-child a")               // Кнопка открытия кладки "Nested Frames"
    private WebElement nestedFramesButton;

    @FindBy(css = "[name=frame-bottom]")            // Нижний фрейм
    private WebElement bottomFrame;

    @FindBy(css = "[name=frame-top]")               // Верхний фрейм
    private WebElement topFrame;

    @FindBy(css = "[name=frame-left")               // Левый фрейм
    private WebElement leftFrame;

    @FindBy(css = "[name=frame-middle]")            // Центральный фрейм
    private WebElement middleFrame;

    @FindBy(css = "[name=frame-right]")             // Правый фрейм
    private WebElement rightFrame;

    @FindBy(css = "body")                           // Тело внутри фрейма
    private WebElement bodyInFrame;


    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     */
    public StartPage() {
        super(DriverManager.getDriver());
    }


    @Step("Открыть тестовый стенд")
    public void openTestStand(){
        DriverManager.getDriver().get(getStand());
        checkAndScreenShotStep("Проверяем наличие приветственного сообщения", checkOpen(), "Open test stand exception");
    }

    @Step("Открываем вкладку 'Frames'")
    public void framesOpen (){
        framesButton.click();
        checkAndScreenShotStep("Проверяем наличие кнопки 'Nested Frames'", checkFramesOpen(), "Open 'Frames' exception");
    }

    @Step("Открываем вкладку 'Nested Frames'")
    public void nestedFramesOpen (){
        nestedFramesButton.click();
        checkAndScreenShotStep("Проверяем наличие нижнего фрейма", checkNestedFramesOpen(), "Open 'Nested Frames' exception");
    }

    @Step("Выводим на экран тело нижнего фрейма")
    public void bottomFrameBodyPrint (){
        String bodyText;
        DriverManager.getDriver().switchTo().frame(bottomFrame);
        bodyText = bodyInFrame.getText();
        System.out.println(bodyText);
        checkAndScreenShotStep("Проверяем считанное значение нижнего фрейма", bodyText.equals("BOTTOM"), "Read bottom frame exception");
    }

    @Step("Выводим на экран тело левого фрейма")
    public void leftFrameBodyPrint (){
        String bodyText;
        DriverManager.getDriver().switchTo().frame(topFrame).switchTo().frame(leftFrame);
        bodyText = bodyInFrame.getText();
        System.out.println(bodyText);
        checkAndScreenShotStep("Проверяем считанное значение левого фрейма", bodyText.equals("LEFT"), "Read left frame exception");
    }

    @Step("Выводим на экран тело центрального фрейма")
    public void middleFrameBodyPrint (){
        String bodyText;
        DriverManager.getDriver().switchTo().frame(topFrame).switchTo().frame(middleFrame);
        bodyText = bodyInFrame.getText();
        System.out.println(bodyText);
        checkAndScreenShotStep("Проверяем считанное значение центрального фрейма", bodyText.equals("MIDDLE"), "Read middle frame exception");
    }

    @Step("Выводим на экран тело правого фрейма")
    public void rightFrameBodyPrint (){
        String bodyText;
        DriverManager.getDriver().switchTo().frame(topFrame).switchTo().frame(rightFrame);
        bodyText = bodyInFrame.getText();
        System.out.println(bodyText);
        checkAndScreenShotStep("Проверяем считанное значение правого фрейма", bodyText.equals("RIGHT"), "Read right frame exception");
    }

    @Step("Обновить страницу")
    public void refresh() {
        DriverManager.getDriver().navigate().refresh();
    }




    public boolean checkOpen() {
        return checkOpen.isEnabled();
    }

    public boolean checkFramesOpen() {
        return checkFrames.isEnabled();
    }

    public boolean checkNestedFramesOpen() {
        return bottomFrame.isEnabled();
    }






}
