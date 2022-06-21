/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

import java.sql.*;
import java.util.Formatter;
import javax.swing.JOptionPane;

/**
 *
 * @author hongjun
 */
public class queueCustomer {
    
    //Create varialbe of a customer
    Queue<String> qName = new Queue<>();
    Queue<String> qStatus = new Queue<>();
    Queue<String> qTime = new Queue<>();
    Queue<Integer> qCapacity = new Queue<>();
    Queue<String> qStartingPoint = new Queue<>();
    Queue<String> qDestination = new Queue<>();
    
    String[] status = {"pending","waiting","picked up","reached"};
    
    
    String url = "jdbc:mysql://localhost:3306/grab?user=root&password=steadybombibi";
        
    String query = "select * from sakila.actor";
        
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i , id, deleteItem;
    
    
    
    
    //Create customer
    public void add(String[] a){       
        qName.enqueue(a[0]);
        qTime.enqueue(a[1]);
       
        qCapacity.enqueue(Integer.parseInt(a[2]));
        qStartingPoint.enqueue(a[3]+ " "+ a[4]);
        qDestination.enqueue(a[5] + " "+ a[6]);
        addAdditional();
        
    }
    
    public void addAdditional(){
         qStatus.enqueue(status[0]);
    }
    
    // Change status of customer
    public void changeStatus(String customerName, String updatedStatus){
        if(qName.contains(customerName)){
            int index = qName.getIndex(customerName);
            qStatus.set(index, updatedStatus);
        }
    }
    
    // Display driver
    public void display(){
        for(int i = 0 ; i < qName.getSize() ; i++){
            System.out.printf("%9s %18s %15s %25d %20s %20s \n",qName.getElement(i), qStatus.getElement(i),qTime.getElement(i), qCapacity.getElement(i), qStartingPoint.getElement(i), qDestination.getElement(i));
            
        }
        
    }
    
    //Update customer such as name
    public void update(String name, String aspect,String newUpdate){
        try{     
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                sqlConn = DriverManager.getConnection(url);
                
               
                    for(int i = 0 ; i < qName.getSize() ; i++){
                        if(qName.getElement(i).equalsIgnoreCase(name)){
                            if(aspect.equalsIgnoreCase("n")){
                                qName.set(i, newUpdate);
                                String n = qName.getElement(i);
                                String[] start = qStartingPoint.getElement(i).split(" ");
                                String[] dest = qDestination.getElement(i).split(" ");
                                pst = sqlConn.prepareStatement("update grab.customer set"+" customerName = \""+  newUpdate+"\"" +  " where startLa = \""+ start[0] +"\"" + " and " + "startLo = \"" + start[1] + "\"" + " and " + "destLa = \"" + dest[0] + "\"" + " and " + "destLo = \"" + dest[1] + "\"" );
                            }
                            else if(aspect.equalsIgnoreCase("e")){
                                qTime.set(i, newUpdate);
                                String n = qName.getElement(i);   
        
                                pst = sqlConn.prepareStatement("update grab.customer set"+" arrivalTime = \""+  newUpdate+"\"" + " where customerName = \""+ n +"\"");
                            }
                            else if(aspect.equalsIgnoreCase("c")){
                                qCapacity.set(i, Integer.parseInt(newUpdate));
                                String n = qName.getElement(i);   
                       
                                pst = sqlConn.prepareStatement("update grab.customer set"+" capacity = \""+  newUpdate+"\"" + " where customerName = \""+ n +"\"");
                            }
                            else if(aspect.equalsIgnoreCase("s")){
                                qStartingPoint.set(i, newUpdate);
                                String n = qName.getElement(i);   
                                String[] newUpdateBreak = newUpdate.split(" ");
                                pst = sqlConn.prepareStatement("update grab.customer set"+" startLa = \""+  newUpdateBreak[0] +"\" , startLo = \"" + newUpdateBreak[1] + " \""+  " where customerName = \""+ n +"\"" );
                     
                            }
                            else if(aspect.equalsIgnoreCase("d")){
                                qDestination.set(i, newUpdate);
                                String n = qName.getElement(i);   
                                String[] newUpdateBreak = newUpdate.split(" ");
                                pst = sqlConn.prepareStatement("update grab.customer set"+" destLa = \""+  newUpdateBreak[0] +"\" , destLo = \"" + newUpdateBreak[1] + " \""+  " where customerName = \""+ n +"\"" );
                            }
                            else{
                                
                            }

                        }
                    }
                
                    //pst = sqlConn.prepareStatement("update grab.customer set customerName = ?, arrivalTime = ?,capacity = ? , startLa = ? , startLo = ?, DestLa = ? ,  DestLo = ? where customerID = ?");
                
                    

                
                    pst.execute();
      
                    //upDateDB();
                
                
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage());
       }
    }   
        
        
//        
//        try{     
//                
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                sqlConn = DriverManager.getConnection(url);
//                
//               
//                
//                pst = sqlConn.prepareStatement("update grab.customer set customerName = ?, arrivalTime = ?,capacity = ? , startLa = ? , startLo = ?, DestLa = ? ,  DestLo = ? where customerID = ?");
//                
//                    
//                    pst.setString(1, jtxtUpdateName.getText());
//                    pst.setString(2, jtxtUpdateArrivalTime.getText());
//                    pst.setString(3, jtxtUpdateCapacity1.getText());
//                    pst.setString(4, jtxtUpdateStartLa.getText());
//                    pst.setString(5, jtxtUpdateStartLo.getText());
//                    pst.setString(6, jtxtUpdateDestLa.getText());
//                    pst.setString(7, jtxtUpdateDestLo.getText());
//                
//                    pst.executeUpdate();
//                    JOptionPane.showMessageDialog(this, "Customer Added Succesfully");
//                    upDateDB();
//                
//                
//       }catch(Exception e){
//           JOptionPane.showMessageDialog(null,e.getMessage());
//       }
//        
//        
        
        
        
        
        
        
        
    
    
    
    
    
    
    
    
}
