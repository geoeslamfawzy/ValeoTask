package pages;

import base.UIActions;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage {
    UIActions ui = new UIActions();
    private By facility = By.id("combo_facility");
    private By noneRadio = By.id("radio_program_none");
    private By calendar = By.id("txt_visit_date");
    private By anyDate = By.xpath("//td[text() = \"3\"]");
    private By bookBtn = By.id("btn-book-appointment");

    public void chooseFacility(String facility){
        ui.chooseFromMenu(this.facility, facility);
    }
    public void chooseNonHealthProgram(){
        ui.findElement(noneRadio, WaitStrategy.ClICKABLE);
    }
    public void chooseDate(){
        ui.findElement(calendar,WaitStrategy.ClICKABLE).click();
        ui.findElement(anyDate, WaitStrategy.ClICKABLE).click();
    }
    public void clickOnBookingBtn(){
        ui.findElement(bookBtn, WaitStrategy.ClICKABLE);
    }

    public ConfirmationPage makeAppointment(String facility){
        chooseFacility(facility);
        chooseNonHealthProgram();
        chooseDate();
        clickOnBookingBtn();
        return new ConfirmationPage();
    }
}
