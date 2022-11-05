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

    //Using the same function to check if the car is available
    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {
        int availableId = getCarAvailable(month, day, make, lengthOfRent);

        return (availableId != -1);

    }

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
        int check = -1;
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

                if (check != -1) {
                    break;
                }
            }
        }
        return check;
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        int availableId = getCarAvailable(month, day, make, lengthOfRent);

        //This is gonna return -1 if the car is not available
        if (availableId == -1) {
            return false;
        }

        CarInterface car = null;
        for (CarInterface candidate : Cars) {
            if (candidate.getId() == availableId) {
                car = candidate;
                break;
            }
        }

        //Is gonna loop through the days to get the availability
        boolean[] days = car.getAvailability().get(month);
        for (int i = 0; i < lengthOfRent; i++) {
            days[day + i - 1] = true;
        }

        return true;

    }

    @Override
    public int getNumberOfCars() {
        return numCars;
    }

}
