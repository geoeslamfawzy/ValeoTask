package api.tests;

import api.endpoints.Reqres;
import api.payloads.CreateUserPayload;
import dataProvider.ExcelSheet;
import dataProvider.Json;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;


public class CreateUser {
    @Test(dataProviderClass = ExcelSheet.class, dataProvider = "apiData")
    public void testPostUser(String name, String job){
        HashMap<String, String> payload = new HashMap<String, String>();
        payload.put("name", name);
        payload.put("job", job);
        Response response = Reqres.createUser(payload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),201);
    }
}
