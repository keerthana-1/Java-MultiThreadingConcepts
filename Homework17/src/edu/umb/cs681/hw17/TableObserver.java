package edu.umb.cs681.hw17;

public class TableObserver implements Observer<StockEvent>{

    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        System.out.println(event.ticker());
        System.out.println(event.quote());
    }
}
