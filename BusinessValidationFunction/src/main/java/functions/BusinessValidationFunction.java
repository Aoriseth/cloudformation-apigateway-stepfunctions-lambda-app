package functions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

/**
 * Handler for requests to Lambda function.
 */
public class BusinessValidationFunction implements RequestHandler<Vehicle, Object> {

    public Object handleRequest(final Vehicle input, final Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");

        LambdaLogger logger = context.getLogger();
        logger.log("received : " + input);

        if ("Toyota".equals(input.getBrand())) {
        	return new GatewayResponse(input.toString(), headers, 200);
        }else {
        	return new GatewayResponse("Invalid", headers, 500);
        }
    }
}

class Vehicle {
	private String id;
	private String brand;

	public String getId(){
		return id;
	}

	public String getBrand(){
		return brand;
	}

	public void setId(String id){
		this.id = id;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}

	public String toString(){
		return "{id="+this.id + ",\n brand="+this.brand+"}";
	}

}