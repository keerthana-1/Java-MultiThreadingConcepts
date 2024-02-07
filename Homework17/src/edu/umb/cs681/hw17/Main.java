package edu.umb.cs681.hw17;

import edu.umb.cs681.hw17.StockQuoteRunnable;

public class Main {
    public static void main(String[] args) {

        StockQuoteRunnable stockQuoteRunnable=new StockQuoteRunnable();
        for(int i=0;i<10;i++) {
            Thread t = new Thread(stockQuoteRunnable);
            t.start();
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException ex){
                System.out.println(ex.getMessage());
            }
            stockQuoteRunnable.setDone();

            t.interrupt();
        }
    }
}