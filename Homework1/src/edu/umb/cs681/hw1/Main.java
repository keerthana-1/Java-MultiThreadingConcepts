package edu.umb.cs681.hw1;

import edu.umb.cs681.hw1.Car;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Main {
    public static void main(String[] args) {

        ArrayList<Car> usedCars=new ArrayList<Car>();
        usedCars.add(new Car("toyota","RAV4",5000,2020,42000));
        usedCars.add(new Car("Audi","A7",6000,2019,41000));
        usedCars.add(new Car("Dodge","Viper",7000,2023,85000));
        usedCars.add(new Car("Chevrolet","Corvette",8000,2022,76000));
        usedCars.add(new Car("GMC","Acadia",9000,2021,41000));

        //Collections.sort(usedCars, Comparator.comparing((Car car)-> car.getPrice(),Comparator.reverseOrder()));

        Map<Boolean, List<Car>> sortedCarsByPrice=usedCars.stream()
                .sorted(Comparator.comparing((Car car)-> car.getPrice(),Comparator.reverseOrder()))
                        .collect(Collectors.partitioningBy(
                                (Car car)->car.getPrice()>42000));

        List<Car> highPrice= sortedCarsByPrice.get(true);
        List<Car> lowPrice = sortedCarsByPrice.get(false);


        DoubleSummaryStatistics highPrice_stats =
                highPrice.stream()
                  .collect(Collectors.summarizingDouble(car-> car.getPrice()));

                  System.out.println("Maximum Price Element:"+highPrice_stats.getMax());
                  System.out.println("Minimum Price Element:"+highPrice_stats.getMin());
                  System.out.println("Average price:"+highPrice_stats.getAverage());
                  System.out.println("No.of Elements:"+highPrice_stats.getCount());


        DoubleSummaryStatistics lowPrice_stats =
                lowPrice.stream()
                        .collect(Collectors.summarizingDouble(car-> car.getPrice()));

        System.out.println("Maximum Price Element:"+lowPrice_stats.getMax());
        System.out.println("Minimum Price Element:"+lowPrice_stats.getMin());
        System.out.println("Average price:"+lowPrice_stats.getAverage());
        System.out.println("No.of Elements:"+lowPrice_stats.getCount());



//        Optional<Car> maxElement_high = highPrice.stream()
//                .max(Comparator.comparing((Car car)-> car.getPrice()));
//        System.out.println(maxElement_high.get().getPrice());
//
//        Optional<Car> minElement_high = highPrice.stream()
//                .min(Comparator.comparing((Car car)-> car.getPrice()));
//        System.out.println(minElement_high.get().getPrice());
//
//        long countElement_high = highPrice.stream().count();
//        System.out.println(countElement_high);
//
//        OptionalDouble avg_high = highPrice.stream()
//                .mapToDouble((num)->(double)num.getPrice())
//                .average();
//        System.out.println(avg_high);


//        Optional<Car> maxElement_low = lowPrice.stream()
//                .max(Comparator.comparing((Car car)-> car.getPrice()));
//        System.out.println(maxElement_low.get().getPrice());
//
//        Optional<Car> minElement_low = lowPrice.stream()
//                .min(Comparator.comparing((Car car)-> car.getPrice()));
//        System.out.println(minElement_low.get().getPrice());
//
//        long countElement_low = lowPrice.stream().count();
//        System.out.println(countElement_low);
//
//        OptionalDouble avg_low = lowPrice.stream()
//                .mapToDouble((num)->(double)num.getPrice())
//                .average();
//        System.out.println(avg_low);

//-----------------------------

        Collections.sort(usedCars, Comparator.comparing((Car car)-> car.getYear()));
        Map<Boolean, List<Car>> carsGroupedByYear=usedCars.stream().collect(Collectors.partitioningBy(
                (Car car)->car.getYear()>2021));

        List<Car> high= carsGroupedByYear.get(true);
        List<Car> low = carsGroupedByYear.get(false);

        DoubleSummaryStatistics high_stats =
                high.stream()
                        .collect(Collectors.summarizingDouble(car-> car.getYear()));

        System.out.println("Maximum Year Element:"+high_stats.getMax());
        System.out.println("Minimum Year Element:"+high_stats.getMin());
        System.out.println("Average year:"+high_stats.getAverage());
        System.out.println("No.of Elements:"+high_stats.getCount());

        DoubleSummaryStatistics low_stats =
                low.stream()
                        .collect(Collectors.summarizingDouble(car-> car.getYear()));

        System.out.println("Maximum Year Element:"+low_stats.getMax());
        System.out.println("Minimum Year Element:"+low_stats.getMin());
        System.out.println("Average year:"+low_stats.getAverage());
        System.out.println("No.of Elements:"+low_stats.getCount());

//        Optional<Car> maxYear_high = highPrice.stream()
//                .max(Comparator.comparing((Car car)-> car.getYear()));
//        System.out.println(maxYear_high.get().getYear());
//
//        Optional<Car> minYear_high = highPrice.stream()
//                .min(Comparator.comparing((Car car)-> car.getYear()));
//        System.out.println(minYear_high.get().getYear());
//
//        long countYear_high = highPrice.stream().count();
//        System.out.println(countYear_high);
//
//        OptionalDouble avgYear_high = highPrice.stream()
//                .mapToDouble((num)->(double)num.getYear())
//                .average();
//        System.out.println(avgYear_high);

//        Optional<Car> maxYear_low = lowPrice.stream()
//                .max(Comparator.comparing((Car car)-> car.getYear()));
//        System.out.println(maxYear_low.get().getYear());
//
//        Optional<Car> minYear_low = lowPrice.stream()
//                .min(Comparator.comparing((Car car)-> car.getYear()));
//        System.out.println(minYear_low.get().getYear());
//
//        long countYear_low = lowPrice.stream().count();
//        System.out.println(countYear_low);
//
//        OptionalDouble avgYear_low = lowPrice.stream()
//                .mapToDouble((num)->(double)num.getYear())
//                .average();
//        System.out.println(avgYear_low);


//----------------------------------------------

        Collections.sort(usedCars, Comparator.comparing((Car car)-> car.getMileage()));

        Map<Boolean, List<Car>> carsGroupedByMileage=usedCars.stream().collect(Collectors.partitioningBy(
                (Car car)->car.getMileage()>6000));

        List<Car> highMileage= carsGroupedByMileage.get(true);
        List<Car> lowMileage = carsGroupedByMileage.get(false);


        DoubleSummaryStatistics highMileage_stats =
                highMileage.stream()
                        .collect(Collectors.summarizingDouble(car-> car.getMileage()));

        System.out.println("Maximum Mileage Element:"+highMileage_stats.getMax());
        System.out.println("Minimum Mileage Element:"+highMileage_stats.getMin());
        System.out.println("Average Mileage:"+highMileage_stats.getAverage());
        System.out.println("No.of Elements:"+highMileage_stats.getCount());

        DoubleSummaryStatistics lowMileage_stats =
                lowMileage.stream()
                        .collect(Collectors.summarizingDouble(car-> car.getMileage()));

        System.out.println("Maximum Mileage Element:"+lowMileage_stats.getMax());
        System.out.println("Minimum Mileage Element:"+lowMileage_stats.getMin());
        System.out.println("Average Mileage:"+lowMileage_stats.getAverage());
        System.out.println("No.of Elements:"+lowMileage_stats.getCount());


//        Optional<Car> maxMileage_high = highPrice.stream()
//                .max(Comparator.comparing((Car car)-> car.getMileage()));
//        System.out.println(maxMileage_high.get().getMileage());
//
//        Optional<Car> minMileage_high = highPrice.stream()
//                .min(Comparator.comparing((Car car)-> car.getMileage()));
//        System.out.println(minMileage_high.get().getMileage());
//
//        long countMileage_high = highPrice.stream().count();
//        System.out.println(countMileage_high);
//
//        OptionalDouble avgMileage_high = highPrice.stream()
//                .mapToDouble((num)->(double)num.getMileage())
//                .average();
//        System.out.println(avgMileage_high);

//        Optional<Car> maxMileage_low = lowPrice.stream()
//                .max(Comparator.comparing((Car car)-> car.getMileage()));
//        System.out.println(maxMileage_low.get().getMileage());
//
//        Optional<Car> minMileage_low = lowPrice.stream()
//                .min(Comparator.comparing((Car car)-> car.getMileage()));
//        System.out.println(minMileage_low.get().getMileage());
//
//        long countMileage_low = lowPrice.stream().count();
//        System.out.println(countMileage_low);
//
//        OptionalDouble avgMileage_low = lowPrice.stream()
//                .mapToDouble((num)->(double)num.getMileage())
//                .average();
//        System.out.println(avgMileage_low);


 //-------------------------------------------------------

        for (Car c:usedCars){
            c.setDominationCount(usedCars);
        }

        Collections.sort(usedCars,Comparator.comparing((Car car)-> car.getDominationCount()));

        Map<Boolean, List<Car>> carsGroupedByDominationCnt=usedCars.stream().collect(Collectors.partitioningBy(
                (Car car)->car.getDominationCount()>1));

        List<Car> highDC= carsGroupedByDominationCnt.get(true);
        List<Car> lowDC = carsGroupedByDominationCnt.get(false);

        DoubleSummaryStatistics highDC_stats =
                highDC.stream()
                        .collect(Collectors.summarizingDouble(car-> car.getDominationCount()));

        System.out.println("Maximum DC Element:"+highDC_stats.getMax());
        System.out.println("Minimum DC Element:"+highDC_stats.getMin());
        System.out.println("Average DC:"+highDC_stats.getAverage());
        System.out.println("No.of Elements:"+highDC_stats.getCount());

        DoubleSummaryStatistics lowDC_stats =
                lowDC.stream()
                        .collect(Collectors.summarizingDouble(car-> car.getDominationCount()));

        System.out.println("Maximum DC Element:"+lowDC_stats.getMax());
        System.out.println("Minimum DC Element:"+lowDC_stats.getMin());
        System.out.println("Average DC:"+lowDC_stats.getAverage());
        System.out.println("No.of Elements:"+lowDC_stats.getCount());

//        Optional<Car> maxDc_high = highPrice.stream()
//                .max(Comparator.comparing((Car car)-> car.getDominationCount()));
//        System.out.println(maxDc_high.get().getDominationCount());
//
//        Optional<Car> minDc_high = highPrice.stream()
//                .min(Comparator.comparing((Car car)-> car.getDominationCount()));
//        System.out.println(minDc_high.get().getDominationCount());
//
//        long countDc_high = highPrice.stream().count();
//        System.out.println(countDc_high);
//
//        OptionalDouble avgDc_high = highPrice.stream()
//                .mapToDouble((num)->(double)num.getDominationCount())
//                .average();
//        System.out.println(avgDc_high);
//
//        Optional<Car> maxDc_low = lowPrice.stream()
//                .max(Comparator.comparing((Car car)-> car.getDominationCount()));
//        System.out.println(maxDc_low.get().getDominationCount());
//
//        Optional<Car> minDc_low = lowPrice.stream()
//                .min(Comparator.comparing((Car car)-> car.getDominationCount()));
//        System.out.println(minDc_low.get().getDominationCount());
//
//        long countDc_low = lowPrice.stream().count();
//        System.out.println(countDc_low);
//
//        OptionalDouble avgDc_low = lowPrice.stream()
//                .mapToDouble((num)->(double)num.getDominationCount())
//                .average();
//        System.out.println(avgDc_low);

    }
}