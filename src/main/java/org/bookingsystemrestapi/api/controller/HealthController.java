package org.bookingsystemrestapi.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public String checkAPI() {
        System.out.println("Si funciona");
        return "<h1>The API is working ok!</h1>";
    }
}

