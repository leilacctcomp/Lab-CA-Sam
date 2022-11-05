/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.util.List;
import java.util.Map;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author leila
 */
public class RentACar implements RentACarInterface {

    List<CarInterface> Cars;
    String name;
    int numCars;

    public RentACar(List<CarInterface> cars, String name, int numCars) {
        this.Cars = cars;
        this.name = name;
        this.numCars = numCars;
    }

    @Override
    public List<CarInterface> getCars() {
        return Cars;

    }

    @Override
    public void setCars(List<CarInterface> cars) {
        this.Cars = cars;

    }

    @Override
    public String getName() {
        return name;

    }

    @Override
    public void setName(String name) {
        this.name = name;

    }

    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {
        boolean check = false;
        for (CarInterface availability : Cars) {
            if (availability.getMake() == make) {
                for (int i = 0; i < lengthOfRent; i++) {
                    if (availability.getAvailability().get(month)[day + i - 1]) {
                        check = false;
                        break;
                    } else {
                        check = true;
                    }
                }
            }
        }
        return check;
    }

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
        int check = 0;
        for (CarInterface availability : Cars) {
            if (availability.getMake() == make) {
                for (int i = 0; i < lengthOfRent; i++) {
                    if (availability.getAvailability().get(month)[day + i - 1]) {
                        check = 0;
                        break;

                    } else {
                        check = availability.getId();
                    }
                }
                if (check != 0) {
                    break;
                }
            }
        }
        return check;
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        boolean check = false;
        for (CarInterface availability : Cars) {
            if (availability.getMake() == make) {
                for (int i = 0; i < lengthOfRent; i++) {
                    if (!availability.getAvailability().get(month)[day + i - 1]) {
                        Map<Month, boolean[]> available = availability.getAvailability();
                        boolean[] days = availability.getAvailability().get(month);
                        days[day + i + 1] = true;
                        available.replace(month, days);
                        availability.setAvailability(available);
                        check = true;
                    } else {
                        check = false;
                    }
                }
            } else {
                break;
            }
        }
        return check;
    }

    @Override
    public int getNumberOfCars() {
        return numCars;
    }

}
