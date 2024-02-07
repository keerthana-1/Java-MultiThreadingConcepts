package edu.umb.cs681.hw13.Problem;

import java.util.LinkedList;

public class DepartureRunnable implements Runnable{

    private TrainScheduler t;

    public DepartureRunnable(LinkedList<String> schedule){
        t=new TrainScheduler(schedule);
    }

    @Override
    public void run() {

       t.updateDeparture("train1");
    }
}
