package org.caselab;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    List<Car> cars = new ArrayList<>();

    public CarRepository() {
        Car car1 = new Car();
        car1.model = "Ford";
        car1.year = 2010;
        car1.price = 10000;
        cars.add(car1);

        Car car2 = new Car();
        car2.model = "Toyota";
        car2.year = 2012;
        car2.price = 12000;
        cars.add(car2);

        Car car3 = new Car();
        car3.model = "Honda";
        car3.year = 2014;
        car3.price = 14000;
        cars.add(car3);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public void deleteCar(int index) {
        cars.remove(index);
    }

    public void updateCar(int index, Car car) {
        cars.set(index, car);
    }
}
