package edu.umb.cs681.hw6;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        DataProcessing dataProcessing1 = new DataProcessing("Processing1");
        DataProcessing dataProcessing2 = new DataProcessing("Processing2");
        DataProcessing dataProcessing3 = new DataProcessing("Processing3");
        Thread t1= new Thread(dataProcessing1);
        Thread t2=new Thread(dataProcessing2);
        Thread t3=new Thread(dataProcessing3);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("All data processing tasks have completed.");
//        System.out.println("In Data Processing 1, The min, max for all the three columns have been printed in the following order: ");
//        System.out.println("max value for column1, max value for column2, max value for column3, min value for column1, min value for column 2, min value for column3");
//        System.out.println(dataProcessing1.Processing1());
//        System.out.println("For data processing 2, The Averages for all the values have been computed");
//        System.out.println(dataProcessing1.Processing2());
//        System.out.println("The min-max normalization for all the columns have been performed and returned as List<List<Double>>");
//        System.out.println(dataProcessing1.Processing3());
    }
}