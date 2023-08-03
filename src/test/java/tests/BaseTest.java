package tests;

import driver.DriverActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest{
    protected BaseTest(){}

    @BeforeMethod
    protected void setUp() throws Exception {
        System.out.println(Thread.currentThread().getId());
        DriverActions.initDriver();
    }
    @AfterMethod
    protected void tearDown(){
        System.out.println(Thread.currentThread().getId());
        DriverActions.quitDriver();
    }
}

