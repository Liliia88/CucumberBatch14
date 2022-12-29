package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import steps.PageInitializer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class CommonMethods extends PageInitializer {
    public static WebDriver driver;

    public static SoftAssert softAssertion = new SoftAssert();


    public static void openBrowserAndLaunchApplication() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        initializePageObjects();

        //to configure the file and pattern of it, we need to call the file

        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("My first test case is Login test");
        Log.info("My login test is going on");
        Log.warning("My test case might be failed");
    }

    public static void closeBrowser() {
        Log.info("My test case is about to complete");
        Log.endTestCase("This is my login test again");
        driver.quit();
    }

    //we use this method instead of send keys method throughout the framework
    public static void sendText(WebElement element, String textToSend) {
        element.clear();
        element.sendKeys(textToSend);
    }

    //to get webdriver wait
    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    //this method will wait for the element to be clickable
    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    //this method will perform click operation but before perform click, it will wait
    //for the element to be clickable
    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    //this method will return JavascriptExecutor Object

    public static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    //this function will perform click on element using javascript executor
    public static void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    //selecting the dropdown using text
    public static void selectDropdown(WebElement element, String text) {
        Select s = new Select(element);
        s.selectByVisibleText(text);
    }

    public static byte[] takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile,
                    new File(Constants.SCREENSHOT_FILEPATH + fileName + " " +
                            getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    //public static void dropDown (WebElement webElement, String dropDownValue){
    //  Select dropDown = new Select(webElement);
    //  dropDown.selectByVisibleText(dropDownValue);
    //}
    public static void assertMethod(WebElement element) {
        softAssertion.assertTrue(element.isDisplayed());
        softAssertion.assertAll();
    }

    public static void calendar(WebElement a, WebElement b, WebElement c, String month, WebElement d, String year, List<WebElement> webEl, String value) {
        assertMethod(a);
        click(b);
        selectDropdown(c, month);
        selectDropdown(d, year);
        boolean isFound = false;
        while (!isFound) {
            for (WebElement date : webEl) {
                String currentDate = date.getText();
                if (currentDate.equalsIgnoreCase(value)) {
                    date.click();
                    isFound = true;
                    break;
                }
            }
        }
    }
    public static void varification(List<WebElement> a, String skillsValue, List<WebElement> c, String skillsyear) {
        for (int i = 0; i < a.size(); i++) {
            String textActualSkills = a.get(i).getText();
           // Assert.assertEquals(textActualSkills, skillsValue);
            if (textActualSkills.equalsIgnoreCase(skillsValue)) {
                System.out.println("value " + skillsValue + " is varified");
            }
        }
        for (int i = 0; i < c.size(); i++) {
            String textActualYear = c.get(i).getText();
           // Assert.assertEquals(textActualYear, skillsyear);
            if (textActualYear.equalsIgnoreCase(skillsyear)) {
                System.out.println("value " + skillsyear + " is varified");
            }
        }
    }
}

