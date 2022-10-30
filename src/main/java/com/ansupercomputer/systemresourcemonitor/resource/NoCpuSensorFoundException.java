package com.ansupercomputer.systemresourcemonitor.resource;

public class NoCpuSensorFoundException extends SensorNotFoundException {
    public String toString() {
        return "CPU Sensor not found";
    }
}
