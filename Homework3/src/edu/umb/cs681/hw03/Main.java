package edu.umb.cs681.hw03;

import edu.umb.cs681.hw03.Car;
import edu.umb.cs681.hw03.CarPriceResultHolder;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Car> usedCars=new ArrayList<Car>();
        usedCars.add(new Car("toyota","RAV4",5000,2020,42000));
        usedCars.add(new Car("Audi","A7",6000,2019,41000));
        usedCars.add(new Car("Dodge","Viper",7000,2023,85000));
        usedCars.add(new Car("Chevrolet","Corvette",8000,2022,76000));
        usedCars.add(new Car("GMC","Acadia",9000,2021,41000));

        double averagePrice=usedCars.stream()
                .map(car->new CarPriceResultHolder(){{setPrice(car.getPrice());}})
                .reduce(new CarPriceResultHolder(),(result,price)->{
                    result.setAverage(price);
                    return result;
                },(finalResult,intermediateResult)->finalResult).getAverage();
        System.out.println("Average Price: "+averagePrice);

    }
}