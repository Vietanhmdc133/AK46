package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    void validSelectInDropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        dropDown.selectByVisibleText("Option 1");
        WebElement selectedOption = dropDown.getFirstSelectedOption();
        String selectedText = selectedOption.getText();
        Assert.assertEquals("Option 1", selectedText);
    }

    @Test
    void selectMultipleOption() {
        driver.get("https://output.jsbin.com/osebed/2");

    }

    @AfterTest
    public void tearDown() {
        // Đóng trình duyệt sau khi hoàn thành test
        if (driver != null) {
            driver.quit();
        }
    }
}
