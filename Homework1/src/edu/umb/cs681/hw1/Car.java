package edu.umb.cs681.hw1;

import java.util.ArrayList;

public class Car {

    private String make,model;
    private int mileage,year;
    private float price;
    private int dominationCount;

    public Car(String make, String model, int mileage, int year, float price){
        this.make=make;
        this.model=model;
        this.mileage=mileage;
        this.year=year;
        this.price=price;
    }

    public String getMake(){
        return this.make;
    }

    public String getModel(){
        return this.model;
    }

    public int getMileage(){
        return this.mileage;
    }

    public int getYear(){
        return this.year;
    }

    public float getPrice(){
        return this.price;
    }

    public void setDominationCount(ArrayList<Car> usedCars){
        int cnt=0;
        for (Car c:usedCars){
            if(!(c.equals(this))){
                if((c.getYear()<=this.getYear()) && (c.getMileage()>=this.getMileage()) && (c.getPrice()<=this.getPrice())) {
                    if ((c.getYear() < this.getYear()) || (c.getMileage() > this.getMileage()) || (c.getPrice() < this.getPrice())) {
                        cnt++;
                    }
                }
            }
        }
        this.dominationCount=cnt;
    }

    public int getDominationCount(){
        return this.dominationCount;
    }
}
