package edu.umb.cs681.hw2;

import java.time.LocalDate;
import java.util.Random;

public class Dose {

    private String vacProductName;
    private String lotNumber;

    private LocalDate date;
    private String vacSite;

    Random random=new Random();

    public void setVacProductName(){
        this.vacProductName=generateRandomVacProductName();
    }

    public void setLotNumber(){
        this.lotNumber=generateRandomLotNumber();
    }
    public void setDate(){
        this.date=generateRandomDate();
    }
    public void setVacSite(){
        this.vacSite=generateRandomVacSite();
    }

    public String generateRandomVacProductName() {

        String[] names = {"MMR", "Covaxin", "HepatitisB", "DPT", "Polio", "Flu"};
        return names[random.nextInt(names.length)];
    }

    public String generateRandomVacSite() {
        String[] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        return names[random.nextInt(names.length)];
    }

    public String generateRandomLotNumber() {
        int lotNumber = random.nextInt(100) + 1;
        return String.valueOf(lotNumber);
    }

    public LocalDate generateRandomDate() {

        int year = 2012 + random.nextInt(23);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28);

        LocalDate randomDate = LocalDate.of(year, month, day);
       // System.out.println("Random Date: " + randomDate);
        return randomDate;
    }

}
