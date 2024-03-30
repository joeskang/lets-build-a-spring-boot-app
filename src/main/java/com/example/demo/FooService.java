package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class FooService {

    public String fetchFoo() {
        return "foo";
    }
}
