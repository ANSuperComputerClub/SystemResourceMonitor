package com.ansupercomputer.systemresourcemonitor.resource;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResourceService {
    Components components;
    public ResourceService() {
        components = JSensors.get.components();
    }

    /**
     * Checks all the CPU sensors
     * @return a String with a bunch of CPU diagnostics
     * @throws SensorNotFoundException when it can't find any CPUs
     */
    public String checkSensors() throws SensorNotFoundException {
        StringBuilder output = new StringBuilder();
        List<Cpu> cpus = components.cpus;
        if(cpus == null) throw new NoCpuSensorFoundException();
        for(final Cpu cpu: cpus) {
            output.append("CPU Name: ").append(cpu.name).append("\n");
            if(cpu.sensors == null) throw new NoCpuSensorFoundException();
            output.append(("Sensors: ") + "\n");

            //Print temperatures
            List<Temperature> temps = cpu.sensors.temperatures;
            for (final Temperature temp : temps) {
                output.append(temp.name).append(": ").append(temp.value).append(" C").append("\n");
            }

            //Print fan speed
            List<Fan> fans = cpu.sensors.fans;
            for (final Fan fan : fans) {
                output.append(fan.name).append(": ").append(fan.value).append(" RPM").append("\n");
            }
        }
        return output.toString();
    }
}
