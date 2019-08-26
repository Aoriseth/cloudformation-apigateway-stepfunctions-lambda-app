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

/**
 * Handler for requests to Lambda function.
 */
public class EnrichmentFunction implements RequestHandler<GatewayResponse, Object> {

    public Object handleRequest(final GatewayResponse input, final Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");

        EnrichedVehicle vehicle = new EnrichedVehicle();
        vehicle.setVehicle(input.getBody());
        vehicle.setVhfData("Events from VHF");
        
        return new GatewayResponse(vehicle.toString(), headers, 200);
    }
}

class EnrichedVehicle {
	private String vehicle;
	private String vhfData;

	public String getVehicle(){
		return vehicle;
	}
	public String getVhfData(){
		return vhfData;
	}	

	public void setVehicle(String vehicle){
		this.vehicle = vehicle;
	}
	public void setVhfData(String vhfData){
		this.vhfData = vhfData;
	}

	public String toString(){
		return "{vehicle="+this.vehicle + ",\n vhfData="+this.vhfData+"}";
	}

}