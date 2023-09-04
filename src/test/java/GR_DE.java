import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class GR_DE {

    private WebDriver driver;

    //Construct to accept WebDriver Instance
    public GR_DE(WebDriver driver) {
        this.driver = driver;
    }
    @Test(priority = 4)
    public void GR_DE() throws InterruptedException, IOException {
        Date currentdate = new Date();
        String screenshotfilename = currentdate.toString().replace(" ", "_");
        Thread.sleep(1000);

        // Select Setting
        Actions Settings = new Actions(driver);
        Settings.keyDown(Keys.ARROW_UP).perform();
        Thread.sleep(4000);
        Settings.keyDown(Keys.ENTER).perform();
        Thread.sleep(2000);

//      Developer Option
        WebElement Dev = driver.findElement(By.xpath("//div[@id=\"collection_sub_nav_settings\"]/div/nav/ol/div[6]/div"));
        Thread.sleep(500);
        Dev.click();
        Thread.sleep(2000);
        Actions DevOps = new Actions(driver);
        DevOps.keyDown(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).keyUp(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
//      Language Option
        driver.findElement(By.xpath("//div[@id=\"collection_sub_nav_settings\"]/div/nav/ol/div[7]/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"collection_language_selection\"]/div[6]/div[1]")).click();
        Thread.sleep(3000);

        //Take Screenshot for Language Change
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("/Users/akshamon/Desktop/GOG/src/main/Screenshot//DE_Language" + screenshotfilename + ".png");
        FileUtils.copyFile(screenshotFile, destinationFile);


        //Navigate to Library
        driver.findElement(By.xpath("(//div[@role= \"button\"])[4][1]")).click();
        Thread.sleep(3000);

        //Enter GameID
        driver.findElement(By.id(init.GameID)).click();
        Thread.sleep(3000);
        driver.findElement(By.id("start_game_session__action")).click();

        Thread.sleep(90000);
        File LaunchscreenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File LaunchFile = new File("/Users/akshamon/Desktop/GOG/src/main/Screenshot//DE_Launch" + screenshotfilename + ".png");
        FileUtils.copyFile(LaunchscreenshotFile, LaunchFile);

        //Exit the game
        Actions LunaUi = new Actions(driver);
        LunaUi.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).sendKeys(Keys.TAB).perform(); //Shift+Tab
        Thread.sleep(4000);
        LunaUi.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).sendKeys(Keys.TAB).perform(); //Shift+Tab
        Thread.sleep(4000);
        LunaUi.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).sendKeys(Keys.TAB).perform(); //Shift+Tab
        Thread.sleep(4000);
        LunaUi.keyDown(Keys.ENTER).perform();
        Thread.sleep(2000);
        LunaUi.keyDown(Keys.ENTER).perform();
        Thread.sleep(1000);

        Actions SkipSurvey = new Actions(driver);
        SkipSurvey.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).sendKeys(Keys.TAB).perform();
        SkipSurvey.keyDown(Keys.ENTER).perform();
        Thread.sleep(10000);
    }

}
