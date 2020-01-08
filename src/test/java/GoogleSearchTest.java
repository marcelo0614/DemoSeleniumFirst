import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.TestCase.assertTrue;

public class GoogleSearchTest {
    private WebDriver driver;
    By videoLocator= By.cssSelector("a[href='https://www.youtube.com/watch?v=RbSlW8jZFe8']");
    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","E:/Diplomado/DemoSeleniumFirst/src/test/resources/firefoxDriver/geckodriver.exe");
        //System.setProperty("webdriver.chrome.driver","./src/test/resources/chromeDriver/chromedriver.exe");
        //driver = new ChromeDriver();
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("www.google.com");
    }

    @Test
    public void RegisterUser() throws InterruptedException {
        WebElement searchBox= driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.clear();
        searchBox.sendKeys("QA Automation video");
        searchBox.submit();
        Thread.sleep(3000);
        assertTrue(driver.findElement(videoLocator).isDisplayed());

    }

    @After
    public void tearDown(){
        //driver.quit();
    }
}
