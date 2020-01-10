package qa.tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
public class NewTour_Automation {
    private WebDriver driver;
    By registerLinkLocator= By.linkText("REGISTER");
    By signOffLinkLocator= By.linkText("SIGN-OFF");
    By signOnLinkLocator = By.linkText("SIGN-ON");

    By signInUserNameLocator= By.name("userName");
    By signInPasswordLocator= By.name("password");
    By signInSubmit= By.name("login");

    By registerImagePageLocator= By.xpath("//img[@src='/images/masts/mast_register.gif']");

    By usernameLocator=By.id("email");
    By passwordLocator=By.name("password");
    By confirmPasswordLocator= By.cssSelector("input[name='confirmPassword']");

    By registerButtonLocator=By.name("register");
    By fontLocator=By.tagName("font");


    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","E:/Diplomado/DemoSeleniumFirst/src/test/resources/firefoxDriver/geckodriver.exe");
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://newtours.demoaut.com/");
    }

       @Test
       public void RegisterUser() throws InterruptedException {
           driver.findElement(registerLinkLocator).click();
           Thread.sleep(2000);
           if(driver.findElement(registerLinkLocator).isDisplayed())
           {
               driver.findElement(usernameLocator).sendKeys("pepe0614");
               driver.findElement(passwordLocator).sendKeys("123456");
               driver.findElement(confirmPasswordLocator).sendKeys("123456");
               driver.findElement(registerButtonLocator).click();

               Thread.sleep(30000);

           }
           else
           {
               System.out.println("Page Register not Found");
           }

           List<WebElement> fonts = driver.findElements(fontLocator);
           assertEquals("Note: Your user name is pepe0614.",fonts.get(5).getText());

       }

    @Test
    public void LogInValid() throws InterruptedException {
        driver.findElement(signOnLinkLocator).click();
        Thread.sleep(2000);
        if(driver.findElement(signOnLinkLocator).isDisplayed())
        {
            //driver.findElement(signInLinkLocator).click();
            Thread.sleep(2000);
            driver.findElement(signInUserNameLocator).sendKeys("pepe0614");
            driver.findElement(signInPasswordLocator).sendKeys("123456");
            driver.findElement(signInSubmit).click();
            Thread.sleep(30000);
        }
        else
        {
            System.out.println("Page SIGN IN not Found");
        }

        if(driver.findElement(signOffLinkLocator).isDisplayed())
        {
            System.out.println("The login was made successfully - TC passed ");
        }
        else
        {
            System.out.println("The login was NOT made successfully - TC failed");
        }

    }

    @Test
    public void LogInInvalid() throws InterruptedException {
        driver.findElement(signOnLinkLocator).click();
        Thread.sleep(2000);
        if(driver.findElement(signOnLinkLocator).isDisplayed())
        {
            //driver.findElement(signInLinkLocator).click();
            Thread.sleep(2000);
            driver.findElement(signInUserNameLocator).sendKeys("pepe0614asdsa");
            driver.findElement(signInPasswordLocator).sendKeys("123456sdas");
            driver.findElement(signInSubmit).click();
            Thread.sleep(30000);
        }
        else
        {
            System.out.println("Page SIGN IN not Found");
        }

        if(driver.findElement(signOnLinkLocator).isDisplayed())
        {
            System.out.println("The login was NOT made successfully - TC passed");
        }
        else
        {
            System.out.println("The login was made successfully - TC failed");
        }

    }

    @After
    public void tearDown(){
        //driver.quit();
    }
}
