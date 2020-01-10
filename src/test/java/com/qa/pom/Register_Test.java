package com.qa.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;

public class Register_Test {
    private WebDriver driver;
    private  String url;
    Register_Page registerPage;

    @Before
    public void setUp(){
        url="http://newtours.demoaut.com/";
        registerPage=new Register_Page(driver);
        driver = registerPage.firefoxDriverConnection();
        registerPage.visit(url);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testRegisterPOM() throws InterruptedException{
        registerPage.registerUser();
        assertEquals("Note: Your user name is pepe0614.",registerPage.registerMessage());
    }

    @Test
    public void testLogInPOM() throws InterruptedException{
        registerPage.singIn();
       // assertEquals("");
    }

}
