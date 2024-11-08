package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest {
    @Test
    void checkBoxTickWithHeadless() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
//vang a
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1 = driver.findElement(By.cssSelector("form#checkboxes input:nth-of-type(1)"));
        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }
        Assert.assertTrue(checkBox1.isSelected());

        WebElement checkBox2 = driver.findElement(By.cssSelector("form#checkboxes input:nth-of-type(3)"));
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }
        Assert.assertTrue(checkBox2.isSelected());
        driver.quit();
    }

}
