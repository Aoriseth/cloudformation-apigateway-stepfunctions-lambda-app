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
	private String contextId;
	private Vehicle vehicle;
	private String status;

	public String getContextId(){
		return this.contextId;
	}

	public void setContextId(String contextId){
		this.contextId = contextId;
	}

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
	private String vehicleId;
	private String brand;
	private String vhfData;

	public String getVehicleId(){
		return vehicleId;
	}

	public String getBrand(){
		return brand;
	}

	public void setVehicleId(String vehicleId){
		this.vehicleId = vehicleId;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}

	public String getVhfData(){
		return this.vhfData;
	}

	public void setVhfData(String vhfData){
		this.vhfData = vhfData;
	}

	public String toString(){
		return "{vehicleId="+this.vehicleId + ",\n brand="+this.brand+",\n vhfData="+this.vhfData+"}";
	}

}