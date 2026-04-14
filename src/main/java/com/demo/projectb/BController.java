package com.demo.projectb;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slt
public class BController {

    @GetMapping("/api/b/data")
    public ResponseEntity<String> getData(@RequestParam(defaultValue = "ok") String mode) throws InterruptedException {
        if ("slow".equalsIgnoreCase(mode)) {
            Thread.sleep(15000);
            return ResponseEntity.ok("Response from B (slow)");
        }

        if ("fail".equalsIgnoreCase(mode)) {
            return ResponseEntity.internalServerError().body("B failed intentionally");
        }

        return ResponseEntity.ok("Response from B (ok)");
    }

}
