/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ooc.enums.Make;

/**
 *
 * @author leila
 */
public class BookingSystem implements BookingSystemInterface {

    //Implementation of the abstract methods
    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
        RentACarInterface rent = null;
        List<CarInterface> cars = new ArrayList<>();
        String name;
        int id = 0;
        
        try(BufferedReader rd = in){
           String line;
           name = rd.readLine();
           
           while ((line = rd.readLine()) != null){
               String [] ln = line.split(":");
               Make make = Make.valueOf(ln[0]);
               double rate = Double.parseDouble(ln[1]);
               int available = Integer.parseInt(ln[2]);
               
               //Looping through the Array of cars
               for (int i=0; i<available; i++){
                   Car car = new Car(make, rate, id);
                   
                   cars.add(car);
                   id++;
               }
           }
           rent = new RentACar(cars, name, id);
       } catch (IOException e){
       }
        return rent;
       
    }

}
