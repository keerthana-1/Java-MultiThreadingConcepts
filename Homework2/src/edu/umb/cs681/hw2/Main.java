package edu.umb.cs681.hw2;

import edu.umb.cs681.hw2.AgeCat;
import edu.umb.cs681.hw2.Person;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {

        Person person=new Person();
        person.generatePersonInstances();
        LinkedList<Person> people=person.getPeople();
        //System.out.println(people);
//-----------------------------------
        Map<Boolean, Double> vacCounts=people.stream()
                .collect(partitioningBy(
                        p-> p.getAge()>=18 && p.getVacCount()>=3,
                        averagingDouble(p->p.getVacCount())
                ));

        System.out.println("Number of fully vaccinated people: " + vacCounts.get(true));
        float vacRate1 = (float) (vacCounts.get(true)/people.size() * 100);
        System.out.println(vacRate1);
//-----------------------------------

        Map<AgeCat, Double> ageCategoryVaccinationRate = people.stream()
                .collect(groupingBy(
                        p -> p.getAgeCat(),
                        averagingDouble(p -> p.getVacCount())
                ));

        ageCategoryVaccinationRate.forEach((ageCategory, averageVaccinationRate) -> {
            System.out.println("Age Category: " + ageCategory);
            System.out.println("Average Vaccination Rate: " + (averageVaccinationRate/people.size())*100);
            System.out.println();
        });
//------------------------------------------

        Map<AgeCat, Double> avgAgeCategoryVaccination = people.stream()
                .collect(groupingBy(
                        p -> p.getAgeCat(),
                        averagingDouble(p -> p.getVacCount())
                ));

        avgAgeCategoryVaccination.forEach((ageCategory, averageVaccination) -> {
            System.out.println("Age Category: " + ageCategory);
            System.out.println("Average Number of Vaccinations: " + averageVaccination);
            System.out.println();
        });

//-------------------------------------------

        Map<Boolean, List<Person>> partitionedData = people.stream()
                .collect(partitioningBy(p->p.getDoses().size()>0));

        List<Person> unVaccinatedPeople = partitionedData.get(false);
        System.out.println(unVaccinatedPeople);

         double averageAgeUnVaccinated = unVaccinatedPeople.stream()
                .mapToDouble(p->p.getAge())
                .average()
                .orElse(0.0);

        System.out.println(averageAgeUnVaccinated);


    }
}