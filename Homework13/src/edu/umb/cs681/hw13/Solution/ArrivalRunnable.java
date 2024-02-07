package edu.umb.cs681.hw13.Solution;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class ArrivalRunnable implements Runnable{
    private TrainScheduler t;
    private ReentrantLock lock=new ReentrantLock();
    private volatile boolean done=false;

    public ArrivalRunnable(LinkedList<String> schedule){

        t=new TrainScheduler(schedule);
    }

    public void setDone(){
        done=true;
    }

    @Override
    public void run() {
        while(true) {
            lock.lock();
              try {
                  if (done) {
                      System.out.println("set done");
                      break;
                  }

                  t.addArrival("train1");
                  t.addArrival("train2");
                  t.addArrival("train3");
                  Thread.sleep(1000);
              }
              catch (InterruptedException ex){
                  System.out.println("interrupted");
              }
              finally {
                  lock.unlock();
              }
        }
    }
}
