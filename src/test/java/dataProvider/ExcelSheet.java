package dataProvider;
import helpers.ExcelHelper;
import org.testng.annotations.DataProvider;
import java.io.IOException;


public class ExcelSheet {
    @DataProvider(name="Booking_in_HonKong")
    public Object[][] getLoginData() throws IOException
    {
        ExcelHelper xl=new ExcelHelper("loginData");
        return xl.getDataFromExcel("Sheet1");
    }
    @DataProvider(name="apiData")
    public Object[][] getAllData() throws IOException
    {
        ExcelHelper xl=new ExcelHelper("createUser");
        return xl.getDataFromExcel("Sheet1");
    }
}
