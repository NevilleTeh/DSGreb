/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author hongjun
 */
public class queueDriver {
    
    //Create variable needed in a driver
    Queue<String> qName = new Queue<>();
    Queue<String> qStatus = new Queue<>();
    Queue<Integer> qCapacity = new Queue<>();
    Queue<String> qLocation = new Queue<>();
    Queue<String> qArrivalTime = new Queue<>();
    Queue<String> qPickupTime = new Queue<>();
    Queue<ArrayList<Double>> qReputation = new Queue<>();
    Queue<String> qCustomer = new Queue<>();
    Queue<String> qComment = new Queue<>();
    
    
    String[] status = {"not available","available"};
    
    
    //Create driver if driver is entered
    public void add(String[] a){
        qName.enqueue(a[0]);  
        qCapacity.enqueue(Integer.parseInt(a[1]));
        qLocation.enqueue(a[2]+ " "+a[3]);      
        qCustomer.enqueue("-");
        qArrivalTime.enqueue("");
        qPickupTime.enqueue("");
        addAdditional();
        
    }
     
    public void addAdditional(){
        qStatus.enqueue(status[1]);
        qReputation.enqueue(new ArrayList<>());
     
    }
    
    
    
    // Calculate the arrival time of the customer to the destination
    public String arrivalTime(String time, double weightDriverSource, double weightSourceDestination){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime lt = LocalTime.parse(time);
        
        // Let say if 1 km need 1 minutes in real life
        int minute = 0;
        for(int i = 0 ; i < weightDriverSource ; i++){
            minute++;
        }
        for(int i = 0 ; i< weightSourceDestination ; i++){
            minute++;
        }
       
        return formatter.format(lt.plusMinutes(minute));
        
        
    }
    
    // Calculate the pickup up time for the driver to pick up the driver
    public String pickupTime(String time, double weightDriverSource){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime lt = LocalTime.parse(time);
        
        int minutes = 0;
        for(int i = 0 ; i < weightDriverSource ; i++){
            minutes++;
        }
        
        return formatter.format(lt.plusMinutes(minutes));
        
    }
    
    
    
    //Update the customer in the driver if the driver is responsible for the customer
    public void customer(String customerName, int index){
        qCustomer.set(index, customerName);
        qStatus.set(index, status[0]);
    }
     
    
    // Display the name status capacity location and customer of driver
    public void display(){      
        for(int i = 0 ; i < qName.getSize() ; i++){
           System.out.printf("%8s %20s %12d %25s  %15s \n",qName.getElement(i),qStatus.getElement(i),qCapacity.getElement(i), qLocation.getElement(i),qCustomer.getElement(i));           
        } 
        
    }
    
    // Display the driver availability for the customer
    public void displayDriverAva(){    
        for(int i = 0 ; i < qName.getSize() ; i++){
            // If the driver is not available, need not display
           if(qStatus.getElement(i).equalsIgnoreCase("not available")){
               continue;
           }
           System.out.printf("%8s %15s %20s %25s %s  \n",qName.getElement(i),qCapacity.getElement(i), qArrivalTime.getElement(i),qReputation.getElement(i),"/5.0");
            
        }
        
    }
    
    //Disaply the driver availability 
    public void displayDriver(LocalDateTime current){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
        
        
        System.out.println("\n");
        System.out.println("Drivers Lists (List Last Updated Time : "+ dtf.format(current)+ ")"); 
        System.out.println("(current time : "+ dateFormat.format(date)+ ")");
        System.out.println("===================================================================================================================================");
        System.out.printf("%10s %15s %30s %20s \n", "Driver","Capacity","Estimated Arrival Time","Reputation");

        displayDriverAva();

        System.out.println("===================================================================================================================================");

    }
    
    // Delete driver
    public void delete(String a){
        for(int i = 0 ; i < qName.getSize() ; i++){
            if(a.equalsIgnoreCase(qName.getElement(i))){
         
                qName.remove(i);
                qStatus.remove(i);
                qCapacity.remove(i);
                qLocation.remove(i);
                qCustomer.remove(i);         
                qReputation.remove(i);
                                
                System.out.println("Driver "+ a +" has been removed");        
            }
            
        }
    }
    
}
