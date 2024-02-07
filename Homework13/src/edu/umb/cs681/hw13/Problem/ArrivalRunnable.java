package edu.umb.cs681.hw13.Problem;

import java.util.LinkedList;

public class ArrivalRunnable implements Runnable{
    private TrainScheduler t;


    public ArrivalRunnable(LinkedList<String> schedule){

        t=new TrainScheduler(schedule);
    }
    @Override
    public void run() {
        t.addArrival("train1");
        t.addArrival("train2");
        t.addArrival("train3");

    }
}
