package com.pilpod.springsecurity.javaspringbootsecurity.publicAccess.infrastructure;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1",method = RequestMethod.GET,produces = "application/json")
public class PublicController {
    
    @GetMapping(value = "/welcome")
    public ResponseEntity<?> getMessage() {

        Map<String,String> message = new HashMap<>();
        message.put("message", "Public Path");

        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    
}
