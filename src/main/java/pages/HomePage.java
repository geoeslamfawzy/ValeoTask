package pages;

import base.UIActions;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    UIActions ui = new UIActions();
    private By pageTitle = By.xpath("//header/div/h1");
    public String getPageTitle(){
        return ui.findElement(pageTitle, WaitStrategy.VISIBLE).getText();
    }
}
