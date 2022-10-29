package com.pilpod.springsecurity.javaspringbootsecurity.securityContextHolder.infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/api/v1")
public class ContextHolderController {

    private static final Logger logger = LoggerFactory.getLogger(ContextHolderController.class);
    
    @GetMapping(value="/context-holder")
    public ResponseEntity<?> getMessage() {

        var auth = SecurityContextHolder.getContext().getAuthentication();
        logger.info("Usuario: {}", auth.getPrincipal());
        logger.info("Permisos: {}", auth.getAuthorities());
        logger.info("Is Authenticated {}", auth.isAuthenticated());

        Map<String,String> message = new HashMap<>();
        message.put("message", "Context Holder");
        message.put("role", auth.getAuthorities().iterator().next().toString());

        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    
}
