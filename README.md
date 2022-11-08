# AWS Lambda + GraalVM Demo

I am trying to get a simple AWS Lambda + GraalVM demo working. 

If you clone this project and run `mvn package -P native-image` you will get a `function.zip` that you can 
upload to AWS Lambda as a new function. This function takes in a String as the input and will return the uppercase 
version of the input. 

```java
public class SimpleHandler implements RequestHandler<String,String> {

    @Override
    public String handleRequest(String input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Function '" + context.getFunctionName() + "' called");
        return input.toUpperCase();
    }

}
```

If you try and test this through the AWS Console you will get the following error: 

```bash
/var/task/bootstrap: line 3: ./hello-graalvm: cannot execute binary file
/var/task/bootstrap: line 3: ./hello-graalvm: cannot execute binary file
START RequestId: dcd6569e-9716-47ef-b1c0-106e80aa110a Version: $LATEST
RequestId: dcd6569e-9716-47ef-b1c0-106e80aa110a Error: Runtime exited with error: exit status 126
Runtime.ExitError
END RequestId: dcd6569e-9716-47ef-b1c0-106e80aa110a
REPORT RequestId: dcd6569e-9716-47ef-b1c0-106e80aa110a	Duration: 43.11 ms	Billed Duration: 44 ms	Memory Size: 128 MB	Max Memory Used: 3 MB	
```

Notes: 

- I wonder if this has to do with the fact that I am running the native build on my local MacBook and the custom runtime is Linux. 