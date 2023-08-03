package pages;

import base.UIActions;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    UIActions ui = new UIActions();
    private By usernameField = By.xpath("//input[@name='username']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By loginBtn = By.id("btn-login");

    public void insertUsernameField(String username){
        ui.writeIn(username, usernameField, WaitStrategy.VISIBLE);
    }
    public void insertPassword(String password){
        ui.writeIn(password, passwordField, WaitStrategy.VISIBLE);
    }

    public void clickOnLoginBtn(){
        ui.clickOn(loginBtn, WaitStrategy.ClICKABLE);
    }
    public AppointmentPage login(String username, String password){
        insertUsernameField(username);
        insertPassword(password);
        clickOnLoginBtn();
        return new AppointmentPage();
    }
}
