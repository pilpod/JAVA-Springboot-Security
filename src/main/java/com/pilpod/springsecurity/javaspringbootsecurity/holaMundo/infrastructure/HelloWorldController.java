package com.pilpod.springsecurity.javaspringbootsecurity.holaMundo.infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/api/v1", method = RequestMethod.GET, produces = "application/json")
public class HelloWorldController {
    
    @GetMapping(path = "/helloworld")
    public ResponseEntity<?> getMessage() {

        System.out.println("hello");

        Map<String,String> message = new HashMap<>();
        message.put("message", "Hello world!");

        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    
}
