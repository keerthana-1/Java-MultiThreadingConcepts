package edu.umb.cs681.hw17;

import java.util.concurrent.atomic.AtomicBoolean;

public class StockQuoteRunnable implements Runnable{

    private AtomicBoolean done=new AtomicBoolean(false);

    public void setDone(){
        done.getAndSet(true);
    }

    @Override
    public void run() {
        while(!false) {
            if(done.get()){
                System.out.println("set done");
                break;
            }
            StockQuoteObservable s = new StockQuoteObservable();
            s.addObserver(((sender, event) -> System.out.println(event.ticker() + " " + event.quote())));
            s.changeQuote("key1", 20d);
            s.changeQuote("key2", 30d);

            s.addObserver(((sender1, event1) -> System.out.println(event1.ticker() + " " + event1.quote())));
            s.changeQuote("key3", 40d);
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException ex){
                System.out.println(ex.getMessage());
                continue;
            }
        }
    }
}
