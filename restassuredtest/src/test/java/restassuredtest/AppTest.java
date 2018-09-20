package restassuredtest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

import model.*;

public class AppTest 
{
    @Test
    public void GetMCCTest() {
    	GetMCCCodesSuccessResponse resp;
    	
    	resp = new GetMCCCodesSuccessResponse(
    	 given()
    	.when()
    	.get("http://masterbuilder:9102/api/eAppApplication/GetMCCCodes")
    	.then()
    	.statusCode(200)
    	.extract()
    	.body()
    	//.as(GetMCCCodesSuccessResponse.class); will give java.lang.IllegalStateException: Expected BEGIN_OBJECT but was BEGIN_ARRAY at line 1
    	.jsonPath().getList(".", MCC.class));
    	
    	System.out.println("Response as custom class: " + resp.toString() + "\r\n");  
    	System.out.println("First: {" + resp.getMCCs().get(0).getElavonCode() + "; "
    								 + resp.getMCCs().get(0).getMccCode() + "; "
    								 + resp.getMCCs().get(0).getMccDescription() + "}");
    }

    
//    @Test
//	public void SimpleApiTest()
//    {
//    	RequestSpecification req = given();
//    	req.contentType("application/json");
//    	req.body("\"zyxw\"");
//    	Response resp = req.post("https://f5e1apm22h.execute-api.eu-west-2.amazonaws.com/stage/asadcsharpHelloWorld");
//        assertEquals(200, resp.statusCode());
//        assertEquals("\"ZYXW\"",resp.body().asString());
//    }
//    
//    @Test
//    public void FluidApiTest()
//    {
//    	given().
//    		contentType("application/json").
//    		body("\"abcd\"").
//    	when().
//    		post("https://f5e1apm22h.execute-api.eu-west-2.amazonaws.com/stage/asadcsharpHelloWorld").
//    	then().
//    		statusCode(200).
//    		body(is("\"ABCD\""));
//    }
}
