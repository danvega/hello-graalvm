package dev.danvega;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SimpleHandler implements RequestHandler<String,String> {

    @Override
    public String handleRequest(String input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Function '" + context.getFunctionName() + "' called");
        return input.toUpperCase();
    }

}
