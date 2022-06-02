package RestAssuredApiTesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import  io.restassured.response.Response.*;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;//for to use effectiviely some methods eg.equalTo
import static io.restassured.matcher.RestAssuredMatchers.*;


public class PostApiRequest {
	
	JSONObject request=new JSONObject();
	@Test
	public void TC1_PostMethod_ValidCredentials()
	{
		//creating the resourse on the server
		//map /json
		//gson,jackson,json and simple json
	//  Response response=RestAssured.get("");
		//Response response=get("");//ignoring the above error when adding static in that import function
		
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("email", "eve.holt@reqres.in");
//		map.put("password", "cityslicka");
//		System.out.println(map);
//		JSONObject request=new JSONObject(map);
//		System.out.println(request);//
//		System.out.println(request.toJSONString());
//		
		
//		given().baseUri("https://reqres.in/api/login").contentType("application/json").body("{\r\n" + 
//				"    \"email\": \"eve.holt@reqres.in\",\r\n" + 
//				"    \"password\": \"cityslicka\"\r\n" + 
//				"}").when().post().then().statusCode(200).log().all();
//			}

		
		try {
			//JSONObject request=new JSONObject();
			request.put("email", "eve.holt@reqres.in");
			request.put("password", "cityslicka");
			System.out.println(request.toJSONString());
			
			given().
			    header("Authorization","Bearer 123").
			    contentType(ContentType.JSON).
			    body(request.toJSONString()).relaxedHTTPSValidation().
			when().
			    post("https://reqres.in/api/login").
			then().
			assertThat().statusCode(200).
			assertThat().statusLine("HTTP/1.1 200 OK").
			log().all();
			
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
@Test
	public void TC2_PostMethod_EmptyEmail()
	{
	try {
		//JSONObject request=new JSONObject();
		request.put("email", "");
		request.put("password", "cityslicka");
		System.out.println(request.toJSONString());
		
		 given().
		    contentType(ContentType.JSON).
		    body(request.toJSONString()).relaxedHTTPSValidation().
		when().
		    post("https://reqres.in/api/login").
		then().
		  assertThat().statusCode(400).
		  assertThat().statusLine("HTTP/1.1 400 Bad Request").
		  assertThat().body("error", equalTo("Missing email or username")).
		  log().all();
		
	
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
}
@Test
public void TC3_PostMethod_EmptyPassword()
{
try {
	//JSONObject request=new JSONObject();
	request.put("email", "eve.holt@reqres.in");
	request.put("password", "");
	System.out.println(request.toJSONString());
	
	 given().
	    contentType(ContentType.JSON).
	    body(request.toJSONString()).relaxedHTTPSValidation().
	when().
	    post("https://reqres.in/api/login").
	then().
	  assertThat().statusCode(400).
	  assertThat().statusLine("HTTP/1.1 400 Bad Request").
	  assertThat().body("error", equalTo("Missing password")).
	  log().all();
	


} catch (Exception e) {
	// TODO Auto-generated catch block
	System.out.println(e.getMessage());
	e.printStackTrace();
}
}
@Test
public void TC4_PostMethod_EmptyPayload()
{
try {
	//JSONObject request=new JSONObject();
	request.put("email", "");
	request.put("password", "");
	System.out.println(request.toJSONString());
	
	 given().
	    contentType(ContentType.JSON).
	    body(request.toJSONString()).relaxedHTTPSValidation().
	when().
	    post("https://reqres.in/api/login").
	then().
	  assertThat().statusCode(400).
	  assertThat().statusLine("HTTP/1.1 400 Bad Request").
	  assertThat().body("error", equalTo("Missing email or username")).
	  log().all();
	


} catch (Exception e) {
	// TODO Auto-generated catch block
	System.out.println(e.getMessage());
	e.printStackTrace();
}
}
		
}