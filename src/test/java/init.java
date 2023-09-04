import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class init {

    // Webdrivers and Strings
    WebDriver driver;
    static String GameID;
    static String Email;
    static String Pass;

    // Commands before Running Test
    @BeforeTest
    public void setUp() throws IOException, InterruptedException {
        // Get The Game ID
        GameID = JOptionPane.showInputDialog("Enter the game ID: ");
        // Enter Email
        Email = JOptionPane.showInputDialog("Enter Email: ");
        // Enter Password
        Pass = JOptionPane.showInputDialog("Enter Pass: ");

        // Set up the driver and navigate to the website
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://luna.amazon.com/settings");

    }

    // After Test Commands.
    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

    // Test Cases By Priority
    @Test(priority = 1)
    public void runUS_EN() throws IOException, InterruptedException {
        US_EN Script1 = new US_EN(driver);
        Script1.US_EN();
    }

    @Test(priority = 2)
    public void runCA_FR() throws IOException, InterruptedException {
        CA_FR Script2 = new CA_FR(driver);
        Script2.CA_FR();
    }

    @Test(priority = 3)
    public void runGR_DE() throws IOException, InterruptedException {
        GR_DE Script3 = new GR_DE(driver);
        Script3.GR_DE();
    }

    @Test(priority = 4)
    public void runUK_EN() throws IOException, InterruptedException {
        UK_EN Script4 = new UK_EN(driver);
        Script4.UK_EN();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        init testRunner = new init();
    }
}
