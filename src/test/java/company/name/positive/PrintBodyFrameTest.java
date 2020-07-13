package company.name.positive;

import company.name.DriverManager;
import company.name.ScreenListener;
import company.name.page.StartPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenListener.class})
public class PrintBodyFrameTest {

    private StartPage step = new StartPage();

    @Test(groups = "Frame")
    public void printBodyFrame() {
        step.openTestStand();
        step.framesOpen();
        step.nestedFramesOpen();
        step.bottomFrameBodyPrint();
        step.refresh();
        step.middleFrameBodyPrint();
        step.refresh();
        step.leftFrameBodyPrint();
        step.refresh();
        step.rightFrameBodyPrint();
        DriverManager.quit();
    }
}
