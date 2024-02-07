package edu.umb.cs681.hw05;

public class Main {
    public static void main(String[] args){
        DataProcessing dataProcessing = new DataProcessing();
        System.out.println("In Data Processing 1, The min, max for all the three columns have been printed in the following order: ");
        System.out.println("max value for column1, max value for column2, max value for column3, min value for column1, min value for column 2, min value for column3");
        System.out.println(dataProcessing.Processing1());
        System.out.println("For data processing 2, The Averages for all the values have been computed");
        System.out.println(dataProcessing.Processing2());
        System.out.println("The min-max normalization for all the columns have been performed and returned as List<List<Double>>");
        System.out.println(dataProcessing.Processing3());
    }
}
