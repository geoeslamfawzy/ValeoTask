package pages;

import base.UIActions;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
    UIActions ui = new UIActions();
    private By title = By.xpath("//h2");
    private By menueBtn = By.id("menu-toggle");
    private By logoutBtn = By.xpath("//a[contains(text(), 'Logout')]");

    public String getTitlePage(){
        return ui.findElement(title, WaitStrategy.VISIBLE).getText();
    }

    public HomePage logout(){
        ui.clickOn(menueBtn, WaitStrategy.ClICKABLE);
        ui.clickOn(logoutBtn, WaitStrategy.ClICKABLE);
        return new HomePage();
    }
}
