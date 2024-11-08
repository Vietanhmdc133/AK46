package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormAuthenticationTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void shouldBeSuccessfullyWithValidCredentials() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        // verify message logged
        Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("You logged into a secure area!"));

        // verify current url
//        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
    }

    @Test
    void loginFailWithInvalidUsername() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith111");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your username is invalid!"));
    }

}
