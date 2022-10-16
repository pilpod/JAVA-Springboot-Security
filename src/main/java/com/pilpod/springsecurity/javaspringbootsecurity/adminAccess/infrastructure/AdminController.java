package com.pilpod.springsecurity.javaspringbootsecurity.adminAccess.infrastructure;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1", method = RequestMethod.GET, produces = "application/json")
public class AdminController {
    
    @GetMapping(path = "/admin")
    public ResponseEntity<?> getMessage() {

        Map<String,String> json = new HashMap<>();
        json.put("message", "Logged");

        return ResponseEntity.status(HttpStatus.OK).body(json);
    }
}
