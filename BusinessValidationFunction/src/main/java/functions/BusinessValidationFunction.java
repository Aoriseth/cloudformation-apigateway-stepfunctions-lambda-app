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
public class BusinessValidationFunction implements RequestHandler<VehicleWithContext, VehicleWithContext> {

    public VehicleWithContext handleRequest(final VehicleWithContext input, final Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("received : " + input.toString());

        if ("Toyota".equals(input.getVehicle().getBrand())) {
        	input.setStatus("Valid");
        	return input;
        }else {
        	input.setStatus("Invalid");
        	return input;
        }
    }
}

class VehicleWithContext{
	private Vehicle vehicle;
	private String status;

	public Vehicle getVehicle(){
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle){
		this.vehicle = vehicle;
	}

	public String getStatus(){
		return this.status;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String toString(){
		return "{vehicle="+this.vehicle.toString()+"status="+this.status+"}";
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