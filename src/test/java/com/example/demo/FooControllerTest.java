package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FooControllerTest {

    @Mock
    FooService fooService;

    @InjectMocks
    FooController fooController;

    @Test
    void getFooResponse_validCall() {
        when(fooService.fetchFoo()).thenCallRealMethod();
        ResponseEntity<String> responseEntity = fooController.getFooResponse();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("foo", responseEntity.getBody());
    }
}
