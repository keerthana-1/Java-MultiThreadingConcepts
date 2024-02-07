package edu.umb.cs681.hw13.Solution;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class DepartureRunnable implements Runnable{

    private TrainScheduler t;
    private ReentrantLock lock=new ReentrantLock();
    private volatile boolean done=false;

    public void setDone(){
        done=true;
    }

    public DepartureRunnable(LinkedList<String> schedule){
        t=new TrainScheduler(schedule);
    }

    @Override
    public void run() {
        while(true) {
            lock.lock();
            try {
                if (done) {
                    System.out.println("set done from departure");
                    break;
                }

                t.updateDeparture("train1");
                Thread.sleep(1000);
            }
            catch (InterruptedException ex){
                System.out.println("interrupted from departure");
            }
            finally {
                lock.unlock();
            }
        }


    }
}
