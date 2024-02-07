package edu.umb.cs681.hw6;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProcessing implements Runnable{

    private String methodName;
    public DataProcessing(String methodName) {
        this.methodName=methodName;
    }

    public static List<List<Double>> getDataset() {
        Path path = Paths.get("src/edu/umb/cs681/hw6/GunsDataset.csv");
        List<List<Double>> gunsdata = null;
        try (Stream<String> lines = Files.lines(path)) {
            gunsdata = lines.skip(1)  // Skip the first row (headers)
                    .map(line -> {
                        return Stream.of(line.split(","))
                                .skip(1)  // Skip the first element (date)
                                .filter(value -> !value.isEmpty())  // Filter out empty strings
                                .map(value -> Double.parseDouble(value))
                                .collect(Collectors.toList());
                    }).collect(Collectors.toList());
        } catch (IOException ex) {
            ex.getMessage();
        }

        return gunsdata;
    }


    @Override
    public void run() {
        Method method = null;
        try {
            method = DataProcessing.class.getDeclaredMethod(this.methodName);
            System.out.println(method.invoke(this));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Double> Processing1(){
        // max, min values for all the three columns
        List<List<Double>> data = getDataset();
        double maxInFirstColumn = data.stream()
                .filter(nested -> !nested.isEmpty() && nested.size() > 2)
                .map(nested -> nested.get(0))
                .max(Double::compare).get();
        double maxInSecondColumn = data.stream()
                .filter(nested -> !nested.isEmpty() && nested.size() > 2)
                .map(nested -> nested.get(1))
                .max(Double::compare).get();
        double maxInThirdColumn = data.stream()
                .filter(nested -> !nested.isEmpty() && nested.size() > 2)
                .map(nested -> nested.get(2))
                .max(Double::compare).get();
        double minInFirstColumn = data.stream()
                .filter(nested -> !nested.isEmpty() && nested.size() > 2)
                .map(nested -> nested.get(0))
                .min(Double::compare).get();
        double minInSecondColumn = data.stream()
                .filter(nested -> !nested.isEmpty() && nested.size() > 2)
                .map(nested -> nested.get(1))
                .min(Double::compare).get();
        double minInThirdColumn = data.stream()
                .filter(nested -> !nested.isEmpty() && nested.size() > 2)
                .map(nested -> nested.get(2))
                .min(Double::compare).get();
        return List.of(maxInFirstColumn, maxInSecondColumn, maxInThirdColumn, minInFirstColumn, minInSecondColumn, minInThirdColumn);
    }

    public List<Double> Processing2() {
        //Averages for all the columns
        List<List<Double>> data = getDataset();
        // Calculate the average for the first column
        List<Double> column1 = data.stream()
                .filter(nested -> !nested.isEmpty() && nested.size() > 2)
                .map(nested -> nested.get(0))
                .collect(Collectors.toList());
        double sum = column1.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        double count = column1.size();
        // Calculate the average
        double average = sum / count;

        // Calculate the average for the Second column
        List<Double> column2 = data.stream()
                .filter(nested -> !nested.isEmpty() && nested.size() > 2)
                .map(nested -> nested.get(1))
                .collect(Collectors.toList());
        double sum2 = column2.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        double count2 = column2.size();
        // Calculate the average
        double average2 = sum2 / count2;

        // Calculate the average for the third column
        List<Double> column3 = data.stream()
                .filter(nested -> !nested.isEmpty() && nested.size() > 2)
                .map(nested -> nested.get(2))
                .collect(Collectors.toList());
        double sum3 = column3.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        double count3 = column3.size();
        // Calculate the average
        double average3 = sum3 / count3;

        // Create a List<Double> to hold the average
        List<Double> averageList = new ArrayList<>();
        averageList.add(average);
        averageList.add(average2);
        averageList.add(average3);
        return averageList;
    }

    public List<List<Double>> Processing3(){
        //Min - max normalization
        List<List<Double>> data = getDataset();
        // First Column
        List<Double> column1 = data.stream()
                .filter(nested -> !nested.isEmpty() && nested.size() > 2)
                .map(nested -> nested.get(0))
                .collect(Collectors.toList());
        double range1 = Processing1().get(0) - Processing1().get(3);
        double min1 = Processing1().get(3);
        List<Double> minMaxForColumn1 = column1.stream()
                .map(value -> (value - min1) / range1)
                .collect(Collectors.toList());


        // Second Column
        List<Double> column2 = data.stream()
                .filter(nested -> !nested.isEmpty() && nested.size() > 2)
                .map(nested -> nested.get(1))
                .collect(Collectors.toList());
        double range2 = Processing1().get(1) - Processing1().get(4);
        double min2 = Processing1().get(4);
        List<Double> minMaxForColumn2 = column2.stream()
                .map(value -> (value - min2) / range2)
                .collect(Collectors.toList());

        // First Column
        List<Double> column3 = data.stream()
                .filter(nested -> !nested.isEmpty() && nested.size() > 2)
                .map(nested -> nested.get(2))
                .collect(Collectors.toList());
        double range3 = Processing1().get(2) - Processing1().get(5);
        double min3 = Processing1().get(5);
        List<Double> minMaxForColumn3 = column3.stream()
                .map(value -> (value - min3) / range3)
                .collect(Collectors.toList());

        return List.of(minMaxForColumn1, minMaxForColumn2, minMaxForColumn3);
    }



}
