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
    
    Queue<String> qName = new Queue<>();
    //Queue<Integer> qId = new Queue<>();
    Queue<String> qStatus = new Queue<>();
    Queue<Integer> qCapacity = new Queue<>();
    Queue<String> qLocation = new Queue<>();
    Queue<String> qArrivalTime = new Queue<>();
    Queue<String> qPickupTime = new Queue<>();
    Queue<Double> qReputation = new Queue<>();
    Queue<String> qCustomer = new Queue<>();
    String[] status = {"not available","available"};
    
    
    
    public void add(String[] a){
        
        qName.enqueue(a[0]);  
        
        qCapacity.enqueue(Integer.parseInt(a[1]));
        qLocation.enqueue(a[2]+ " "+a[3]);
        //qId.enqueue(++sizeId);
        DecimalFormat df = new DecimalFormat("#.#");

        int range = 5 - 1 + 1;

        qReputation.enqueue(Double.valueOf((df.format((Math.random() * range) + 1))));
        addAdditional();
        qCustomer.enqueue("-");
        
    }
    
    
    
    public void addAdditional(){
      
        
        qStatus.enqueue(status[1]);
        double rep = (double)Math.random()*5;
        qReputation.enqueue(rep);
        
    }



    
    public String arrivalTime(String time, double weightDriverSource, double weightSourceDestination){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime lt = LocalTime.parse(time);
        
        // If 1 km need 1 minutes in real life, then 1 km uses one second in this application
        int second = 0;
        for(int i = 0 ; i < weightDriverSource ; i++){
            second++;
        }
        for(int i = 0 ; i< weightSourceDestination ; i++){
            second++;
        }

        return formatter.format(lt.plusMinutes(second));

        
    }
    
    public String pickupTime(String time, double weightDriverSource){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime lt = LocalTime.parse(time);
        
        int second = 0;
        for(int i = 0 ; i < weightDriverSource ; i++){
            second++;
        }
        
        return formatter.format(lt.plusMinutes(second));
        
    }
    
    
    
    public void customer(String customerName, int index){
        qCustomer.set(index, customerName);
        qStatus.set(index, status[0]);
    }
     
    
    public void display(){
        
          
        for(int i = 0 ; i < qName.getSize() ; i++){
           System.out.printf("%8s %20s %12d %22s  %18s \n",qName.getElement(i),qStatus.getElement(i),qCapacity.getElement(i), qLocation.getElement(i),qCustomer.getElement(i));
            
        } 
        
    }

    public boolean select(String drivername){
        for(int i = 0 ; i < qName.getSize() ; i++){
            if(qName.getElement(i).equals(drivername))
            {

                return true;
            }

        }
        return false;


    }

    public void displayDriverAva(){
     
        for(int i = 0 ; i < qName.getSize() ; i++){
           if(qStatus.getElement(i).equalsIgnoreCase("not available")){
               continue;
           }
           System.out.printf("%8s %15s %20s %25.1f  %s  \n",qName.getElement(i),qCapacity.getElement(i), qArrivalTime.getElement(i),qReputation.getElement(i),"/5.0");
            
        }
         //for(int i = 0 ; i < qName.getSize() ; i++){
           //System.out.printf("%8s %18s %15d %25s  %15s \n",qName.getElement(i),"status ",qCapacity.getElement(i), qLocation.getElement(i),"Customer");
            
        //} 
        
    }
    
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
    
    public void delete(String a){
        //int size = qName.getSize();
        for(int i = 0 ; i < qName.getSize() ; i++){
            if(a.equalsIgnoreCase(qName.getElement(i))){
         
                qName.remove(i);
                //qId.remove(i);
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
