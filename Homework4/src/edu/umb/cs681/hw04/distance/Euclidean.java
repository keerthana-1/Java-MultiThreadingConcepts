package edu.umb.cs681.hw04.distance;

import java.util.List;
import java.util.stream.IntStream;

public class Euclidean implements edu.umb.cs681.hw04.distance.DistanceMetric {
    public double distance(List<Double> p1, List<Double> p2) {
        // TODO Error handling if p1.size() != p2.size()
        if(!(p1.size() != p2.size())){
            double sumOfSquared = IntStream.range(0,p1.size())
                    .mapToDouble(i->p1.get(i)-p2.get(i))
                    .map(n->n*n)
                    .sum();
            return Math.sqrt(sumOfSquared);
        }
        return 0.0;
    }
}
