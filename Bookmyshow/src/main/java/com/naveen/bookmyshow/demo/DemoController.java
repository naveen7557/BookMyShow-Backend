package com.naveen.bookmyshow.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/demo-controller")
    public ResponseEntity<String > demo()
    {
        return ResponseEntity.ok("hello from naveen");
    }
}
