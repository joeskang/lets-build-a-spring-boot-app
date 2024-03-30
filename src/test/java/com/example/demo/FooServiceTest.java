package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FooServiceTest {

    private final FooService fooService = new FooService();

    @Test
    void fetchFoo_success() {
        assertEquals("foo", fooService.fetchFoo());
    }

}