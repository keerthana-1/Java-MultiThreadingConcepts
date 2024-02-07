package edu.umb.cs681.hw13.Problem;

import java.util.LinkedList;
import java.util.List;

public class TrainScheduler {

    private LinkedList<String> schedule;
    public TrainScheduler(LinkedList<String> schedule){
        this.schedule = schedule;
    }

    public void addArrival(String name){
        schedule.add(name);
        System.out.println("Train "+name+" arrived");
    }

    public void updateDeparture(String name){

        for(String s:schedule){
            if(s.equals(name)){
                schedule.remove(name);
                System.out.println("Train "+name+" departed");
                break;
            }
        }

    }

    public static void main(String[] args)  {

        LinkedList<String> schedule=new LinkedList<>();

        ArrivalRunnable a=new ArrivalRunnable(schedule);
        DepartureRunnable d=new DepartureRunnable(schedule);

        Thread t1=new Thread(a);
        Thread t2=new Thread(d);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException ex){

        }
    }
}
