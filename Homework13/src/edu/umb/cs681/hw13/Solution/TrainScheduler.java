package edu.umb.cs681.hw13.Solution;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class TrainScheduler {

    private ReentrantLock lock=new ReentrantLock();

    private LinkedList<String> schedule;
    public TrainScheduler(LinkedList<String> schedule){
        this.schedule = schedule;
    }

    public void addArrival(String name){
        lock.lock();
        try {
            schedule.add(name);
            System.out.println("Train " + name + " arrived");
        }finally {
            lock.unlock();
        }
    }

    public void updateDeparture(String name){
        lock.lock();
        try {
            for (String s : schedule) {
                if (s.equals(name)) {
                    schedule.remove(name);
                    System.out.println("Train " + name + " departed");
                    break;
                }
            }
        }
        finally {
            lock.unlock();
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
            Thread.sleep(300);
        }
        catch (InterruptedException ex){
        }
       a.setDone();
       d.setDone();

       t1.interrupt();
       t2.interrupt();

    }
}
