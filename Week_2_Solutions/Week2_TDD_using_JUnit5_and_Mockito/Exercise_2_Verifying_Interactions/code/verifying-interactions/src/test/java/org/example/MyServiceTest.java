package org.example;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {

        // Step 1: created a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        //Step 2: Call method on service
        MyService service = new MyService(mockApi);
        String result= service.fetchData();

        //verify the getData() was called on the mock

        verify(mockApi).getData("database");

    }
  
}