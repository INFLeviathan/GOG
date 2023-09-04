import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class CA_FR {
    private WebDriver driver;

    //Construct to accept WebDriver Instance
    public CA_FR(WebDriver driver){
        this.driver =driver;
    }
    @Test(priority = 2)
    public void CA_FR() throws InterruptedException, IOException {
        Date currentdate = new Date();
        String screenshotfilename = currentdate.toString().replace(" ", "_");
        Thread.sleep(2000);

        // Select Setting
        Actions Settings = new Actions(driver);
        Settings.keyDown(Keys.ARROW_UP).perform();
        Thread.sleep(4000);
        Settings.keyDown(Keys.ENTER).perform();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@id=\"collection_sub_nav_settings\"]/div/nav/ol/div[6]/div")).click();
        Thread.sleep(2000);
        Actions DevOps = new Actions(driver);
        DevOps.keyDown(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).keyUp(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("//div[@id=\"collection_sub_nav_settings\"]/div/nav/ol/div[7]/div")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("(//*[@class=\"_xnl19r\"])[5]")).click();
        Thread.sleep(4000);

        //Take Screenshot for Language Change
        File ScreenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Destinationfile = new File("/Users/akshamon/Desktop/GOG/src/main/Screenshot//CA_FR_Language" + screenshotfilename + ".png");
        FileUtils.copyFile(ScreenshotFile, Destinationfile);


        //Navigate to Library
        driver.findElement(By.id("item_nav_library")).click();
        Thread.sleep(2000);

        //Enter GameID
        driver.findElement(By.id(init.GameID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id("start_game_session__action")).click();
        Thread.sleep(90000);
//

        File CA_Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File CA_Launch = new File("/Users/akshamon/Desktop/GOG/src/main/Screenshot//CA_FR_Launch" + screenshotfilename + ".png");
        FileUtils.copyFile(CA_Screenshot, CA_Launch);

        //Exit the game
        Actions Exit = new Actions(driver);
        Exit.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).sendKeys(Keys.TAB).perform(); //Shift+Tab
        Thread.sleep(4000);
        Exit.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).sendKeys(Keys.TAB).perform(); //Shift+Tab
        Thread.sleep(4000);
        Exit.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).sendKeys(Keys.TAB).perform(); //Shift+Tab
        Thread.sleep(4000);

        Exit.keyDown(Keys.ENTER).perform();
        Thread.sleep(2000);
        Exit.keyDown(Keys.ENTER).perform();
        Thread.sleep(2000);

        Actions SkipSurvey = new Actions(driver);
        SkipSurvey.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).sendKeys(Keys.TAB).perform();
        SkipSurvey.keyDown(Keys.ENTER).perform();
        Thread.sleep(10000);

    }
}
