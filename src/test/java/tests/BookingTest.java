package tests;

import dataProvider.ExcelSheet;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.ConfirmationPage;
import pages.HomePage;
import pages.LoginPage;

public class BookingTest extends BaseTest{
    private BookingTest(){};
    LoginPage loginPage = new LoginPage();
    AppointmentPage appointmentPage = new AppointmentPage();
    ConfirmationPage confirmationPage = new ConfirmationPage();
    HomePage homePage = new HomePage();
    @Test(dataProviderClass = ExcelSheet.class, dataProvider = "Booking_in_HonKong")
    public void testBook(String username, String password, String facility){
        loginPage.login(username, password);
         appointmentPage.makeAppointment(facility);
        String confirmationPageTitle = confirmationPage.getTitlePage();
        Assert.assertTrue(confirmationPageTitle.contains("Appointment"));
        confirmationPage.logout();
        String homePageTitle = homePage.getPageTitle();
        Assert.assertTrue(homePageTitle.contains("CURA Healthcare Service"));
    }
}
