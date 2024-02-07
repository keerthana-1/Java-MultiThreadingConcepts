package edu.umb.cs681.hw2;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.Random;

public class Person {

    private String firstName;
    private String lastName;
    private LocalDate dob;

    Random random=new Random();
    LinkedList<Person> people=new LinkedList<>();
    LinkedList<Dose> dose=new LinkedList<>();

    public void addPeople(String firstName,String lastName, LocalDate dob, LinkedList<Dose> dose){
       Person p=new Person();
       p.firstName=firstName;
       p.lastName=lastName;
       p.dob=dob;
       p.dose=dose;
       people.add(p);
    }

    public LinkedList<Person> getPeople(){
        return people;
    }
    public int getAge(){
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(this.dob, currentDate);
        int years = period.getYears();
        return years;
    }

    public AgeCat getAgeCat(){
        if(getAge()<=18) {
            return AgeCat.YOUNG;
        }
        else if(getAge()>18 && getAge()<=35 )
        {
            return AgeCat.MID;
        }
        else{
            return AgeCat.OLD;
        }

    }

    public LinkedList<Dose> getDoses(){
        return dose;
    }

    public int getVacCount(){
        return dose.size();
    }


    public void generatePersonInstances(){
        int vacCount=random.nextInt(4) ;
         for(int j=0;j<=vacCount;j++){
            dose.add(generateRandomDose());
        }


        for(int i=0;i<2500;i++){
            addPeople(generateRandomFirstName(),
                    generateRandomLastName(),
                    generateRandomDate(),
                    dose);
        }

    }

    private String generateRandomFirstName() {
        String[] names = {"yamini", "keerthana", "lasya", "harsha", "dhruthi", "preethi", "akanksha"};
        return names[random.nextInt(names.length)];
    }

    private  String generateRandomLastName() {
        String[] names = {"aravapalli", "singh", "nicholas", "williams", "johnson", "wilson", "smith"};
        return names[random.nextInt(names.length)];
    }

    private LocalDate generateRandomDate() {
        long startDay = LocalDate.of(1950, 1, 1).toEpochDay();
        long endDay = LocalDate.of(2005, 12, 31).toEpochDay();
        long randomDay = startDay + random.nextInt((int) (endDay - startDay));
        return LocalDate.ofEpochDay(randomDay);
    }

    private Dose generateRandomDose() {
        Dose d=new Dose();
        d.setVacProductName();
        d.setLotNumber();
        d.setDate();
        d.setVacSite();
        return d;
    }
}
