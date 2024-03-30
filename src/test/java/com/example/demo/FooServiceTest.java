package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

class FooServiceTest {

    private final FooService fooService = new FooService();

    @Test
    void fetchFoo_success() {
        assertEquals("foo", fooService.fetchFoo());
    }

}