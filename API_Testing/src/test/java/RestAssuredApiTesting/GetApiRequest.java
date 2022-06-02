package RestAssuredApiTesting;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetApiRequest{

	
	@Test
	public void TC1_GetMethodRequests()
	{
		try {
	System.out.println("a");
			given().
			    param("query","new york").
			    param("locale","en_US").
			    param("currency","USD").
			    header("X-RapidAPI-Host","hotels4.p.rapidapi.com").
			    header("X-RapidAPI-Key","('Subscribe To Test' using your login to get the key - https://rapidapi.com/apidojo/api/hotels4/)").relaxedHTTPSValidation().
			when().get("https://hotels4.p.rapidapi.com/locations/v2/search").
			then().
			assertThat().statusCode(403).
			assertThat().statusLine("HTTP/1.1 403 Forbidden").
			assertThat().body("message",equalTo("You are not subscribed to this API.")).
			log().all();
			
		
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
