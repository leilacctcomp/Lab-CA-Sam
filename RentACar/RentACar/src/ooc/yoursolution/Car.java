/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.util.HashMap;
import java.util.Map;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author leila
 */
public class Car implements CarInterface {

    //These properties is to accomplish the requirement "Cars have a make, a daily rate, an id and a calendar of availability"
    private Make make;
    private double rate;
    private int id;
    private Map<Month, boolean[]> availability;

    //Constructor with three paramenters
    public Car(Make make, double rate, int id) {
        this.make = make;
        this.rate = rate;
        this.id = id;
    }

    //implementation of all abstract methods
    //To keep track of the availability of all cars
    @Override
    public Map<Month, boolean[]> createAvailability() {
        availability = new HashMap<>();
        availability.put(Month.JANUARY, new boolean[Month.JANUARY.getNumberOfDays()]);
        availability.put(Month.FEBRUARY, new boolean[Month.FEBRUARY.getNumberOfDays()]);
        availability.put(Month.MARCH, new boolean[Month.MARCH.getNumberOfDays()]);
        availability.put(Month.APRIL, new boolean[Month.APRIL.getNumberOfDays()]);
        availability.put(Month.MAY, new boolean[Month.MAY.getNumberOfDays()]);
        availability.put(Month.JUNE, new boolean[Month.JUNE.getNumberOfDays()]);
        availability.put(Month.JULY, new boolean[Month.JULY.getNumberOfDays()]);
        availability.put(Month.AUGUST, new boolean[Month.AUGUST.getNumberOfDays()]);
        availability.put(Month.SEPTEMBER, new boolean[Month.SEPTEMBER.getNumberOfDays()]);
        availability.put(Month.OCTOBER, new boolean[Month.OCTOBER.getNumberOfDays()]);
        availability.put(Month.NOVEMBER, new boolean[Month.NOVEMBER.getNumberOfDays()]);
        availability.put(Month.DECEMBER, new boolean[Month.DECEMBER.getNumberOfDays()]);
        return availability;
    }

    //The Getters and Setters for the attributs
    @Override
    public Make getMake() {
        return make;
    }

    @Override
    public void setMake(Make make) {
        this.make = make;
    }

    @Override
    public double getRate() {
        return rate;
    }

    @Override
    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public Map<Month, boolean[]> getAvailability() {
        return availability;
    }

    @Override
    public void setAvailability(Map<Month, boolean[]> availability) {
        this.availability = availability;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isAvailable(Month month, int day) {
        return availability.get(month)[day - 1];
    }

    @Override
    public boolean book(Month month, int day) {
        boolean[] value = availability.get(month);
        if (availability.get(month)[day - 1]) {
            value[day - 1] = false;
            availability.replace(month, value);
            return true;

        } else {
            return false;
        }
    }
}
