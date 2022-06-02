package RestAssuredApiTesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutApiRequest {
	
	JSONObject request=new JSONObject();
	@Test
	public void TC1_PutRequest_ExistingRequest()
	{
	try {
		request.put("name", "morpheus");
		request.put("job", "zion");
		System.out.println(request.toJSONString());
		
		 given().
		    contentType(ContentType.JSON).
		    body(request.toJSONString()).relaxedHTTPSValidation().
		when().
		    put("https://reqres.in/api/users/2").
		then().
		  assertThat().statusCode(200).
		  assertThat().statusLine("HTTP/1.1 200 OK").
		  assertThat().body("name", equalTo("morpheus")).
		  log().all();
		
	
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	}
	
	@Test
	public void TC2_PutRequest_ModifiedRequest()
	{
	try {
		request.put("name", "Narmada");
		request.put("job", "zion");
		System.out.println(request.toJSONString());
		
		 given().
		    contentType(ContentType.JSON).
		    body(request.toJSONString()).relaxedHTTPSValidation().
		when().
		    put("https://reqres.in/api/users/2").
		then().
		  assertThat().statusCode(200).
		  assertThat().statusLine("HTTP/1.1 200 OK").
		  assertThat().body("name", equalTo("Narmada")).//check whether the updated request is updated successfully
		  log().all();
		
	
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	}
	
	@Test
	public void TC3_PutRequest_NewRequest()
	{
	try {
		request.put("name", "Narmada");
		request.put("job", "zion");
		request.put("location", "Bangalore");
		System.out.println(request.toJSONString());
		
		 given().
		    contentType(ContentType.JSON).
		    body(request.toJSONString()).relaxedHTTPSValidation().
		when().
		    put("https://reqres.in/api/users/2").
		then().
		  assertThat().statusCode(200).
		  assertThat().statusLine("HTTP/1.1 200 OK").
		  assertThat().body("location", equalTo("Bangalore")).//check whether the updated request is updated successfully
		  log().all();
		
	
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	}

}
