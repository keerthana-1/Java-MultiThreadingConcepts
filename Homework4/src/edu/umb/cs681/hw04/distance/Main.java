package edu.umb.cs681.hw04.distance;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
    List<List<Double>> points = generateRandomData(1000, 100);
    System.out.println("Euclidean distance");
    System.out.println(Distance.matrix(points));
    System.out.println();
    System.out.println();
    System.out.println("Manhattan distance");
    System.out.println(Distance.matrix(points, new Manhattan()));
    }
    public static List<List<Double>> generateRandomData(int numPoints, int numDimensions) {
        Random random = new Random();

        return IntStream.range(0, numPoints)
                .mapToObj(i -> DoubleStream.generate(random::nextDouble)
                        .limit(numDimensions)
                        .boxed()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}