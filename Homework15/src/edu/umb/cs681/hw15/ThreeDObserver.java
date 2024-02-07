package edu.umb.cs681.hw15;

public class ThreeDObserver implements Observer<StockEvent>{

    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        System.out.println(event.quote());
    }
}
