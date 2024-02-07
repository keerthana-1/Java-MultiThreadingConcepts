package edu.umb.cs681.hw14;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class StockQuoteObservable extends Observable<StockEvent>
{
    private ReentrantLock lock=new ReentrantLock();
    Map<String,Double> m= new HashMap<String,Double>();
    public void changeQuote(String t, Double q) {
        lock.lock();
        try {
            m.put(t, q);
            notifyObservers(new StockEvent(t, q));
        }
        finally{
            lock.unlock();
        }
    }

    public Map<String,Double> getMapValues(){
        lock.lock();
        try {
            return m;
        }
        finally {
            lock.unlock();
        }
    }
}
