package dev.danvega;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SimpleHandlerTest {

    private SimpleHandler handler;

    @Mock
    Context context;

    @Mock
    LambdaLogger logger;

    @BeforeEach
    public void setUp() throws Exception {
        when(context.getLogger()).thenReturn(logger);

        doAnswer(call -> {
            System.out.println((String)call.getArgument(0));
            return null;
        }).when(logger).log(anyString());

        handler = new SimpleHandler();
    }

    @Test
    void shouldHandSimpleRequest() {
        when(context.getFunctionName()).thenReturn("handleRequest");
        assertEquals("HELLO, WORLD!",handler.handleRequest("Hello, World!",context));
    }

}