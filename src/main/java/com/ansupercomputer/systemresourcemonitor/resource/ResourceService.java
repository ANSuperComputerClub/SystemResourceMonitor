package com.ansupercomputer.systemresourcemonitor.resource;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;

import java.util.List;

public class ResourceService {
    Components components;
    public ResourceService() {
        components = JSensors.get.components();
        try {
            checkSensors();

        } catch (Throwable e) {
            System.out.println("Failed with exception: " + e);
        }
    }

    public void checkSensors() throws SensorNotFoundException {
        List<Cpu> cpus = components.cpus;
        if(cpus == null) throw new NoCpuSensorFoundException();
    }
}
