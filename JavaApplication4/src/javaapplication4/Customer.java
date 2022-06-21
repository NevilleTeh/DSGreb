/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

/**
 *
 * @author hongjun
 */
public class Customer {
 
    private String customerName;
    private String arrivalTime;
    private int capacity;
    private String startPoint;
    private String destination;
    

    public Customer() {
        
    }

 
    public Customer (String customerName, String arrivalTime, int capacity, String startPoint, String destination) {
        this.customerName = customerName;
        this.arrivalTime = arrivalTime;
        this.capacity = capacity;
        this.startPoint = startPoint;
        this.destination = destination;
        
        
        
    }
   
    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
