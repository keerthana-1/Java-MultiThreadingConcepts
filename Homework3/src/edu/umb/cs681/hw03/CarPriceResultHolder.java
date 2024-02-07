package edu.umb.cs681.hw03;

public class CarPriceResultHolder {

    private int numCarExamined=0;
    private double average;
    private float price=0;


    public void setNumCarExamined(){
        this.numCarExamined++;
    }

    public void setPrice(float price){
        this.price=price;
        setNumCarExamined();
    }

    public float getPrice(){
        return this.price;
    }
    public void setAverage(CarPriceResultHolder c1){
        this.price+=c1.getPrice();
        this.numCarExamined+=c1.getNumCarExamined();
    }
    public int getNumCarExamined(){
        return numCarExamined;
    }

    public double getAverage(){
        return this.price/getNumCarExamined();
    }
}
