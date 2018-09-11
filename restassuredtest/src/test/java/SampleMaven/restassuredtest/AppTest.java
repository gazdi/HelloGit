package SampleMaven.restassuredtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;


public class AppTest 
{
    @Test
	public void SimpleApiTest()
    {
    	RequestSpecification req = given();
    	req.contentType("application/json");
    	req.body("\"zyxw\"");
    	Response resp = req.post("https://f5e1apm22h.execute-api.eu-west-2.amazonaws.com/stage/asadcsharpHelloWorld");
        assertEquals(200, resp.statusCode());
        assertEquals("\"ZYXW\"",resp.body().asString());
    }
    
    @Test
    public void FluidApiTest()
    {
    	given().
    		contentType("application/json").
    		body("\"abcd\"").
    	when().
    		post("https://f5e1apm22h.execute-api.eu-west-2.amazonaws.com/stage/asadcsharpHelloWorld").
    	then().
    		statusCode(200).
    		body(is("\"ABCD\""));
    }
}
