package edu.umb.cs681.hw11.fs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    private static AtomicBoolean done = new AtomicBoolean(false);
    private static List<File> sharedFiles = new ArrayList<>();
    public void setDone(){
        done.getAndSet(true);
    }

    public static void main(String[] args) throws InterruptedException {
        CrawlingRunnable1 crawlingRunnable1 = new CrawlingRunnable1(sharedFiles);
        CrawlingRunnable2 crawlingRunnable2 = new CrawlingRunnable2(sharedFiles);
        CrawlingRunnable3 crawlingRunnable3 = new CrawlingRunnable3(sharedFiles);

        Thread crawl1 = new Thread(crawlingRunnable1);
        Thread crawl2 = new Thread(crawlingRunnable2);
        Thread crawl3 = new Thread(crawlingRunnable3);


        crawl1.start();
        crawl2.start();
        crawl3.start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        crawlingRunnable1.setDone();
        crawl1.interrupt();

        crawlingRunnable2.setDone();
        crawl2.interrupt();

        crawlingRunnable3.setDone();
        crawl3.interrupt();

        Thread.sleep(1000);

        crawl1.join();
        crawl2.join();
        crawl3.join();

        for(File f:sharedFiles){
            System.out.println(f.getName());
        }


    }


}
