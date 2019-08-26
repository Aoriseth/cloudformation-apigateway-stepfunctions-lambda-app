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
public class ErrorFunction implements RequestHandler<RuntimeException, Object> {

    public Object handleRequest(final RuntimeException input, final Context context) {
    	LambdaLogger logger = context.getLogger();
        logger.log("Exception occured : " + input.getCause());
        
        return "Exception logged: "+input.getMessage()+"\nWith cause: "+input.getCause();
    }
}