package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/foo")
public class FooController {

    @Autowired
    FooService fooService;

    @GetMapping
    public ResponseEntity<String> getFooResponse() {
        try {
            return new ResponseEntity<>(fooService.fetchFoo(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to fetch foo.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    @RequestMapping("/spam")
    public ResponseEntity<HttpStatus> sendSpamMessage(@RequestBody SpamRequest spamRequest) {
        fooService.sendSpam(spamRequest.getMessage());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
