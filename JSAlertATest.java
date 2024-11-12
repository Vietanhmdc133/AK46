package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JSAlertATest {
    WebDriver driver;

    @BeforeTest
    void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    void clickAlertSuccessFull() {

        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();

        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You successfully clicked an alert");
    }

    @Test
    void clickOKInJSAlertConfirm() {
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();

        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Ok");
    }

    @Test
    void clickCancelInJSAlertConfirm() {
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();

        driver.switchTo().alert().dismiss();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
    }

    @Test
    void verifyInputPromptInJSAlertConfirm() {
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();

        driver.switchTo().alert().sendKeys("hello");
        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: hello");
    }


    @AfterTest
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
