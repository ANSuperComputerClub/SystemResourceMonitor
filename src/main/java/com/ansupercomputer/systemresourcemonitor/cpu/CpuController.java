package com.ansupercomputer.systemresourcemonitor.cpu;

import com.ansupercomputer.systemresourcemonitor.resource.ResourceService;
import com.ansupercomputer.systemresourcemonitor.resource.SensorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cpu")
public class CpuController {

    @Autowired
    private ResourceService service;

    public CpuController (ResourceService service) {
        this.service = service;
    }

    @GetMapping("diagnostic")
    public String cpuDiagnostics() throws SensorNotFoundException {
        return service.checkSensors();
    }
}
