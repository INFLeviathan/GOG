import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class US_EN {
    private WebDriver driver;

    //Construct to accept WebDriver Instance
    public US_EN(WebDriver driver){
        this.driver =driver;
    }

    @Test(priority = 1)
    public void US_EN() throws InterruptedException, IOException {
        Date currentdate = new Date();
        String screenshotfilename = currentdate.toString().replace(" ", "_");

        // Select Login Credentials
        WebElement Username = driver.findElement(By.id("ap_email"));
        WebElement Password = driver.findElement(By.id("ap_password"));
        WebElement loginbtn = driver.findElement(By.id("signInSubmit"));
        // Enter Credentials
        Username.sendKeys(init.Email);
        Password.sendKeys(init.Pass);
        loginbtn.click();

        //Wait for 20 Sec for the Page to load
        Thread.sleep(20000);
        //Change language and Country
        driver.findElement(By.xpath("//div[@id=\"collection_sub_nav_settings\"]/div/nav/ol/div[6]/div")).click(); //Developer Option
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id=\"collection_sub_nav_settings\"]/div/nav/ol/div[7]/div")).click();  //Language Option
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"collection_language_selection\"]/div[3]/div/div")).click();
        Thread.sleep(2000);

        //Take Screenshot for Language Change
        File screenshotFile;
        screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("/Users/akshamon/Desktop/GOG/src/main/Screenshot//US_Language" + screenshotfilename + ".png");
        FileUtils.copyFile(screenshotFile, destinationFile);


        //Navigate to Library
        driver.findElement(By.id("item_nav_library")).click();
        Thread.sleep(2000);

        //Enter GameID
        driver.findElement(By.id(init.GameID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id("start_game_session__action")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("item_location_service_precheck_continue_button")).click();
        Thread.sleep(90000);
        File US_Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File US_launch = new File("/Users/akshamon/Desktop/GOG/src/main/Screenshot//US_Launch" + screenshotfilename + ".png");
        FileUtils.copyFile(US_Screenshot, US_launch);

        //Check for Exit button

        //Exit the game
        Actions LunaUi = new Actions(driver);
        LunaUi.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).sendKeys(Keys.TAB).perform(); //Shift+Tab
        Thread.sleep(3000);
        LunaUi.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).sendKeys(Keys.TAB).perform(); //Shift+Tab
        Thread.sleep(3000);
        LunaUi.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).sendKeys(Keys.TAB).perform(); //Shift+Tab
        Thread.sleep(3000);
//        LunaUi.keyDown(Keys.ARROW_DOWN).perform();
        LunaUi.keyDown(Keys.RETURN).sendKeys(Keys.RETURN).perform();
        Thread.sleep(2000);
        LunaUi.keyDown(Keys.RETURN).sendKeys(Keys.RETURN).perform();
        Thread.sleep(2000);


        Actions SkipSurvey = new Actions(driver);
        SkipSurvey.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).sendKeys(Keys.TAB).perform();
        SkipSurvey.keyDown(Keys.ENTER).perform();
        Thread.sleep(10000);
    }
}