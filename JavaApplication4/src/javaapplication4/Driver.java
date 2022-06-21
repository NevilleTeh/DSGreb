/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

/**
 *
 * @author hongjun
 */
public class Driver {
    
    private String name;
    private int capacity;
    private String latitudeDriver;
    private String longtitudeDriver;

    public Driver() {
    }

    public Driver(String name, int capacity, String latitudeDriver, String longtitudeDriver) {
        this.name = name;
        this.capacity = capacity;
        this.latitudeDriver = latitudeDriver;
        this.longtitudeDriver = longtitudeDriver;
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLatitudeDriver() {
        return latitudeDriver;
    }

    public void setLatitudeDriver(String latitudeDriver) {
        this.latitudeDriver = latitudeDriver;
    }

    public String getLongtitudeDriver() {
        return longtitudeDriver;
    }

    public void setLongtitudeDriver(String longtitudeDriver) {
        this.longtitudeDriver = longtitudeDriver;
    }

    
    
    
}
