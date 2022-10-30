package com.ansupercomputer.systemresourcemonitor.cpu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cpu")
public class CpuController {
    @GetMapping
    public String testEndpoint() {
        return "Hello World!";
    }
}
