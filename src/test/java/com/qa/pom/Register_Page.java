package com.qa.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Register_Page extends Base{

    By registerLinkLocator= By.linkText("REGISTER");
    By signOffLinkLocator= By.linkText("SIGN-OFF");
    By signOnLinkLocator = By.linkText("SIGN-ON");

    By homeTab= By.xpath("//a[@href='mercurywelcome.php']");

    By signInUserNameLocator= By.name("userName");
    By signInPasswordLocator= By.name("password");
    By signInSubmit= By.name("login");

    By registerPageLocator= By.xpath("//img[@src='/images/masts/mast_register.gif']");

    By usernameLocator=By.id("email");
    By passwordLocator=By.name("password");
    By confirmPasswordLocator= By.cssSelector("input[name='confirmPassword']");

    By registerButtonLocator=By.name("register");
    By fontLocator=By.tagName("font");


    public Register_Page(WebDriver driver){
        super(driver);
    }


    public void registerUser() throws InterruptedException{
        click(registerLinkLocator);
        Thread.sleep(2000);
        if (isDisplayed(registerPageLocator)){
            type("pepe0614",usernameLocator);
            type("123456",passwordLocator);
            type("123456",confirmPasswordLocator);
            Thread.sleep(2000);
            click(registerButtonLocator);
        }
    }

    public String registerMessage(){
        List<WebElement> fonts = findElements(fontLocator);
        return getText(fonts.get(5));
    }

    public void singIn() throws  InterruptedException{
        click(signOnLinkLocator);
        Thread.sleep(2000);
        if(isDisplayed(signInUserNameLocator)){
            type("pepe0614",signInUserNameLocator);
            type("123456",signInPasswordLocator);
            Thread.sleep(2000);
            click(signInSubmit);
        }
    }
}
