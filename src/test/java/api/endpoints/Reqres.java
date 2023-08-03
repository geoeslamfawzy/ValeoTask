package api.endpoints;

import api.payloads.CreateUserPayload;
import api.tests.CreateUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Reqres {
    public static Response createUser(HashMap<String, String> payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
        .when()
                .post(Routs.post_url);

        return response;
    }
}
