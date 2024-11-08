package theinternet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HyperlinkTest {
    WebDriver driver;
    WebElement clickHere;

    @BeforeTest
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    void clickHyperLink() {
        driver.get("https://the-internet.herokuapp.com/status_codes");
        WebElement hyper200 = driver.findElement(By.linkText("200"));
        hyper200.click();
        clickHere = driver.findElement(By.xpath("//a[@href='/status_codes']"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/200");
        clickHere.click();
        WebElement hyper301 = driver.findElement(By.linkText("301"));
        hyper301.click();
        clickHere = driver.findElement(By.linkText("here"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/301");
        clickHere.click();
        WebElement hyper404 = driver.findElement(By.linkText("404"));
        hyper404.click();
        clickHere = driver.findElement(By.linkText("here"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/404");
        clickHere.click();
        WebElement hyper500 = driver.findElement(By.linkText("500"));
        hyper500.click();
        clickHere = driver.findElement(By.linkText("here"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/500");
        clickHere.click();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
